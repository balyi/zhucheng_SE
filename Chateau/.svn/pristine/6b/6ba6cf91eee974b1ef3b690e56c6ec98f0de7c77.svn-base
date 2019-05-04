package com.chateau.controller;

import com.chateau.pojo.User;
import com.chateau.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by tedu on 2017/11/27.
 */

@Controller
@RequestMapping("/back")
public class BackLoginController {
    private User user;
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String tologin(){
        return "back/login";
    }

    @RequestMapping("/tologin")
    public String login(String username, String password, Model model, HttpSession session){
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            model.addAttribute("errorInfo","用户名或密码不能为空");
            return "back/login";
        }
        User user = userService.login(username,password);
        model.addAttribute("user",user);
        if(user==null){
            model.addAttribute("errorInfo","用户名或密码错误");
            return "back/login";
        }
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);   //完成登录
        session.setAttribute("admin",user);
        return "back/index";
    }

    @RequestMapping("/lock_screen")
    public String lock(){
        return "back/lock_screen";
    }

    @RequestMapping("/tologout")
    public String tologout(){
        return "back/login";
    }
}
