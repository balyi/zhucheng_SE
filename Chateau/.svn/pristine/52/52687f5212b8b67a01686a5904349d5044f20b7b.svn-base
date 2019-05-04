package com.chateau.controller;

import com.chateau.pojo.User;
import com.chateau.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by tedu on 2017/11/28.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/account")
    public String account(HttpSession session, Model model){
        Object userObj = session.getAttribute("USER");
        if (userObj==null){
            return "login/login";
        }
        User user = (User) userObj;
        model.addAttribute("OrdersL",orderService.findByUserId(user.getUserId()));
        return "home/account";
    }
}
