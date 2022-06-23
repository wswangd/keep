package com.example.keep.dao;

import com.example.keep.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderDao {
    List<Order> findAll();
    List<Order> findByUserId(int id);
    int deleteById (int id);

    int addOrder(Order order);
}
