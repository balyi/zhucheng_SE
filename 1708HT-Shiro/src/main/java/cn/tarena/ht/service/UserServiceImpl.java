package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.tool.Md5Utils;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userMapper.findAll();
	}


	@Override
	public void changeState(Integer i, String[] ids) {
		// TODO Auto-generated method stub
		userMapper.changeState(i,ids);
	}


	@Override
	public void delete(String[] ids) {
		// TODO Auto-generated method stub
		//删除完User表 还要删除 userinfo表中的数据 删除逻辑已经要写在Service中
		//主要为了能够正常处理事务
		userMapper.delete(ids);
		
//		删除用户信息表
		userInfoMapper.delete(ids);
		
		//删除用户和角色的关系
		roleMapper.deleteByUserIds(ids);
		 
	
	}


	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
//		自己生成一个id 
		String userId = UUID.randomUUID().toString();
		
		user.setUserId(userId);
		
		UserInfo userInfo = user.getUserInfo();
		userInfo.setUserInfoId(userId);
		
		user.setPassword(Md5Utils.getMd5(user.getPassword(), user.getUsername()));
		
		//创建一个当前的日期对象
		Date date = new Date();
		//设置用户创建时间
		user.setCreateTime(date);
		//设置入职时间
		userInfo.setJoinDate(date);
		
		//保存用户表数据
		userMapper.saveUser(user);
		//保存用户扩展表数据
		userInfoMapper.saveUserInfo(userInfo);
	}


	@Override
	public User findOne(String userId) {
		// TODO Auto-generated method stub
		return userMapper.findOne(userId);
	}


	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
		
		userMapper.update(user);
		
		
		//因为页面只传递了一个userId但是 user和userInfo对象里面都有userId 所以需要单独复制
		user.getUserInfo().setUserInfoId(user.getUserId());
		
 		userInfoMapper.update(user.getUserInfo());
		
	}


	@Override
	public void saveUserAndRole(String userId, String[] roleIds) {
		// TODO Auto-generated method stub
		userMapper.deleteRoles(userId);
		// 只有传递过来roleId的值的时候才做保存操作
		if (roleIds.length>0) {
			userMapper.saveUserAndRole(userId,roleIds);

		}
	
		
	}


	@Override
	public List<String> findRoles(String userId) {
		// TODO Auto-generated method stub
		return userMapper.findRoles(userId);
	}


	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		
		return userMapper.login(username,password);
	}


	@Override
	public User findOneByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.findOneByUsername(username);
	}


	@Override
	public List<String> findModuleNamesBy(String userId) {
		// TODO Auto-generated method stub
		return userMapper.findModuleNamesBy(userId);
	}

}
