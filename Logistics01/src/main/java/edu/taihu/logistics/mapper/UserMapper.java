package edu.taihu.logistics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import edu.taihu.logistics.pojo.User;

public interface UserMapper {
	public User login(@Param("username")String username, @Param("password")String password);

	public void saveUser(User user);
	
	@Select("select * from user where username=#{username}")
	User isExist(String username);

	public User findOneById(String userId);

	public void updateUser(User user);

	public List<User> findAll();

	@Select("select role_id from role_user where user_id=#{userId}")
	public List<String> findRoles(String userId);

	@Delete("delete from role_user where user_id=#{userId}")
	public void deleteRoles(String userId);

	public void saveUserAndRole(@Param("userId")String userId, @Param("roleIds")String[] roleIds);

	public void changeState(@Param("userState")Integer i, @Param("ids")String[] ids);

	public User findOneByUsername(String username);
}
