package com.example.keep.service;

import com.example.keep.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    List<Comment> findByCourseId(int id);
    int deleteById(int id);

    int addComment(Comment comment);
}
