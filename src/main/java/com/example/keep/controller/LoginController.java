package com.example.keep.controller;


import com.example.keep.entity.User;
import com.example.keep.result.Result;
import com.example.keep.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/login/{username}")
    public User login(@PathVariable String username) {
        User user1 = userService.findUserByUsername(username);
        return user1;
    }

    @PostMapping("/register")
    public int add(@RequestBody User user) {
        return userService.addUser(user);
    }


}
