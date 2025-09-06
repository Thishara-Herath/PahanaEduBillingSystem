package com.pahanaedu.service.impl;

import com.pahanaedu.dao.DAOFactory;
import com.pahanaedu.dao.ItemDAO;
import com.pahanaedu.model.Item;
import com.pahanaedu.service.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    private ItemDAO itemDAO = DAOFactory.getItemDAO();

    @Override
    public void addItem(Item item) {
        validateItem(item);
        itemDAO.addItem(item);
    }

    @Override
    public void updateItem(Item item) {
        validateItem(item);
        itemDAO.updateItem(item);
    }

    @Override
    public void deleteItem(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid item ID");
        }
        itemDAO.deleteItem(id);
    }

    @Override
    public Item getItem(int id) {
        return itemDAO.getItem(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemDAO.getAllItems();
    }

    private void validateItem(Item item) {
        if (item.getName() == null || item.getName().isEmpty()) {
            throw new IllegalArgumentException("Item name is required");
        }
        if (item.getPrice() < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (item.getStock() < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
    }
}