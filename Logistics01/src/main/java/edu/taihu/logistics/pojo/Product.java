package edu.taihu.logistics.pojo;

public class Product extends BaseEntity{
	private String productId;
	private String productNo;
	private String productName;
	private Integer productState;
	private Integer number;
	private Integer length;
	private Integer width;
	private Integer height;
	private Integer weight;
	private String productRemark;
	private String userId;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getProductRemark() {
		return productRemark;
	}
	public void setProductRemark(String productRemark) {
		this.productRemark = productRemark;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getProductState() {
		return productState;
	}
	public void setProductState(Integer productState) {
		this.productState = productState;
	}
	
}
