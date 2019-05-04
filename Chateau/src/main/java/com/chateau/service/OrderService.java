package com.chateau.service;

import com.chateau.pojo.Order;
import com.chateau.pojo.WineOrderInfo;
import com.chateau.pojo.OrderReserveWine;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by tedu on 2017/11/26.
 */
public interface OrderService {

   public void addOrder(Order order, List<WineOrderInfo> woilist, List<OrderReserveWine> orwList, List<Boolean> flag) throws SQLException;


   List<Order> findAll();

   void delete(String[] orderIds);

   List<Order> findAllReserve();

   List<Order> findByUserId(String UserId);

   void deleteReserve(String[] orderIds);

   List<Order> findAllOrders();
}
