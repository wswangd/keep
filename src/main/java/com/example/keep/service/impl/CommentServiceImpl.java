package com.example.keep.service.impl;

import com.example.keep.dao.CommentDao;
import com.example.keep.entity.Comment;
import com.example.keep.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;

    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    public List<Comment> findByCourseId(int id) {
        return commentDao.findByCourseId(id);
    }

    public int deleteById(int id) {
        return commentDao.deleteById(id);
    }

    public int addComment(Comment comment) {return commentDao.addComment(comment);}
}
