package com.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LinesDialog extends JDialog {

    private JTextField nameFiledIt;
    private JTextField countFieldIt;
    private JTextField piceFieldIt;
    private JLabel nameItemLb;
    private JLabel countItLb;
    private JLabel priceItLb;
    private JButton addBtn;
    private JButton cancelBtn;

    public LinesDialog(InvoiceFrame myframe) {
        nameFiledIt = new JTextField(20);
        nameItemLb = new JLabel("Item Name");

        countFieldIt = new JTextField(20);
        countItLb = new JLabel("Item Count");

        piceFieldIt = new JTextField(20);
        priceItLb = new JLabel("Item Price");

        addBtn = new JButton("Add");
        cancelBtn = new JButton("Cancel");

        addBtn.setActionCommand("createLineOK");
        cancelBtn.setActionCommand("cancelCreationLine");

        addBtn.addActionListener(myframe.getController());
        cancelBtn.addActionListener(myframe.getController());
        setLayout(new GridLayout(4, 2));

        add(nameItemLb);
        add(nameFiledIt);
        add(countItLb);
        add(countFieldIt);
        add(priceItLb);
        add(piceFieldIt);
        add(addBtn);
        add(cancelBtn);

        pack();
    }

    public JTextField getItemNameField() {
        return nameFiledIt;
    }

    public JTextField getItemCountField() {
        return countFieldIt;
    }

    public JTextField getItemPriceField() {
        return piceFieldIt;
    }
}
