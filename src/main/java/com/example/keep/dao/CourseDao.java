package com.example.keep.dao;

import com.example.keep.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseDao {
    List<Course> findAll();
    List<Course> findByName(String name);
    int addCourse(Course course);
    int deleteById(int id);
    int updateById(int id);
}
