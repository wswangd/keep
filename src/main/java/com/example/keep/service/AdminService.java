package com.example.keep.service;


import com.example.keep.entity.Admin;
import com.example.keep.result.Result;

import javax.servlet.http.HttpSession;

public interface AdminService {
    Admin queryPwdByUsername(String username);

}
