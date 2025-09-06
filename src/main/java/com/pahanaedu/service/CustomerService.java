package com.pahanaedu.service;

import com.pahanaedu.model.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(String accountNumber);
    Customer getCustomer(String accountNumber);
    List<Customer> getAllCustomers();
}