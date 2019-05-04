package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.pojo.Role;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleMapper.findAll();
	}
	@Override
	public void delete(String[] roleIds) {
		// TODO Auto-generated method stub
		//删除和用户的关联关系
		roleMapper.deleteUserRole(roleIds);
		
		//删除和模块的关系
		roleMapper.deleteRoleModules(roleIds);
		
		roleMapper.delete(roleIds);
	}
	@Override
	public void saveRole(Role role) {
		
		role.setRoleId(UUID.randomUUID().toString());
		role.setCreateTime(new Date());
		
		roleMapper.saveRole(role);
	}
	@Override
	public Role findOne(String roleId) {
		// TODO Auto-generated method stub
		return roleMapper.findOne(roleId);
	}
	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		roleMapper.update(role);
	}
	@Override
	public void saveRoleModule(String roleId, String[] moduleIds) {
		// TODO Auto-generated method stub
		
		//删除之前的关联关系
		roleMapper.deleteModules(roleId);
		//判断只有当有模块时才保存 不然的话会报错
		if (moduleIds.length>0) {
			roleMapper.saveRoleModule(roleId,moduleIds);
		}
		
	}

	
}
