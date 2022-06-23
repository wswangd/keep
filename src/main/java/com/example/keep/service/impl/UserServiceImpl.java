package com.example.keep.service.impl;

import com.example.keep.dao.UserDao;
import com.example.keep.entity.User;
import com.example.keep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public List<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public int addUser(User user) {
        return userDao.addUser(user);
    }

    public int deleteById(int id) {
        return userDao.deleteById(id);
    }

    public int updateById(User user) {
        return userDao.updateById(user);
    }

    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }
}
