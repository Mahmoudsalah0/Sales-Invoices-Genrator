package com.model;

import java.util.ArrayList;

public class InvoiceHeader {

    private int number;
    private String invDate;
    private String invCustomer;
    private ArrayList<InvoiceLine> lines;

    public InvoiceHeader() {
    }

    public InvoiceHeader(int number, String invDate, String customer) {
        this.number = number;
        this.invDate = invDate;
        this.invCustomer = customer;
    }

    public double getInvoiceTotal() {
        double total = 0.0;
        for (InvoiceLine line : getLines()) {
            total += line.getLineTotal();
        }
        return total;
    }

    public ArrayList<InvoiceLine> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }

    public String getCustomer() {
        return invCustomer;
    }

    public void setCustomer(String customer) {
        this.invCustomer = customer;
    }

    public int getNum() {
        return number;
    }

    public void setNum(int num) {
        this.number = num;
    }

    public String getDate() {
        return invDate;
    }

    public void setDate(String date) {
        this.invDate = date;
    }

    @Override
    public String toString() {
        return "Invoice{" + "num=" + number + ", date=" + invDate + ", customer=" + invCustomer + '}';
    }

    public String getAsCSV() {
        return number + "," + invDate + "," + invCustomer;
    }

}
