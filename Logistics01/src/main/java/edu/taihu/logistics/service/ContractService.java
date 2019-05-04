package edu.taihu.logistics.service;

import java.util.List;

import edu.taihu.logistics.pojo.Contract;
import edu.taihu.logistics.pojo.Order;

public interface ContractService {

	void saveContract(String[] productIds, Order order);

	Contract findContractById(String orderId);

	List<Contract> findContractByUserId(String userId);

}
