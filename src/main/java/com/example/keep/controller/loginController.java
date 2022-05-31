package com.example.keep.controller;

import com.example.keep.entity.Admin;
import com.example.keep.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class loginController {
    @Autowired
    AdminService adminService;

    @GetMapping("{username}")
    public Admin login(@PathVariable String username){
        return adminService.queryPwdByUsername(username);
    }

    @PostMapping("/ha")
    public Admin nihao(@RequestBody Admin admin) {
        System.out.println(admin.getUsername());
        return admin;
    }
}
