package com.chateau.service.impl;

import com.chateau.mapper.UserMapper;
import com.chateau.pojo.User;
import com.chateau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by tedu on 2017/11/24.
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserMapper userMapper;
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }

	@Override
	public boolean isExist(String username) {
		if(userMapper.isExist(username)!=null){
			return true;
		}else{
			return false;
		}
	}

	public List<User> findAll() {
		
		return userMapper.findAll();
	}

	public User findOne(String userId) {
		
		return userMapper.findOne(userId);
	}

	public void saveUser(User user) {
		String userId= UUID.randomUUID().toString();
		user.setUserId(userId);
		userMapper.saveUser(user);
	}

	public void delete(String[] ids) {
		userMapper.delete(ids);
	}

	public void update(User user) {
		userMapper.update(user);
	}

	@Override
	public List<User> findAllMaster() {
		return userMapper.findAllMaster();
	}

	@Override
	public String findRoleById(String userId) {
		return userMapper.findRoleById(userId);
	}

	@Override
	public User getByUserName(String username) {
		return userMapper.getByUserName(username);
	}
}
