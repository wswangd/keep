package com.example.keep.controller;

import com.example.keep.entity.User;
import com.example.keep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/api/user")
    @CrossOrigin
    public List<User> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/api/user/{id}")
    @CrossOrigin
    public int deleteById(@PathVariable int id) {
        return userService.deleteById(id);
    }

    @GetMapping("/api/user/{username}")
    @CrossOrigin
    public List<User> findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PutMapping("/api/user")
    @CrossOrigin
    public int updateById(@RequestBody User user) {
        return userService.updateById(user);
    }

    @PostMapping("/api/user")
    @CrossOrigin
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
