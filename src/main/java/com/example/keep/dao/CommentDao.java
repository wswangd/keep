package com.example.keep.dao;

import com.example.keep.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentDao {
    List<Comment> findAll();
    List<Comment> findByCourseId(int id);
    int deleteById(int id);
    int addComment(Comment comment);
}
