package com.pahanaedu.model;

public class BillItem {
    private int billId;
    private int itemId;
    private int quantity;
    private double subtotal;

    // Constructors
    public BillItem() {}
    public BillItem(int billId, int itemId, int quantity, double subtotal) {
        this.billId = billId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    // Getters and Setters
    public int getBillId() { return billId; }
    public void setBillId(int billId) { this.billId = billId; }
    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    @Override
    public String toString() {
        return "BillItem{billId=" + billId + ", itemId=" + itemId + ", quantity=" + quantity + ", subtotal=" + subtotal + "}";
    }
}