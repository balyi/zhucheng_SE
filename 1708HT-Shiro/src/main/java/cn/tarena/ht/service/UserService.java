package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.User;

public interface UserService {

	public List<User> findAll();

	public void changeState(Integer i, String[] ids);

	public void delete(String[] ids);

	public void saveUser(User user);

	public User findOne(String userId);

	public void update(User user);

	public void saveUserAndRole(String userId, String[] roleIds);

	public List<String> findRoles(String userId);

	public User login(String username, String password);

	public User findOneByUsername(String username);

	public List<String> findModuleNamesBy(String userId);
}
