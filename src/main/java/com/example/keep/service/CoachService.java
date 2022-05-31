package com.example.keep.service;

import com.example.keep.entity.Coach;

import java.util.List;

public interface CoachService {
    List<Coach> findAll();
    List<Coach> findByUsername(String username);
    int addCoach(Coach coach);
    int deleteById(int id);
    int updateById(Coach coach);
}
