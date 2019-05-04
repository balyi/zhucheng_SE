package com.chateau.mapper;

import com.chateau.pojo.Order;
import com.chateau.pojo.WineOrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by tedu on 2017/11/26.
 */
public interface OrderMapper {
    public void addOrder(Order order);

    @Insert("insert into wine_order_info(order_id,wine_id,buynum) values(#{orderId},#{wineId},#{buynum})")
    public void addOrderandWine(WineOrderInfo info);


    public void addOrderandUser(@Param("orderId") String orderId, @Param("userId") String userId);


    List<Order> findAll();

    void delete(String[] orderIds);

    void deleteOrderUser(String[] orderIds);

    void deleteOrderWine(String[] orderIds);

    List<Order> findAllReserve();


    void deleteReserveWine(String[] orderIds);

    @Select("select * from orders where order_id in (select order_id from user_order_info where user_id=#{userId})")
    List<Order> findByUserId(String userId);

    List<Order> findAllOrders();
}
