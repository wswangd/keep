package com.example.keep.service.impl;

import com.example.keep.dao.OrderDao;
import com.example.keep.entity.Order;
import com.example.keep.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    public List<Order> findAll(){
        return orderDao.findAll();
    }
    public List<Order> findByUserId(int id) {
        return orderDao.findByUserId(id);
    }

    @Override
    public int deleteById(int id) {
        return orderDao.deleteById(id);
    }

    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }

}
