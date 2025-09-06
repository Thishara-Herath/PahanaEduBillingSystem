package com.pahanaedu.service;

import com.pahanaedu.model.User;

public interface UserService {
    User login(String username, String password);
    // Add more if needed, e.g., registerUser
}