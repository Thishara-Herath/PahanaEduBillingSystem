package com.pahanaedu.util;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection conn = DBUtil.getInstance().getConnection();
        if (conn != null) {
            System.out.println("Connection successful!");
            DBUtil.getInstance().closeConnection();
        } else {
            System.out.println("Connection failed.");
        }
    }
}