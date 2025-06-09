package com.studentshub.service;

import com.studentshub.model.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    User getUserByUsername(String username);
    User updateUser(User user);
    void deleteUser(Long id);
}

