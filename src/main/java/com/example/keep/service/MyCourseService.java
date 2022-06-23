package com.example.keep.service;

import com.example.keep.dao.MyCourseDao;
import com.example.keep.entity.MyCourse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface MyCourseService {
    int addMyCourse(MyCourse myCourse);
    int clockIn(MyCourse myCourse);
    List<MyCourse> findAll(int user_id);
    MyCourse findByCourseId(int course_id, int user_id);

}
