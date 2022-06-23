package com.example.keep.service;

import com.example.keep.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    List<Course> findByName(String name);
    int addCourse(Course course);
    int deleteById(int id);
    int updateById(Course course);
    Course findById(int id);
}
