package com.example.keep.dao;

import com.example.keep.entity.Coach;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CoachDao {
    List<Coach> findAll();
    List<Coach> findByUsername(String username);
    int addCoach(Coach coach);
    int deleteById(int id);
    int updateById(Coach coach);
}
