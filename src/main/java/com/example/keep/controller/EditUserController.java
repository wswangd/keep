package com.example.keep.controller;

import com.example.keep.entity.User;
import com.example.keep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EditUserController {
    @Autowired
    UserService userService;

    @PutMapping("/editUser")
    public int updateById(@RequestBody User user) {
        return userService.updateById(user);
    }
}
