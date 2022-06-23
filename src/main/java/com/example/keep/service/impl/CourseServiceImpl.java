package com.example.keep.service.impl;

import com.example.keep.dao.CourseDao;
import com.example.keep.entity.Course;
import com.example.keep.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;

    public List<Course> findAll() {
        return courseDao.findAll();
    }
    public List<Course> findByName(String name) {
        return courseDao.findByName(name);
    }
    public int addCourse(Course course) {
        return courseDao.addCourse(course);
    }
    public int deleteById(int id) {
        return courseDao.deleteById(id);
    }
    public int updateById(Course course) {
        return courseDao.updateById(course);
    }

    public Course findById(int id) {
        return courseDao.findById(id);
    }
}
