package edu.taihu.logistics.pojo;

import java.io.Serializable;
import java.util.Date;

//抽象类
public abstract class BaseEntity implements Serializable{
	private Date createTime;
	private Date updateTime;
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
