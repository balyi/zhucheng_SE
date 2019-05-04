package com.chateau.pojo;

import java.util.Date;

/**
 * Created by tedu on 2017/11/26.
 */
public class Order {
    private String orderId;
    private String remark;
    private Integer state;//'1表示已支付，0表示未支付'
    private User user; //获取用户ID
    private String address;//送货地址
    private Date createTime;//下订单日期
    private OrderReserveWine orderReserveWine;
    private Double money;

    public OrderReserveWine getOrderReserveWine() {
        return orderReserveWine;
    }

    public void setOrderReserveWine(OrderReserveWine orderReserveWine) {
        this.orderReserveWine = orderReserveWine;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
