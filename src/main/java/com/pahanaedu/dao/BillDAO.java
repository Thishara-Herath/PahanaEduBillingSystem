package com.pahanaedu.dao;

import com.pahanaedu.model.Bill;
import com.pahanaedu.model.BillItem;

import java.util.List;

public interface BillDAO {
    void createBill(Bill bill, List<BillItem> billItems);
    Bill getBill(int id);
    List<Bill> getBillsForCustomer(String accountNumber);
    // Add more as needed
}