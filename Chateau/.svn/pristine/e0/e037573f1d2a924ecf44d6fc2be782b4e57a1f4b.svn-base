package com.chateau.service;

import com.chateau.pojo.User;

import java.util.List;

/**
 * Created by tedu on 2017/11/24.
 */
public interface UserService {
    User login(String username, String password);

	boolean isExist(String username);

	List<User> findAll();

	User findOne(String userId);
	
	void saveUser(User user);
	
	void delete(String[] ids);

	void update(User user);

	List<User> findAllMaster();

	String findRoleById(String userId);

	User getByUserName(String username);
}
