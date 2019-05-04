package edu.taihu.logistics.service;

import java.util.List;

import edu.taihu.logistics.pojo.User;

public interface UserService {

	User login(String username, String password);

	void saveUser(User user);

	boolean isExist(String username);

	User findOneById(String userId);

	void updateUser(User user);

	List<User> findAll();

	List<String> findRoles(String userId);

	void saveUserAndRole(String userId, String[] roleIds);

	void changeState(Integer i, String[] ids);

	User findOneByUsername(String username);

	List<String> findModuleNamesBy(String userId);
	
}
