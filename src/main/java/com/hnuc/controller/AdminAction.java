package com.hnuc.controller;

import com.hnuc.pojo.Admin;
import com.hnuc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    //切记：所有的界面层一定会有业务逻辑层的对象
    @Resource
    private AdminService adminService;
    //实现登入的判断，进行响应的跳转
    @RequestMapping("/login.action")
    public String login(String name, String pwd, HttpServletRequest request){
        Admin admin = adminService.login(name,pwd);
        if (admin != null){
            //登入成功
            request.setAttribute("admin",admin);
            return "main";
        }else {
            //登入失败
            request.setAttribute("errmsg","用户或密码不正确");
            return "login";
        }
    }

}
