package com.pahanaedu.servlet;

import com.pahanaedu.model.Bill;
import com.pahanaedu.model.BillItem;
import com.pahanaedu.model.Customer;
import com.pahanaedu.model.Item;
import com.pahanaedu.service.BillService;
import com.pahanaedu.service.CustomerService;
import com.pahanaedu.service.ItemService;
import com.pahanaedu.service.impl.BillServiceImpl;
import com.pahanaedu.service.impl.CustomerServiceImpl;
import com.pahanaedu.service.impl.ItemServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BillServlet extends HttpServlet {
    private BillService billService = new BillServiceImpl();
    private CustomerService customerService = new CustomerServiceImpl();
    private ItemService itemService = new ItemServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        if (action == null) action = "/list";

        switch (action) {
            case "/generate":
                List<Customer> customers = customerService.getAllCustomers();
                List<Item> items = itemService.getAllItems();
                request.setAttribute("customers", customers);
                request.setAttribute("items", items);
                request.getRequestDispatcher("/bill-form.jsp").forward(request, response);
                break;
            case "/view":
                int billId = Integer.parseInt(request.getParameter("id"));
                Bill bill = billService.getBill(billId);
                request.setAttribute("bill", bill);
                request.getRequestDispatcher("/bill-view.jsp").forward(request, response);
                break;
            case "/list":
            default:
                String accNo = request.getParameter("accNo");  // Optional for specific customer
                List<Bill> bills;
                if (accNo != null) {
                    bills = billService.getBillsForCustomer(accNo);
                } else {
                    // If no accNo, perhaps list all; but for simplicity, redirect or handle
                    bills = new ArrayList<>();  // Implement all bills if needed
                }
                request.setAttribute("bills", bills);
                request.getRequestDispatcher("/bill-list.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accNo = request.getParameter("accountNumber");
        Bill bill = new Bill();
        bill.setAccountNumber(accNo);
        bill.setBillDate(new Date());
        bill.setStatus("Pending");

        List<BillItem> billItems = new ArrayList<>();
        // Assume form sends itemIds and quantities as arrays
        String[] itemIds = request.getParameterValues("itemId");
        String[] quantities = request.getParameterValues("quantity");

        if (itemIds != null && quantities != null) {
            for (int i = 0; i < itemIds.length; i++) {
                int itemId = Integer.parseInt(itemIds[i]);
                int qty = Integer.parseInt(quantities[i]);
                if (qty > 0) {
                    billItems.add(new BillItem(0, itemId, qty, 0));
                }
            }
        }

        billService.generateBill(bill, billItems);

        response.sendRedirect(request.getContextPath() + "/bills/view?id=" + bill.getId());
    }
}