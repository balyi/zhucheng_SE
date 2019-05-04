package edu.taihu.pojo;

import java.io.Serializable;

public class Product implements Serializable{
	private String id;//��Ʒid
	private String name;//��Ʒ����
	private double price;//��Ʒ�۸�
	private String category;//��Ʒ����
	private String imgurl;//��ƷͼƬ��ַ
	private int pnum;//���
	private String description;//��Ʒ����
	//ֻҪid��ͬ��hashCode��ֵ�϶���ͬ
	@Override
	public int hashCode() {
		return id==null?0:id.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		if(obj==null){
			return false;
		}
		//�ж�obj�Ƿ�ΪProduct
		if(!(obj instanceof Product)){
			//obj����Product��ĵĶ���
			return false;
		}
		//˵��obj��Product�ഴ���Ķ���
		Product other = (Product)obj;
		if(id!=null&&id.equals(other.getId())){
			//˵����������id��ͬ
			return true;
		}
		return false;
	}
	//Alt+Shift+S->R->Select All(Tab->Enter)->OK
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
