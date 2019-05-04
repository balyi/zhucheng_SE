package edu.taihu.logistics.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.taihu.logistics.mapper.TruckMapper;
import edu.taihu.logistics.pojo.Truck;
import edu.taihu.logistics.service.TruckService;
@Service
public class TruckServiceImpl implements TruckService {
	@Autowired
	private TruckMapper truckMapper;
	@Override
	public List<Truck> findAll() {
		
		return truckMapper.findAll();
	}
	@Override
	public void changeTruckState(String[] truckIds, Integer i) {
		truckMapper.changeTruckState(i,truckIds);
	}

}
