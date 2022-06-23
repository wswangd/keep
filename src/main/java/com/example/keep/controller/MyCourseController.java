package com.example.keep.controller;

import com.example.keep.dao.MyCourseDao;
import com.example.keep.entity.MyCourse;
import com.example.keep.service.MyCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myCourse")
public class MyCourseController {
    @Autowired
    MyCourseService myCourseService;

    @PostMapping("/addMyCourse")
    public int addMyCourse(@RequestBody MyCourse myCourse) {
        return myCourseService.addMyCourse(myCourse);
    }

    @PutMapping("/clockIn")
    public int clockIn(@RequestBody MyCourse myCourse) {
        return myCourseService.clockIn(myCourse);
    }

    @GetMapping("/find/{user_id}")
    public List<MyCourse> findAll(@PathVariable int user_id) {
        return myCourseService.findAll(user_id);
    }

    @GetMapping("/course")
    public MyCourse findByCourseId(@RequestParam(value = "course_id") int course_id, @RequestParam(value = "user_id") int user_id) {
        return myCourseService.findByCourseId(course_id, user_id);
    }

}
