package com.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class LineTableModeling extends AbstractTableModel {

    private ArrayList<InvoiceLine> lines;
    private String[] columns = {"ID", "Item Name", "Item Price", "Count", "Item Total"};

    public LineTableModeling(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    public ArrayList<InvoiceLine> getLines() {
        return lines;
    }

    @Override
    public int getRowCount() {
        return lines.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int d) {
        return columns[d];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine line = lines.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return line.getInvoice().getNum();
            case 1:
                return line.getItem();
            case 2:
                return line.getPrice();
            case 3:
                return line.getCount();
            case 4:
                return line.getLineTotal();
            default:
                return "";

        }
    }

}
