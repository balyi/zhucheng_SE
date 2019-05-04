package com.chateau.controller;

import com.chateau.pojo.*;
import com.chateau.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by tedu on 2017/11/26.
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("order/toAdd")
    public String toAddAction(HttpSession session){
        Object userObj=session.getAttribute("USER");
        if(userObj==null){
            return "redirect:../login/login";
        }else{
            return "order/OrderAdd";
        }
    }

    @RequestMapping("order/add")
    public String OrderAdd(HttpSession session, Model model, String remark, String address) throws SQLException {
        //判断用户是否登录
        Object userObj=session.getAttribute("USER");
        if(userObj==null){
            model.addAttribute("msg","添加订单请先登录");
            return "/login/login";
        }
        Object cartObj=session.getAttribute("cart");
        if(cartObj==null){
            //重定向到购物车界面
        }
        Order order=new Order();
        order.setRemark(remark);
        User user=(User) userObj;
        order.setUser(user);
        order.setAddress(address);
        order.setOrderId(UUID.randomUUID().toString());
        order.setState(0); //未支付
        order.setCreateTime(new Date());

        double money=0;
        Map<Wine,Integer> cart= (Map<Wine, Integer>) cartObj;
        List<WineOrderInfo> woilist = new ArrayList<WineOrderInfo>();
        List<OrderReserveWine> orwList = new ArrayList<OrderReserveWine>();
        //将酒放入到所有订单中
        List<Boolean> flag = new ArrayList<Boolean>();
        for(Map.Entry<Wine,Integer> entry:cart.entrySet()){

            if (entry.getKey().getCheck().equals("false")){
                WineOrderInfo item = new WineOrderInfo();
                item.setOrderId(order.getOrderId());
                item.setWineId(entry.getKey().getWineId());
                item.setBuynum(entry.getValue());
                Boolean f = true;
                flag.add(f);
                woilist.add(item);
            } else if (entry.getKey().getCheck().equals("true")){
                OrderReserveWine item = new OrderReserveWine();
                item.setOrderId(order.getOrderId());
                item.setWineId(entry.getKey().getWineId());
                item.setYear(entry.getKey().getDate()-2017);
                item.setNum(entry.getValue());
                Boolean f = false;
                flag.add(f);
                orwList.add(item);
            }
            money+=entry.getKey().getPrice()*entry.getValue();
        }
        //将预定酒放入到预定酒单中

        //订单金额
        order.setMoney(money);
        model.addAttribute("money",money);

        //所有订单
        orderService.addOrder(order,woilist,orwList,flag);
        //添加成功
        cart.clear();
        return "redirect:/login/toindex";

    }

}
