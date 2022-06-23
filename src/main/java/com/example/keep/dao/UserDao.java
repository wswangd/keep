package com.example.keep.dao;

import com.example.keep.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface UserDao {
    List<User> findAll();
    List<User> findByUsername(String username);
    int addUser(User user);
    int deleteById(int id);
    int updateById(User user);
    User findUserByUsername(String username);
}
