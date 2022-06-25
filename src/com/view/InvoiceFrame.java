package com.view;

import com.controller.Handeler;
import com.model.InvoiceHeader;
import com.model.InvoiceTableModeling;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

public class InvoiceFrame extends javax.swing.JFrame {

    public InvoiceFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        invoiceTable.getSelectionModel().addListSelectionListener(controller);
        invoiceTable.setModel(getInvoicesTableModel());
        newInvoiceBtn = new javax.swing.JButton();
        newInvoiceBtn.addActionListener(controller);
        deleteInvBtn = new javax.swing.JButton();
        deleteInvBtn.addActionListener(controller);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        invTotal = new javax.swing.JLabel();
        customerLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        numLable = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lineTable = new javax.swing.JTable();
        createLineButton = new javax.swing.JButton();
        createLineButton.addActionListener(controller);
        deleteItemBtn = new javax.swing.JButton();
        deleteItemBtn.addActionListener(controller);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadFileMenuItem = new javax.swing.JMenuItem();
        loadFileMenuItem.addActionListener(controller);
        saveFileMenuItem = new javax.swing.JMenuItem();
        saveFileMenuItem.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(242, 242, 242));
        setBounds(new java.awt.Rectangle(1, 1, 1, 1));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        invoiceTable.setBackground(new java.awt.Color(204, 204, 204));
        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        invoiceTable.setGridColor(new java.awt.Color(204, 204, 204));
        invoiceTable.setSelectionBackground(new java.awt.Color(211, 211, 211));
        invoiceTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        invoiceTable.setShowHorizontalLines(false);
        invoiceTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(invoiceTable);

        newInvoiceBtn.setBackground(new java.awt.Color(204, 204, 204));
        newInvoiceBtn.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        newInvoiceBtn.setText("Create New Invoice");

        deleteInvBtn.setBackground(new java.awt.Color(204, 204, 204));
        deleteInvBtn.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        deleteInvBtn.setText("Delete Invoice");
        deleteInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvBtnActionPerformed(evt);
            }
        });

        jLabel1.setBackground(this.getContentPane().getBackground());
        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        jLabel1.setText("Inoice Number");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(this.getContentPane().getBackground());
        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        jLabel2.setText("Invoice Date");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(this.getContentPane().getBackground());
        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        jLabel3.setText("Customer Name");
        jLabel3.setOpaque(true);

        invTotal.setBackground(this.getContentPane().getBackground());
        invTotal.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        invTotal.setText("Invoice Total");
        invTotal.setOpaque(true);

        customerLabel.setBackground(this.getContentPane().getBackground());
        customerLabel.setOpaque(true);

        dateLabel.setBackground(this.getContentPane().getBackground());
        dateLabel.setOpaque(true);

        numLable.setBackground(this.getContentPane().getBackground());
        numLable.setOpaque(true);

        totalLabel.setBackground(this.getContentPane().getBackground());
        totalLabel.setOpaque(true);

        jScrollPane2.setBackground(this.getContentPane().getBackground());

        lineTable.setBackground(this.getContentPane().getBackground());
        lineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(lineTable);

        createLineButton.setBackground(new java.awt.Color(204, 204, 204));
        createLineButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        createLineButton.setText("New Item");
        createLineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createLineButtonActionPerformed(evt);
            }
        });

        deleteItemBtn.setBackground(new java.awt.Color(204, 204, 204));
        deleteItemBtn.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        deleteItemBtn.setText("Delete Item");

        jMenu1.setText("File");

        loadFileMenuItem.setText("Load File");
        jMenu1.add(loadFileMenuItem);

        saveFileMenuItem.setText("Save File");
        jMenu1.add(saveFileMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(newInvoiceBtn)
                        .addGap(131, 131, 131)
                        .addComponent(deleteInvBtn)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(invTotal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(totalLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(numLable))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(customerLabel)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(createLineButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteItemBtn)
                        .addGap(133, 133, 133))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(numLable))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(dateLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(customerLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invTotal)
                            .addComponent(totalLabel))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteInvBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newInvoiceBtn)
                        .addComponent(createLineButton)
                        .addComponent(deleteItemBtn)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvBtnActionPerformed
        
    }//GEN-LAST:event_deleteInvBtnActionPerformed

    private void createLineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createLineButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createLineButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createLineButton;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton deleteInvBtn;
    private javax.swing.JButton deleteItemBtn;
    private javax.swing.JLabel invTotal;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable lineTable;
    private javax.swing.JMenuItem loadFileMenuItem;
    private javax.swing.JButton newInvoiceBtn;
    private javax.swing.JLabel numLable;
    private javax.swing.JMenuItem saveFileMenuItem;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
    private ArrayList<InvoiceHeader> invoices;
    private Handeler controller = new Handeler(this);
    private InvoiceTableModeling invoicesTableModel;

    public ArrayList<InvoiceHeader> getInvoices() {
        if (invoices == null) invoices = new ArrayList<>();
        
        return invoices;
    }

    public void setInvoices(ArrayList<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }

    public InvoiceTableModeling getInvoicesTableModel() {
        if (invoicesTableModel == null) {
            invoicesTableModel = new InvoiceTableModeling(getInvoices());
        }
        return invoicesTableModel;
    }

    public void setInvoicesTableModel(InvoiceTableModeling invoicesTableModel) {
        this.invoicesTableModel = invoicesTableModel;
    }

    public JLabel getCustomerNameLabel() {
        return customerLabel;
    }

    public JLabel getInvoiceDateLabel() {
        return dateLabel;
    }

    public JLabel getInvoiceNumLabel() {
        return numLable;
    }

    public JTable getInvoiceTable() {
        return invoiceTable;
    }

    public JLabel getInvoiceTotalLabel() {
        return totalLabel;
    }

    public JTable getLineTable() {
        return lineTable;
    }

    public Handeler getController() {
        return controller;
    }

    public int getNextInvoiceNum() {
        int num = 0;

        for (InvoiceHeader invoice : getInvoices()) {
            if (invoice.getNum() > num) {
                num = invoice.getNum();
            }
        }

        return ++num;
    }

}
