package com.example.keep.controller;

import com.example.keep.entity.User;
import com.example.keep.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/api/user")
    @CrossOrigin
    public Map<String, Object> findAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.findAll();
        PageInfo<User> page = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        map.put("total", page.getTotal());
        map.put("list", page.getList());
        return map;
    }

    @DeleteMapping("/api/user/{id}")
    @CrossOrigin
    public int deleteById(@PathVariable int id) {
        return userService.deleteById(id);
    }

    @GetMapping("/api/user/{username}")
    @CrossOrigin
    public Map<String, Object> findByUsername(@PathVariable String username, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.findByUsername(username);
        PageInfo<User> page = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        map.put("total", page.getTotal());
        map.put("list", page.getList());
        System.out.println(map);
        return map;
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
