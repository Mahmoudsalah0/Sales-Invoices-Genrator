package com.controller;

import com.model.InvoiceHeader;
import com.model.InvoiceTableModeling;
import com.model.InvoiceLine;
import com.model.LineTableModeling;
import com.view.InvoicesDialog;
import com.view.InvoiceFrame;
import com.view.LinesDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Handeler implements ActionListener, ListSelectionListener {

    private InvoiceFrame myframe;
    private InvoicesDialog invDialoge;
    private LinesDialog invLineDialoge;

    public Handeler(InvoiceFrame iframe) {
        this.myframe = iframe;
    }

    @Override
    public void actionPerformed(ActionEvent x) {

        String actionCommand = x.getActionCommand();
        System.out.println("Action: " + actionCommand);
        switch (actionCommand) {
            case "Load File":
                loadFile();
                break;
            case "Save File":
                saveFile();
                break;
            case "Create New Invoice":
                createNewInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "New Item":
                AddNewItem();
                break;
            case "Delete Item":
                deleteItem();
                break;
            case "CancelCreationInv":
                CancelCreationInv();
                break;
            case "createInvoice":
                createInvoice();
                break;
            case "createLineOK":
                createLineOK();
                break;
            case "cancelCreationLine":
                cancelCreationLine();
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent y) {
        int selectedIndex = myframe.getInvoiceTable().getSelectedRow();
        if (selectedIndex != -1) {
            System.out.println("Your selectetion row is :" + selectedIndex);
            InvoiceHeader currentInvoice = myframe.getInvoices().get(selectedIndex);
            myframe.getInvoiceNumLabel().setText("" + currentInvoice.getNum());
            myframe.getInvoiceDateLabel().setText(currentInvoice.getDate());
            myframe.getCustomerNameLabel().setText(currentInvoice.getCustomer());
            myframe.getInvoiceTotalLabel().setText("" + currentInvoice.getInvoiceTotal());
            LineTableModeling linesTableModel = new LineTableModeling(currentInvoice.getLines());
            myframe.getLineTable().setModel(linesTableModel);
            linesTableModel.fireTableDataChanged();
        }
    }

    private void loadFile() {
        JFileChooser uploadFile = new JFileChooser("d:\\");
        uploadFile.setAcceptAllFileFilterUsed(false);
        uploadFile.addChoosableFileFilter(new FileNameExtensionFilter("Excel Files(CSV)", "csv"));
        try {
            int result = uploadFile.showOpenDialog(myframe);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = uploadFile.getSelectedFile();
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerMainLines = Files.readAllLines(headerPath);
                System.out.println("Invoices Header updated Successfully !");

                ArrayList<InvoiceHeader> invoicesArray = new ArrayList<>();
                for (String headerMainLine : headerMainLines) {
                    try {
                        String[] headerParts = headerMainLine.split(",");
                        int invoiceNum = Integer.parseInt(headerParts[0]);
                        String invoiceDate = headerParts[1];
                        String customerName = headerParts[2];

                        InvoiceHeader invoice = new InvoiceHeader(invoiceNum, invoiceDate, customerName);
                        invoicesArray.add(invoice);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                result = uploadFile.showOpenDialog(myframe);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = uploadFile.getSelectedFile();
                    Path linePath = Paths.get(lineFile.getAbsolutePath());
                    List<String> headersLinesLine = Files.readAllLines(linePath);
                    System.out.println("Invoices Lines updated successfully!");
                    for (String headerLine : headersLinesLine) {
                        try {
                            String lineParts[] = headerLine.split(",");
                            int invNum = Integer.parseInt(lineParts[0]);
                            String item = lineParts[1];
                            double price = Double.parseDouble(lineParts[2]);
                            int count = Integer.parseInt(lineParts[3]);
                            InvoiceHeader newInv = null;
                            for (InvoiceHeader invoice : invoicesArray) {
                                if (invoice.getNum() == invNum) {
                                    newInv = invoice;
                                    break;
                                }
                            }

                            InvoiceLine newLine = new InvoiceLine(item, price, count, newInv);
                            newInv.getLines().add(newLine);
                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                    System.out.println("Check point");
                }
                myframe.setInvoices(invoicesArray);
                InvoiceTableModeling invoicesTableModel = new InvoiceTableModeling(invoicesArray);
                myframe.setInvoicesTableModel(invoicesTableModel);
                myframe.getInvoiceTable().setModel(invoicesTableModel);
                myframe.getInvoicesTableModel().fireTableDataChanged();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFile() {
        ArrayList<InvoiceHeader> invoices = myframe.getInvoices();
        String headersHeader = "";
        String linesLine = "";
        for (InvoiceHeader invoice : invoices) {
            String invoicesCSV = invoice.getAsCSV();
            headersHeader += invoicesCSV;
            headersHeader += "\n";

            for (InvoiceLine line1 : invoice.getLines()) {
                String lineCSV = line1.getAsCSV();
                linesLine += lineCSV;
                linesLine += "\n";
            }
        }
        System.out.println("Check Success point");
        try {
            JFileChooser saveFile = new JFileChooser("d:\\");
            int returnValue = saveFile.showSaveDialog(myframe);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File headerFile = saveFile.getSelectedFile();
                FileWriter InvFileWriter = new FileWriter(headerFile);
                InvFileWriter.write(headersHeader);
                InvFileWriter.flush();
                InvFileWriter.close();
                returnValue = saveFile.showSaveDialog(myframe);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File lineFile = saveFile.getSelectedFile();
                    FileWriter lineFileWriter = new FileWriter(lineFile);
                    lineFileWriter.write(linesLine);
                    lineFileWriter.flush();
                    lineFileWriter.close();
                }
            }
        } catch (Exception e) {

        }
    }

    private void createNewInvoice() {
        invDialoge = new InvoicesDialog(myframe);
        invDialoge.setVisible(true);
    }

    private void deleteInvoice() {
        int selectionRow = myframe.getInvoiceTable().getSelectedRow();
        if (selectionRow != -1) {
            myframe.getInvoices().remove(selectionRow);
            myframe.getInvoicesTableModel().fireTableDataChanged();
        }
    }

    private void AddNewItem() {
        invLineDialoge = new LinesDialog(myframe);
        invLineDialoge.setVisible(true);
    }

    private void deleteItem() {
        int selectionRow = myframe.getLineTable().getSelectedRow();

        if (selectionRow != -1) {
            LineTableModeling linesTableModel = (LineTableModeling) myframe.getLineTable().getModel();
            linesTableModel.getLines().remove(selectionRow);
            linesTableModel.fireTableDataChanged();
            myframe.getInvoicesTableModel().fireTableDataChanged();
        }
    }

    private void CancelCreationInv() {
        invDialoge.setVisible(false);
        invDialoge.dispose();
        invDialoge = null;
    }

    private void createInvoice() {
        String dateInv = invDialoge.getInvDateField().getText();
        String customerName = invDialoge.getCustNameField().getText();
        int numberInv = myframe.getNextInvoiceNum();
        try {
            String[] dateSplits = dateInv.split("-");
            if (dateSplits.length < 3) {

                JOptionPane.showMessageDialog(myframe, "Please enter a valid Date ", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                int dayDate = Integer.parseInt(dateSplits[0]);
                int monthDate = Integer.parseInt(dateSplits[1]);
                int yearDate = Integer.parseInt(dateSplits[2]);
                if (dayDate > 31 || monthDate > 12) {
                    JOptionPane.showMessageDialog(myframe, "Please enter a valid Date ", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    InvoiceHeader invoice = new InvoiceHeader(numberInv, dateInv, customerName);
                    myframe.getInvoices().add(invoice);
                    myframe.getInvoicesTableModel().fireTableDataChanged();
                    invDialoge.setVisible(false);
                    invDialoge.dispose();
                    invDialoge = null;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(myframe, "Please enter a valid Date ", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void createLineOK() {
        String nwItem = invLineDialoge.getItemNameField().getText();
        String count = invLineDialoge.getItemCountField().getText();
        String nwPrice = invLineDialoge.getItemPriceField().getText();
        int counts = Integer.parseInt(count);
        double prices = Double.parseDouble(nwPrice);
        int selectedInvoice = myframe.getInvoiceTable().getSelectedRow();
        if (selectedInvoice != -1) {

            InvoiceHeader newInvoice = myframe.getInvoices().get(selectedInvoice);
            InvoiceLine newLine = new InvoiceLine(nwItem, prices, counts, newInvoice);
            newInvoice.getLines().add(newLine);
            LineTableModeling linesTableModel = (LineTableModeling) myframe.getLineTable().getModel();

            linesTableModel.fireTableDataChanged();
            myframe.getInvoicesTableModel().fireTableDataChanged();

        }

        invLineDialoge.setVisible(false);
        invLineDialoge.dispose();
        invLineDialoge = null;
    }

    private void cancelCreationLine() {
        invLineDialoge.setVisible(false);
        invLineDialoge.dispose();
        invLineDialoge = null;
    }

}
