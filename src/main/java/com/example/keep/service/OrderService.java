package com.example.keep.service;

import com.example.keep.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    List<Order> findByUserId(int id);
    int deleteById(int id);
    int addOrder(Order order);
}
