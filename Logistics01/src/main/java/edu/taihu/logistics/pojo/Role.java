package edu.taihu.logistics.pojo;

public class Role{

	private String roleId;
	private String name;
	private String remarks;
	private boolean checked;
	
	
	public boolean isChecked() {
		return checked;
	}


	public void setChecked(boolean checked) {
		this.checked = checked;
	}


	public String getId(){
		return roleId;
	}
	

	public String getRoleId() {
		return roleId;
	}
	
	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
 
	 
}
