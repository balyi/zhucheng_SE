package com.chateau.controller;

import com.chateau.pojo.Order;
import com.chateau.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by tedu on 2017/11/28.
 */
@Controller
@RequestMapping("/back")
public class BackReserveController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/reserve")
    public String backOrderList(Model model){

        List<Order> orders = orderService.findAllReserve();

        model.addAttribute("orders", orders);
        return "/back/reserve";
    }

    @RequestMapping("/deleteReserve")
        public String backDeleteReserve(@RequestParam(value = "orderId", required = false) String[] orderIds){
        if(orderIds!=null){
            orderService.deleteReserve(orderIds);
        }
        return "redirect:/back/reserve";
    }

}
