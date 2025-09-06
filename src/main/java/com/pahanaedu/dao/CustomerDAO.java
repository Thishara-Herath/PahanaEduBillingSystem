package com.pahanaedu.dao;

import com.pahanaedu.model.Customer;

import java.util.List;

public interface CustomerDAO {
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(String accountNumber);
    Customer getCustomer(String accountNumber);
    List<Customer> getAllCustomers();
}