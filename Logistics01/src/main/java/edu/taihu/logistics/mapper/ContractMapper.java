package edu.taihu.logistics.mapper;

import java.util.List;

import edu.taihu.logistics.pojo.Contract;
import edu.taihu.logistics.pojo.Order;

public interface ContractMapper {

	Contract findContractById(String orderId);

	void saveContract(Contract contract);

	List<Contract> findContractByUserId(String userId);

}
