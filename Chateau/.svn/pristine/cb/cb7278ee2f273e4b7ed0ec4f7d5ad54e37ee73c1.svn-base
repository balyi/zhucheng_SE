package com.chateau.mapper;

import com.chateau.pojo.OrderReserveWine;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by tedu on 2017/11/28.
 */
public interface OrderReserveWineMapper {
    @Insert("insert into order_reserve_wine(order_id,wine_id,year,num) values(#{orderId},#{wineId},#{year},#{num})")
    void addReserveOrderandWine(OrderReserveWine info);

}
