package edu.taihu.logistics.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.taihu.logistics.mapper.RoleMapper;
import edu.taihu.logistics.pojo.Role;
import edu.taihu.logistics.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<Role> findAll() {
		return roleMapper.findAll();
	}
	@Override
	public void delete(String[] roleIds) {
		//删除和用户的关联关系
		roleMapper.deleteUserRole(roleIds);
		roleMapper.deleteRoleModules(roleIds);
		roleMapper.delete(roleIds);
	}
	@Override
	public void saveRole(Role role) {
		roleMapper.saveRole(role);
	}
	@Override
	public Role findOne(String roleId) {
		return roleMapper.findOne(roleId);
	}
	@Override
	public void update(Role role) {
		roleMapper.update(role);
	}
	@Override
	public void saveRoleModule(String roleId, String[] moduleIds) {
		roleMapper.deleteModules(roleId);
		//判断只有当有模块时才保存 不然的话会报错
		if (moduleIds.length>0) {
			roleMapper.saveRoleModule(roleId,moduleIds);
		}
		
	}

	
}
