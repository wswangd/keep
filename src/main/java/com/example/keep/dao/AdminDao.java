package com.example.keep.dao;

import com.example.keep.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminDao {

    public Admin queryPwdByUsername(String username);
}
