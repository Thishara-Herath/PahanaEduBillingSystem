package com.pahanaedu.model;

public class Customer {
    private String accountNumber;
    private String name;
    private String address;
    private String telephone;
    private double unitsConsumed;

    // Constructors
    public Customer() {}
    public Customer(String accountNumber, String name, String address, String telephone, double unitsConsumed) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.unitsConsumed = unitsConsumed;
    }

    // Getters and Setters
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public double getUnitsConsumed() { return unitsConsumed; }
    public void setUnitsConsumed(double unitsConsumed) { this.unitsConsumed = unitsConsumed; }

    @Override
    public String toString() {
        return "Customer{accountNumber='" + accountNumber + "', name='" + name + "', address='" + address + "', telephone='" + telephone + "', unitsConsumed=" + unitsConsumed + "}";
    }
}