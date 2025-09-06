package com.pahanaedu.service.impl;

import com.pahanaedu.dao.CustomerDAO;
import com.pahanaedu.dao.DAOFactory;
import com.pahanaedu.model.Customer;
import com.pahanaedu.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDAO customerDAO = DAOFactory.getCustomerDAO();

    @Override
    public void addCustomer(Customer customer) {
        validateCustomer(customer);
        customerDAO.addCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        validateCustomer(customer);
        customerDAO.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        customerDAO.deleteCustomer(accountNumber);
    }

    @Override
    public Customer getCustomer(String accountNumber) {
        return customerDAO.getCustomer(accountNumber);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    private void validateCustomer(Customer customer) {
        if (customer.getAccountNumber() == null || customer.getAccountNumber().isEmpty()) {
            throw new IllegalArgumentException("Account number is required");
        }
        if (customer.getName() == null || customer.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        // Add more validations as needed
    }
}