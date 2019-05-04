package edu.taihu.logistics.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.taihu.logistics.pojo.Order;

public interface OrderMapper {
	
	void saveProductAndOrder(@Param("orderId")String orderId,@Param("productIds")String[] productIds);

	void addOrder(Order order);

	List<Order> findAll();

	List<Order> findOrderByIds(String[] orderIds);

	void saveTruckAndOrder(@Param("truckId")String truckId,@Param("orderId")String orderId);

	void deleteTruckAndOrder(String orderId);

	List<String> findTruckIdsByOrderId(String orderId);

	void changeOrderStates(@Param("ids")String[] orderId,@Param("orderState")Integer i);

	void changeOrderState(@Param("orderId")String orderId,@Param("orderState")Integer i);

	List<Order> findOrderByUserId(String userId);

	void changePayState(@Param("payState")Integer i, @Param("orderId")String orderId);

}
