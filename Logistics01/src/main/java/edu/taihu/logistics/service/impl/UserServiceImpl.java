package edu.taihu.logistics.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.taihu.logistics.mapper.ModuleMapper;
import edu.taihu.logistics.mapper.RoleMapper;
import edu.taihu.logistics.mapper.UserInfoMapper;
import edu.taihu.logistics.mapper.UserMapper;
import edu.taihu.logistics.pojo.User;
import edu.taihu.logistics.pojo.UserInfo;
import edu.taihu.logistics.service.UserService;
import edu.taihu.logistics.tool.Md5Utils;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private ModuleMapper moduleMapper;
	
	@Override
	public User login(String username, String password) {
		return userMapper.login(username, password);
	}
	@Override
	public void saveUser(User user) {
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		user.setUserState(1);
		UserInfo userInfo = user.getUserInfo();
		userInfo.setUserInfoId(userId);
		user.setPassword(Md5Utils.getMd5(user.getPassword(), user.getUsername()));
		Date date = new Date();
		user.setCreateTime(date);
		userMapper.saveUser(user);
		userMapper.saveUserAndRole(userId,new String[]{"02"});
		userInfoMapper.saveUserInfo(userInfo);
	}

	@Override
	public boolean isExist(String username) {
		if(userMapper.isExist(username)!=null){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public User findOneById(String userId) {
		
		return userMapper.findOneById(userId);
	}
	@Override
	public void updateUser(User user) {
		Date date = new Date();
		user.setUpdateTime(date);
		userMapper.updateUser(user);
		user.getUserInfo().setUserInfoId(user.getUserId());
 		userInfoMapper.updateUserInfo(user.getUserInfo());
	}
	@Override
	public List<User> findAll() {
		
		return userMapper.findAll();
	}
	@Override
	public List<String> findRoles(String userId) {
		return userMapper.findRoles(userId);
	}
	@Override
	public void saveUserAndRole(String userId, String[] roleIds) {
		userMapper.deleteRoles(userId);
		// 只有传递过来roleId的值的时候才做保存操作
		if (roleIds.length>0) {
			userMapper.saveUserAndRole(userId,roleIds);

		}
	}
	@Override
	public void changeState(Integer i, String[] ids) {
		userMapper.changeState(i,ids);
	}
	@Override
	public User findOneByUsername(String username) {
		
		return userMapper.findOneByUsername(username);
	}
	@Override
	public List<String> findModuleNamesBy(String userId) {
		String moduleId[] = moduleMapper.findModuleIdsBy(userId);
//		findModuleNamesBy(userId);
		return moduleMapper.findModuleNamesByIds(moduleId);
	}

}
