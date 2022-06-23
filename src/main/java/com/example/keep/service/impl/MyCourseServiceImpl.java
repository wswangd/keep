package com.example.keep.service.impl;

import com.example.keep.dao.MyCourseDao;
import com.example.keep.entity.MyCourse;
import com.example.keep.service.MyCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyCourseServiceImpl implements MyCourseService {
    @Autowired
    MyCourseDao myCourseDao;

    public int addMyCourse(MyCourse myCourse) {
        return myCourseDao.addMyCourse(myCourse);
    }

    public int clockIn(MyCourse myCourse) {
        return myCourseDao.clockIn(myCourse);
    }

    public List<MyCourse> findAll(int user_id) {
        return myCourseDao.findAll(user_id);
    }

    public MyCourse findByCourseId(int course_id, int user_id) {
        return myCourseDao.findByCourseId(course_id, user_id);
    }
}
