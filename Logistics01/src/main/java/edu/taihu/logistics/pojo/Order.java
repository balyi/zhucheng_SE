package edu.taihu.logistics.pojo;

public class Order extends BaseEntity{
	private String orderId;
	private String orderNo;
	private String userId;
	private Integer orderState;
	private Integer payState;
	private Integer totalWeight;
	private Integer totalVolume;
	private String startAdd;
	private String endAdd;
	private String sSheng;
	private String sShi;
	private String sQu;
	private String sJiedao;
	private String eSheng;
	private String eShi;
	private String eQu;
	private String eJiedao;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getOrderState() {
		return orderState;
	}
	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}
	public Integer getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(Integer totalWeight) {
		this.totalWeight = totalWeight;
	}
	public Integer getTotalVolume() {
		return totalVolume;
	}
	public void setTotalVolume(Integer totalVolume) {
		this.totalVolume = totalVolume;
	}
	public String getStartAdd() {
		return startAdd;
	}
	public void setStartAdd(String startAdd) {
		this.startAdd = startAdd;
	}
	public String getEndAdd() {
		return endAdd;
	}
	public void setEndAdd(String endAdd) {
		this.endAdd = endAdd;
	}
	public String getsSheng() {
		return sSheng;
	}
	public void setsSheng(String sSheng) {
		this.sSheng = sSheng;
	}
	public String getsShi() {
		return sShi;
	}
	public void setsShi(String sShi) {
		this.sShi = sShi;
	}
	public String getsQu() {
		return sQu;
	}
	public void setsQu(String sQu) {
		this.sQu = sQu;
	}
	public String getsJiedao() {
		return sJiedao;
	}
	public void setsJiedao(String sJiedao) {
		this.sJiedao = sJiedao;
	}
	public String geteSheng() {
		return eSheng;
	}
	public void seteSheng(String eSheng) {
		this.eSheng = eSheng;
	}
	public String geteShi() {
		return eShi;
	}
	public void seteShi(String eShi) {
		this.eShi = eShi;
	}
	public String geteQu() {
		return eQu;
	}
	public void seteQu(String eQu) {
		this.eQu = eQu;
	}
	public String geteJiedao() {
		return eJiedao;
	}
	public void seteJiedao(String eJiedao) {
		this.eJiedao = eJiedao;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getPayState() {
		return payState;
	}
	public void setPayState(Integer payState) {
		this.payState = payState;
	}
	
	
}
