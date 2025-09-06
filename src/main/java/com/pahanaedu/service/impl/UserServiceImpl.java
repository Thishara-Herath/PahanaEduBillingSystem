package com.pahanaedu.service.impl;

import com.pahanaedu.dao.DAOFactory;
import com.pahanaedu.dao.UserDAO;
import com.pahanaedu.model.User;
import com.pahanaedu.service.UserService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = DAOFactory.getUserDAO();

    @Override
    public User login(String username, String password) {
        String hashedPassword = hashPassword(password);
        return userDAO.authenticate(username, hashedPassword);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return password;  // Fallback, not secure
        }
    }
}