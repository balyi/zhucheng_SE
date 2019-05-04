package edu.taihu.logistics.pojo;

public class Truck {
	private String truckId;
	private String truckNo;
	private Integer loadWeight;
	private Integer loadVolume;
	private Integer truckState;
	private String truckAdd;
	public String getTruckId() {
		return truckId;
	}
	public void setTruckId(String truckId) {
		this.truckId = truckId;
	}
	public String getTruckNo() {
		return truckNo;
	}
	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
	}
	public Integer getLoadWeight() {
		return loadWeight;
	}
	public void setLoadWeight(Integer loadWeight) {
		this.loadWeight = loadWeight;
	}
	public Integer getLoadVolume() {
		return loadVolume;
	}
	public void setLoadVolume(Integer loadVolume) {
		this.loadVolume = loadVolume;
	}
	public Integer getTruckState() {
		return truckState;
	}
	public void setTruckState(Integer truckState) {
		this.truckState = truckState;
	}
	public String getTruckAdd() {
		return truckAdd;
	}
	public void setTruckAdd(String truckAdd) {
		this.truckAdd = truckAdd;
	}
	
}
