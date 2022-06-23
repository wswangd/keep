package com.example.keep.controller;

import com.example.keep.entity.Comment;
import com.example.keep.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping
    @CrossOrigin
    public List<Comment> findAll() {
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public List<Comment> findByCourseId(@PathVariable int id) {
        return commentService.findByCourseId(id);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public int deleteById(@PathVariable int id) {
        return commentService.deleteById(id);
    }

    @PostMapping
    public int addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }
}
