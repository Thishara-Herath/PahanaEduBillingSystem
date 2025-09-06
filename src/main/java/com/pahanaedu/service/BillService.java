package com.pahanaedu.service;

import com.pahanaedu.model.Bill;
import com.pahanaedu.model.BillItem;

import java.util.List;

public interface BillService {
    void generateBill(Bill bill, List<BillItem> billItems);
    Bill getBill(int id);
    List<Bill> getBillsForCustomer(String accountNumber);
}