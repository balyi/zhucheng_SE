package edu.taihu.logistics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import edu.taihu.logistics.pojo.Truck;

public interface TruckMapper {

	Truck contributeTruck(String startAdd);

	void useTruck(@Param("truckState")Integer i,@Param("truckId")String truckId);

	void resetTruck(@Param("truckAdd")String endAdd,@Param("truckState")Integer i,@Param("truckId")String truckId);

	@Select("SELECT * FROM truck")
	List<Truck> findAll();

	void changeTruckState(@Param("truckState")Integer i,@Param("ids")String[] truckIds);

}
