package com.example.keep.service.impl;
import com.example.keep.dao.AdminDao;
import com.example.keep.entity.Admin;
import com.example.keep.result.Result;
import com.example.keep.service.AdminService;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    public Admin queryPwdByUsername(String username) {
        return this.adminDao.queryPwdByUsername(username);
    }

}
