package edu.taihu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.taihu.mapper.UserMapper;
import edu.taihu.pojo.User;
import edu.taihu.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User login(String username, String password) {
		
		return userMapper.login(username,password);
	}
	
}
