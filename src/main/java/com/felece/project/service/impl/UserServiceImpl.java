package com.felece.project.service.impl;

import com.felece.project.entity.User;
import com.felece.project.repository.UserRepository;
import com.felece.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUserId(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User updateOneUser(Long userId, User newUser) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getAdminUser() {

        return userRepository.findByUsername("admin");
    }
}
