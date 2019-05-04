package cn.tarena.ht.pojo;

public class Hero {
 private Integer id;
 private String pId;
 private String name;
 private boolean checked;
 
 public Integer getAbcId(){
	 return id;
 }
 
public void setId(Integer id) {
	this.id = id;
}

public String getpId() {
	return pId;
}
public void setpId(String pId) {
	this.pId = pId;
}

public void setName(String name) {
	this.name = name;
}
public boolean isChecked() {
	return checked;
}
public void setChecked(boolean checked) {
	this.checked = checked;
}
 
 
}
