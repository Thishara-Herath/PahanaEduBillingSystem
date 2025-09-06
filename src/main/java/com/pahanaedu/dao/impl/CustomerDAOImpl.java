package com.pahanaedu.dao.impl;

import com.pahanaedu.dao.CustomerDAO;
import com.pahanaedu.model.Customer;
import com.pahanaedu.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public void addCustomer(Customer customer) {
        Connection conn = DBUtil.getInstance().getConnection();
        String sql = "{CALL AddCustomer(?, ?, ?, ?, ?)}";
        try (CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, customer.getAccountNumber());
            cstmt.setString(2, customer.getName());
            cstmt.setString(3, customer.getAddress());
            cstmt.setString(4, customer.getTelephone());
            cstmt.setDouble(5, customer.getUnitsConsumed());
            cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        Connection conn = DBUtil.getInstance().getConnection();
        String sql = "{CALL UpdateCustomer(?, ?, ?, ?, ?)}";
        try (CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, customer.getAccountNumber());
            cstmt.setString(2, customer.getName());
            cstmt.setString(3, customer.getAddress());
            cstmt.setString(4, customer.getTelephone());
            cstmt.setDouble(5, customer.getUnitsConsumed());
            cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(String accountNumber) {
        Connection conn = DBUtil.getInstance().getConnection();
        String sql = "DELETE FROM customers WHERE account_number = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, accountNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomer(String accountNumber) {
        Connection conn = DBUtil.getInstance().getConnection();
        String sql = "SELECT * FROM customers WHERE account_number = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapToCustomer(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        Connection conn = DBUtil.getInstance().getConnection();
        String sql = "SELECT * FROM customers";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                customers.add(mapToCustomer(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    private Customer mapToCustomer(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setAccountNumber(rs.getString("account_number"));
        customer.setName(rs.getString("name"));
        customer.setAddress(rs.getString("address"));
        customer.setTelephone(rs.getString("telephone"));
        customer.setUnitsConsumed(rs.getDouble("units_consumed"));
        return customer;
    }
}