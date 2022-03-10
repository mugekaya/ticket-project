package com.felece.project.service;

import com.felece.project.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);

    //  User findByUserName(String userName);

    List<User> getAllUsers();

    User findUserByUserId(Long userId);

    User updateOneUser(Long userId, User newUser);

    void deleteById(Long id);

    User getAdminUser();
}
