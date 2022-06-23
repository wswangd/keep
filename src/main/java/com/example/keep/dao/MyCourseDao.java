package com.example.keep.dao;

import com.example.keep.entity.MyCourse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MyCourseDao {
    int addMyCourse(MyCourse myCourse);
    int clockIn(MyCourse myCourse);
    List<MyCourse> findAll(int user_id);
    MyCourse findByCourseId(int course_id, int user_id);
}
