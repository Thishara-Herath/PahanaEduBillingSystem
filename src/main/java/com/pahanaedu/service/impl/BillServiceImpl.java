package com.pahanaedu.service.impl;

import com.pahanaedu.dao.BillDAO;
import com.pahanaedu.dao.DAOFactory;
import com.pahanaedu.dao.ItemDAO;
import com.pahanaedu.model.Bill;
import com.pahanaedu.model.BillItem;
import com.pahanaedu.model.Item;
import com.pahanaedu.service.BillService;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

public class BillServiceImpl implements BillService {
    private BillDAO billDAO = DAOFactory.getBillDAO();
    private ItemDAO itemDAO = DAOFactory.getItemDAO();

    @Override
    public void generateBill(Bill bill, List<BillItem> billItems) {
        double totalUnits = 0;
        double totalAmount = 0;

        for (BillItem billItem : billItems) {
            Item item = itemDAO.getItem(billItem.getItemId());
            if (item == null) {
                throw new IllegalArgumentException("Invalid item ID: " + billItem.getItemId());
            }
            if (item.getStock() < billItem.getQuantity()) {
                throw new IllegalArgumentException("Insufficient stock for item: " + item.getName());
            }

            double subtotal = billItem.getQuantity() * item.getPrice();
            billItem.setSubtotal(subtotal);
            totalUnits += billItem.getQuantity();  // Units as quantity sum
            totalAmount += subtotal;

            // Update stock
            item.setStock(item.getStock() - billItem.getQuantity());
            itemDAO.updateItem(item);
        }

        bill.setUnits(totalUnits);
        bill.setAmount(totalAmount);  // Override DB function if needed; else use DB calc

        billDAO.createBill(bill, billItems);
    }

    @Override
    public Bill getBill(int id) {
        return billDAO.getBill(id);
    }

    @Override
    public List<Bill> getBillsForCustomer(String accountNumber) {
        return billDAO.getBillsForCustomer(accountNumber);
    }


    /*public static void main(String[] args) {
        BillServiceImpl billService = new BillServiceImpl();

        // Create sample bill
        Bill bill = new Bill();
        bill.setAccountNumber("ACC001");
        bill.setBillDate(new java.util.Date());
        bill.setStatus("Pending");

        // Create sample bill items (using existing item IDs 1 and 2 from sample data)
        List<BillItem> billItems = new ArrayList<>();
        billItems.add(new BillItem(0, 1, 2, 0));  // Item ID 1, quantity 2
        billItems.add(new BillItem(0, 2, 1, 0));  // Item ID 2, quantity 1

        // Generate the bill
        billService.generateBill(bill, billItems);

        // Retrieve the generated bill (ID is now set)
        Bill retrievedBill = billService.getBill(bill.getId());

        // Print details
        System.out.println("Generated Bill: " + retrievedBill);
        if (retrievedBill.getBillItems() != null) {
            System.out.println("Bill Items:");
            for (BillItem item : retrievedBill.getBillItems()) {
                System.out.println(item);
            }
        } else {
            System.out.println("No bill items found.");
        }
    } */
}