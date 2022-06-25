package com.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InvoicesDialog extends JDialog {

    private JTextField customerName;
    private JTextField invoiceDateFiled;
    private JLabel customerNameLb;
    private JLabel invoiceDateLb;
    private JButton addBtn;
    private JButton cancelBtn;

    public InvoicesDialog(InvoiceFrame myframe) {
        customerNameLb = new JLabel("Customer Name:");
        customerName = new JTextField(20);
        invoiceDateLb = new JLabel("Invoice Date:");
        invoiceDateFiled = new JTextField(20);
        addBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");

        addBtn.setActionCommand("createInvoice");
        cancelBtn.setActionCommand("CancelCreationInv");

        addBtn.addActionListener(myframe.getController());
        cancelBtn.addActionListener(myframe.getController());
        setLayout(new GridLayout(3, 2));

        add(invoiceDateLb);
        add(invoiceDateFiled);
        add(customerNameLb);
        add(customerName);
        add(addBtn);
        add(cancelBtn);

        pack();

    }

    public JTextField getCustNameField() {
        return customerName;
    }

    public JTextField getInvDateField() {
        return invoiceDateFiled;
    }

}
