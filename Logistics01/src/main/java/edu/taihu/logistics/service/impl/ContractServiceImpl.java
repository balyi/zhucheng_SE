package edu.taihu.logistics.service.impl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.taihu.logistics.mapper.AddCooMapper;
import edu.taihu.logistics.mapper.ContractMapper;
import edu.taihu.logistics.mapper.ProductMapper;
import edu.taihu.logistics.pojo.Contract;
import edu.taihu.logistics.pojo.Order;
import edu.taihu.logistics.pojo.Product;
import edu.taihu.logistics.service.ContractService;
import edu.taihu.logistics.tool.MathTool;
import edu.taihu.logistics.tool.TimeTool;
@Service
public class ContractServiceImpl implements ContractService {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private AddCooMapper addCooMapper;
	@Override
	public void saveContract(String[] productIds, Order order) {
		Contract contract=new Contract();
		contract.setOrderId(order.getOrderId());
		contract.setUserId(order.getUserId());
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
		contract.setStartDate(sdf.format(date));
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 15);
		date=c.getTime();
		contract.setEndDate(sdf.format(date));
		contract.setSecurity(3000L);
		List<Product> products = productMapper.findProductById(productIds);
		String[] productNames=new String[products.size()];
		for(int i=0;i<products.size();i++) {
			productNames[i]=products.get(i).getProductName();
		}
		contract.setPname(Arrays.toString(productNames));
		contract.setSadd(order.getStartAdd());
		contract.setEadd(order.getEndAdd());
		String startCoo=addCooMapper.addCoo(order.getStartAdd());
		String endCoo=addCooMapper.addCoo(order.getEndAdd());
		Double distance=MathTool.distance(startCoo, endCoo);
		Integer totalWeight=order.getTotalWeight();
		Integer totalVolume=order.getTotalVolume();
		if(totalWeight/totalVolume*1000000>300) {
			contract.setPrice(new String(""+distance*totalWeight*0.5/1000));
		}else {
			contract.setPrice(new String(""+distance*totalVolume*0.15/1000));
		}
		contract.setDistance(distance);
		contractMapper.saveContract(contract);
	}

	@Override
	public Contract findContractById(String orderId) {
		
		return contractMapper.findContractById(orderId);
	}

	@Override
	public List<Contract> findContractByUserId(String userId) {
		
		return contractMapper.findContractByUserId(userId);
	}
	
}
