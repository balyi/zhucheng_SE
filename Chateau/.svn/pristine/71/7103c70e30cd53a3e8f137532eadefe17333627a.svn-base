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
public class BackOrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order")
    public String backOrderList(Model model){

        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "/back/order";
    }

    @RequestMapping("/deleteOrder")
    public String backDeleteOrder(@RequestParam(value = "orderId", required = false) String[] orderIds){
        if(orderIds!=null){
            orderService.delete(orderIds);
        }
        return "redirect:/back/order";
    }

}
