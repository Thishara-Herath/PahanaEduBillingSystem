package com.pahanaedu.model;

import java.util.Date;
import java.util.List;

public class Bill {
    private int id;
    private String accountNumber;
    private Date billDate;
    private double units;
    private double amount;
    private String status;
    private List<BillItem> billItems;  // For detailed items in the bill

    // Constructors
    public Bill() {}
    public Bill(String accountNumber, Date billDate, double units, double amount, String status) {
        this.accountNumber = accountNumber;
        this.billDate = billDate;
        this.units = units;
        this.amount = amount;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public Date getBillDate() { return billDate; }
    public void setBillDate(Date billDate) { this.billDate = billDate; }
    public double getUnits() { return units; }
    public void setUnits(double units) { this.units = units; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<BillItem> getBillItems() { return billItems; }
    public void setBillItems(List<BillItem> billItems) { this.billItems = billItems; }

    @Override
    public String toString() {
        return "Bill{id=" + id + ", accountNumber='" + accountNumber + "', billDate=" + billDate + ", units=" + units + ", amount=" + amount + ", status='" + status + "'}";
    }
}