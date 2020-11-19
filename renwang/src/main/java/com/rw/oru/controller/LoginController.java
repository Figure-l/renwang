package com.rw.oru.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,String> maps,
                        HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("username",username);//服务器维护一个客户端访问时的会话,session作用在改会话时
            return "redirect:/main.html";//登录成功跳转到后台管理页面}
        }else{
            session.setAttribute("err_msg","用户名或密码错误");
            maps.put("err_msg","用户名或密码错误"); //记录登录失败信息
            return "login";//登录失败返回登录页面
        }
    }
}
