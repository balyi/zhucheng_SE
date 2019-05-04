package com.chateau.service.impl;

import com.chateau.mapper.*;
import com.chateau.pojo.*;
import com.chateau.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.SQLException;
import java.util.List;

/**
 * Created by tedu on 2017/11/26.
 */
@Service
public class OrderServiceImpl implements OrderService {
    /**
     *
     */
    @Autowired
    private WineMapper wineMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ChateauMapper chateauMapper;
    @Autowired
    private OrderReserveWineMapper orderReserveWineMapper;

    @Transactional(rollbackForClassName = "SQLException")
    public void addOrder(Order order, List<WineOrderInfo> woilist, List<OrderReserveWine> orwList, List<Boolean> flag) throws SQLException {
        //添加所有订单
        orderMapper.addOrder(order);
        //向用户订单关联表中添加信息
        orderMapper.addOrderandUser(order.getOrderId(), order.getUser().getUserId());
        int count1 = 0, count2 = 0;
        for (Boolean f : flag) {
            if (f) {
                if (woilist != null) {
                    WineOrderInfo info = woilist.get(count1);
                    count1++;
                    //用于查询红酒库存
                    Wine wine = wineMapper.findInfoById(info.getWineId());
                    if (wine.getPnum() < info.getBuynum()) {
                        //库存不足
                        throw new SQLException();

                    } else {
                        //库存充足
                        wineMapper.changePnum(wine.getWineId(), wine.getPnum() - info.getBuynum());
                        //向关联表中添加信息
                        orderMapper.addOrderandWine(info);
                    }
                }
            } else if (!f) {
                if (orwList != null) {
                    OrderReserveWine orw = orwList.get(count2);
                    count2++;
                    //用于查询红酒库存
                    Wine wine = wineMapper.findInfoById(orw.getWineId());
                    if (wine.getPnum() < orw.getNum()) {
                        //库存不足
                        throw new SQLException();

                    } else {
                        //库存充足
                        wineMapper.changePnum(wine.getWineId(), wine.getPnum() - orw.getNum());
                        //向关联表中添加信息
                        orderReserveWineMapper.addReserveOrderandWine(orw);
                    }
                }
            }
        }
    }

    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }

    @Override
    public void delete(String[] orderIds) {
        orderMapper.delete(orderIds);
        orderMapper.deleteOrderUser(orderIds);
        orderMapper.deleteOrderWine(orderIds);
    }

    @Override
    public List<Order> findAllReserve() {
        return orderMapper.findAllReserve();
    }

    @Override
    public List<Order> findByUserId(String UserId) {
        return orderMapper.findByUserId(UserId);
    }

    @Override
    public void deleteReserve(String[] orderIds) {
        orderMapper.delete(orderIds);
        orderMapper.deleteOrderUser(orderIds);
        orderMapper.deleteReserveWine(orderIds);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderMapper.findAllOrders();
    }


}
