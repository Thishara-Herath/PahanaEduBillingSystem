package com.pahanaedu.servlet;

import com.pahanaedu.model.Item;
import com.pahanaedu.service.ItemService;
import com.pahanaedu.service.impl.ItemServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


public class ItemServlet extends HttpServlet {
    private ItemService itemService = new ItemServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        if (action == null) action = "/list";

        switch (action) {
            case "/add":
                request.getRequestDispatcher("/item-form.jsp").forward(request, response);
                break;
            case "/edit":
                int id = Integer.parseInt(request.getParameter("id"));
                Item item = itemService.getItem(id);
                request.setAttribute("item", item);
                request.getRequestDispatcher("/item-form.jsp").forward(request, response);
                break;
            case "/delete":
                int idDel = Integer.parseInt(request.getParameter("id"));
                itemService.deleteItem(idDel);
                response.sendRedirect(request.getContextPath() + "/items/list");
                break;
            case "/list":
            default:
                List<Item> items = itemService.getAllItems();
                request.setAttribute("items", items);
                request.getRequestDispatcher("/item-list.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        Item item = new Item(name, description, price, stock);
        item.setId(id);

        if (request.getParameter("action").equals("add")) {
            itemService.addItem(item);
        } else {
            itemService.updateItem(item);
        }

        response.sendRedirect(request.getContextPath() + "/items/list");
    }
}