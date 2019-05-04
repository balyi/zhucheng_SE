package edu.taihu.logistics.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.taihu.logistics.constant.TruckConstant;
import edu.taihu.logistics.mapper.OrderMapper;
import edu.taihu.logistics.mapper.TruckMapper;
import edu.taihu.logistics.pojo.Order;
import edu.taihu.logistics.pojo.Truck;
import edu.taihu.logistics.service.OrderService;
import edu.taihu.logistics.tool.StringUtils;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private TruckMapper truckMapper;

	@Override
	public void saveProductAndOrder(String[] productIds,Order order,String userId) {
		String orderId = UUID.randomUUID().toString();
		order.setOrderId(orderId);
		order.setUserId(userId);
		Date createTime = new Date();
		order.setCreateTime(createTime);
		order.setPayState(0);
		StringBuilder sSheng=new StringBuilder(order.getsSheng());
		StringBuilder sShi=new StringBuilder(order.getsShi());
		StringBuilder sQu=new StringBuilder(order.getsQu());
		StringBuilder eSheng=new StringBuilder(order.geteSheng());
		StringBuilder eShi=new StringBuilder(order.geteShi());
		StringBuilder eQu=new StringBuilder(order.geteQu());
		order.setStartAdd(sSheng.append("-").append(sShi).append("-").append(sQu).toString());
		order.setEndAdd(eSheng.append("-").append(eShi).append("-").append(eQu).toString());
		order.setOrderState(0);
		orderMapper.addOrder(order);
		orderMapper.saveProductAndOrder(orderId,productIds);
	}

	@Override
	public List<Order> findAll() {
		
		return orderMapper.findAll();
	}

	@Override
	public List<Order> findOrderByIds(String[] orderIds) {
		
		return orderMapper.findOrderByIds(orderIds);
	}

	@Override
	public void saveTruckAndOrder(Order order) {
		int totalWeight=order.getTotalWeight();
		String add=order.getStartAdd();
		String startAdd=StringUtils.addsub(add);
		if(totalWeight<=TruckConstant.MIN_WEIGHT_LOAD){
			Truck truck=truckMapper.contributeTruck(startAdd);
			truckMapper.useTruck(1,truck.getTruckId());
			orderMapper.saveTruckAndOrder(truck.getTruckId(),order.getOrderId());
		}else {
			int times=totalWeight/TruckConstant.MIN_WEIGHT_LOAD+1;
			for(int i=0;i<times;i++) {
				Truck truck=truckMapper.contributeTruck(startAdd);
				truckMapper.useTruck(1,truck.getTruckId());
				orderMapper.saveTruckAndOrder(truck.getTruckId(),order.getOrderId());
			}
		}
		orderMapper.changeOrderState(order.getOrderId(),1);
	}

	@Override
	public void finishOrder(Order order) {
		List<String> truckIds=orderMapper.findTruckIdsByOrderId(order.getOrderId());
		String add=order.getEndAdd();
		String endAdd=StringUtils.addsub(add);
		for(String truckId:truckIds) {
			truckMapper.resetTruck(endAdd,0,truckId);
		}
		orderMapper.deleteTruckAndOrder(order.getOrderId());
		orderMapper.changeOrderState(order.getOrderId(),3);
	}

	@Override
	public void changeOrderState(String[] orderId, Integer i) {
		orderMapper.changeOrderStates(orderId,i);
	}

	@Override
	public List<Order> findOrderByUserId(String userId) {
		return orderMapper.findOrderByUserId(userId);
	}

	@Override
	public void changePayState(Integer i, String orderId) {
		orderMapper.changePayState(i,orderId);
	}
}
