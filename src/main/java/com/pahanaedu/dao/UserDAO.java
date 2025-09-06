package com.pahanaedu.dao;

import com.pahanaedu.model.User;

public interface UserDAO {
    User authenticate(String username, String password);
    // Add more if needed, e.g., addUser
}