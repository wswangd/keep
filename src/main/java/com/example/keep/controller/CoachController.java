package com.example.keep.controller;

import com.example.keep.entity.Coach;
import com.example.keep.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coach")
public class CoachController {
    @Autowired
    CoachService coachService;

    @GetMapping
    @CrossOrigin
    public List<Coach> findAll() {
        return coachService.findAll();
    }

    @GetMapping("{username}")
    @CrossOrigin
    public List<Coach> findByUsername(@PathVariable String username) {
        return coachService.findByUsername(username);
    }

    @PutMapping
    @CrossOrigin
    public int updateById(@RequestBody Coach coach) {
        return coachService.updateById(coach);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public int deleteById(@PathVariable int id){
        return coachService.deleteById(id);
    }

    @PostMapping
    @CrossOrigin
    public int addCoach(@RequestBody Coach coach) {
        return coachService.addCoach(coach);
    }
}
