package com.pahanaedu.servlet;

import com.pahanaedu.model.Customer;
import com.pahanaedu.service.CustomerService;
import com.pahanaedu.service.impl.CustomerServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        if (action == null) action = "/list";

        switch (action) {
            case "/add":
                request.getRequestDispatcher("/customer-form.jsp").forward(request, response);
                break;
            case "/edit":
                String accNo = request.getParameter("accNo");
                Customer customer = customerService.getCustomer(accNo);
                request.setAttribute("customer", customer);
                request.getRequestDispatcher("/customer-form.jsp").forward(request, response);
                break;
            case "/delete":
                String accNoDel = request.getParameter("accNo");
                customerService.deleteCustomer(accNoDel);
                response.sendRedirect(request.getContextPath() + "/customers/list");
                break;
            case "/list":
            default:
                List<Customer> customers = customerService.getAllCustomers();
                request.setAttribute("customers", customers);
                request.getRequestDispatcher("/customer-list.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accNo = request.getParameter("accountNumber");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        double units = Double.parseDouble(request.getParameter("unitsConsumed"));

        Customer customer = new Customer(accNo, name, address, telephone, units);

        if (request.getParameter("action").equals("add")) {
            customerService.addCustomer(customer);
        } else {
            customerService.updateCustomer(customer);
        }

        response.sendRedirect(request.getContextPath() + "/customers/list");
    }
}