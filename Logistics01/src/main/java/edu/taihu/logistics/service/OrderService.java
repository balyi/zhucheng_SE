package edu.taihu.logistics.service;

import java.util.List;

import edu.taihu.logistics.pojo.Order;

public interface OrderService {

	void saveProductAndOrder(String[] productIds, Order order, String string);

	List<Order> findAll();

	List<Order> findOrderByIds(String[] orderId);

	void saveTruckAndOrder(Order order);

	void finishOrder(Order order);

	void changeOrderState(String[] orderId, Integer i);

	List<Order> findOrderByUserId(String userId);

	void changePayState(Integer i, String r6_Order);

}
