package com.example.keep.service;

import com.example.keep.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> findByUsername(String username);
    int addUser(User user);
    int deleteById(int id);
    int updateById(User user);
}
