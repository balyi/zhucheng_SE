package edu.taihu.logistics.service;

import java.util.List;

import edu.taihu.logistics.pojo.Role;

public interface RoleService {

	public List<Role> findAll();

	public void delete(String[] roleIds);

	public void saveRole(Role role);

	public Role findOne(String roleId);

	public void update(Role role);

	public void saveRoleModule(String roleId, String[] moduleIds); 
}
