package com.example.keep.controller;

import com.example.keep.entity.Course;
import com.example.keep.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping
    @CrossOrigin
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/{name}")
    @CrossOrigin
    public List<Course> findByName(@PathVariable String name) {
        return courseService.findByName(name);
    }

    @GetMapping("/id/{id}")
    public Course findById(@PathVariable int id) {
        return courseService.findById(id);
    }

    @PostMapping
    @CrossOrigin
    public int addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public int deleteById(@PathVariable int id) {
        return courseService.deleteById(id);
    }

    @PutMapping
    @CrossOrigin
    public int updateById(@RequestBody Course course) {
        return courseService.updateById(course);
    }
}
