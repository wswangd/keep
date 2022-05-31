package com.example.keep.service.impl;

import com.example.keep.dao.CoachDao;
import com.example.keep.entity.Coach;
import com.example.keep.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {
    @Autowired
    CoachDao coachDao;

    public List<Coach> findAll() {
        return coachDao.findAll();
    }

    public List<Coach> findByUsername(String username) {
        return coachDao.findByUsername(username);
    }

    public int addCoach(Coach coach) {
        return coachDao.addCoach(coach);
    }

    public int deleteById(int id) {
        return coachDao.deleteById(id);
    }

    public int updateById(Coach coach) {
        return coachDao.updateById(coach);
    }
}
