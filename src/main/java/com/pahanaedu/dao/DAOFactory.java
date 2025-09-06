package com.pahanaedu.dao;

import com.pahanaedu.dao.impl.BillDAOImpl;
import com.pahanaedu.dao.impl.CustomerDAOImpl;
import com.pahanaedu.dao.impl.ItemDAOImpl;
import com.pahanaedu.dao.impl.UserDAOImpl;

public class DAOFactory {
    public static UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    public static CustomerDAO getCustomerDAO() {
        return new CustomerDAOImpl();
    }

    public static ItemDAO getItemDAO() {
        return new ItemDAOImpl();
    }

    public static BillDAO getBillDAO() {
        return new BillDAOImpl();
    }
}