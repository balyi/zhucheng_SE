package com.chateau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tedu on 2017/11/25.
 */

@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping("/{path}")
    public String path(@PathVariable String path){
        return  "home/"+path;
    }

}
