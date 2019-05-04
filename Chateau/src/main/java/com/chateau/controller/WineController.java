package com.chateau.controller;


import com.chateau.pojo.Wine;
import com.chateau.service.WineService;
import com.chateau.service.impl.WineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by tedu on 2017/11/25.
 */
@Controller
@RequestMapping("/wine")
public class WineController {
    @Autowired
    private WineService wineService;

    @RequestMapping("/list")
    public String list(){
        return "/home/list";
    }

    @RequestMapping("/prod_info")
    public String wineInfo(String wineId, Model model){
        Wine wine=wineService.findInfoById(wineId);
        model.addAttribute("wine",wine);
        return "order/prod_info";
    }
    @RequestMapping("/toedit")
    public String toEdit(Model model,String buyNum){
        model.addAttribute("buyNum",buyNum);
        return "order/prod_info";
    }

}

