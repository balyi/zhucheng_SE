package edu.taihu.logistics.service;

import java.util.List;

import edu.taihu.logistics.pojo.Truck;

public interface TruckService {

	List<Truck> findAll();

	void changeTruckState(String[] truckIds, Integer i);
	
}
