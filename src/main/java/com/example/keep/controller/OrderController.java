package com.example.keep.controller;

import com.example.keep.entity.Order;
import com.example.keep.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping
    @CrossOrigin
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping( "/{id}")
    @CrossOrigin
    public List<Order> findByUserId(@PathVariable int id) {
        return orderService.findByUserId(id);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public int deleteByUserId(@PathVariable int id) {
        return orderService.deleteById(id);
    }

    @PostMapping("/add")
    public int addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }
}
