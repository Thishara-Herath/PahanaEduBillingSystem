package com.pahanaedu.dao.impl;

import com.pahanaedu.dao.BillDAO;
import com.pahanaedu.model.Bill;
import com.pahanaedu.model.BillItem;
import com.pahanaedu.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAOImpl implements BillDAO {
    @Override
    public void createBill(Bill bill, List<BillItem> billItems) {
        Connection conn = DBUtil.getInstance().getConnection();
        try {
            conn.setAutoCommit(false);

            // Insert bill
            String billSql = "INSERT INTO bills (account_number, bill_date, units, amount, status) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(billSql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, bill.getAccountNumber());
                pstmt.setDate(2, new java.sql.Date(bill.getBillDate().getTime()));
                pstmt.setDouble(3, bill.getUnits());
                // Call DB function for amount
                double amount = getCalculatedAmount(conn, bill.getUnits());
                pstmt.setDouble(4, amount);
                pstmt.setString(5, bill.getStatus());
                pstmt.executeUpdate();

                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    bill.setId(rs.getInt(1));
                }
            }

            // Insert bill items
            String itemSql = "INSERT INTO bill_items (bill_id, item_id, quantity, subtotal) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmtItem = conn.prepareStatement(itemSql)) {
                for (BillItem item : billItems) {
                    pstmtItem.setInt(1, bill.getId());
                    pstmtItem.setInt(2, item.getItemId());
                    pstmtItem.setInt(3, item.getQuantity());
                    pstmtItem.setDouble(4, item.getSubtotal());
                    pstmtItem.addBatch();
                }
                pstmtItem.executeBatch();
            }

            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private double getCalculatedAmount(Connection conn, double units) throws SQLException {
        String funcSql = "SELECT CalculateBillAmount(?) AS amount";
        try (PreparedStatement pstmt = conn.prepareStatement(funcSql)) {
            pstmt.setDouble(1, units);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("amount");
            }
        }
        return 0.0;
    }

    // Implement getBill, getBillsForCustomer similarly using PreparedStatements and mapping to models
    @Override
    public Bill getBill(int id) {
        Connection conn = DBUtil.getInstance().getConnection();
        Bill bill = null;
        String billSql = "SELECT * FROM bills WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(billSql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bill = mapToBill(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (bill != null) {
            bill.setBillItems(getBillItems(bill.getId(), conn));
        }
        return bill;
    }

    @Override
    public List<Bill> getBillsForCustomer(String accountNumber) {
        List<Bill> bills = new ArrayList<>();
        Connection conn = DBUtil.getInstance().getConnection();
        String sql = "SELECT * FROM bills WHERE account_number = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Bill bill = mapToBill(rs);
                bill.setBillItems(getBillItems(bill.getId(), conn));
                bills.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bills;
    }

    private List<BillItem> getBillItems(int billId, Connection conn) {
        List<BillItem> items = new ArrayList<>();
        String sql = "SELECT * FROM bill_items WHERE bill_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, billId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BillItem item = new BillItem();
                item.setBillId(rs.getInt("bill_id"));
                item.setItemId(rs.getInt("item_id"));
                item.setQuantity(rs.getInt("quantity"));
                item.setSubtotal(rs.getDouble("subtotal"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    private Bill mapToBill(ResultSet rs) throws SQLException {
        Bill bill = new Bill();
        bill.setId(rs.getInt("id"));
        bill.setAccountNumber(rs.getString("account_number"));
        bill.setBillDate(rs.getDate("bill_date"));
        bill.setUnits(rs.getDouble("units"));
        bill.setAmount(rs.getDouble("amount"));
        bill.setStatus(rs.getString("status"));
        return bill;
    }


}