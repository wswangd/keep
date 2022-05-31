package com.example.keep.controller;
import com.example.keep.entity.Admin;
import com.example.keep.result.Result;
import com.example.keep.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class AdminLoginController {

    @Autowired
    AdminService adminService;

    @PostMapping("/api/login")
    @CrossOrigin
    public Result login(@RequestBody Admin admin, HttpSession session) {
        if (!StringUtils.hasText(admin.getUsername())){
            return new Result(400,"账号不能为空","");
        }
        if (!StringUtils.hasText(admin.getPassword())){
            return new Result(400,"密码不能为空","");
        }
        //通过登录名查询用户
        Admin admin1 = adminService.queryPwdByUsername(admin.getUsername());
        //比较密码
        if (admin1 !=null&&admin1.getPassword().equals(admin.getPassword())){
            session.setAttribute("admin", admin);
            return new Result(200,"",admin);
        }
        return new Result(400,"登录失败","");

    }
}
