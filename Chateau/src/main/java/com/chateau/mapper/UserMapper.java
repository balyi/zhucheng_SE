package com.chateau.mapper;

import com.chateau.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by tedu on 2017/11/24.
 */
public interface UserMapper {
	
	@Select("select * from user where username=#{username} and password=#{password}")
    User login(@Param("username") String username, @Param("password") String password);

	@Select("select * from user where username=#{username}")
	User isExist(String username);

	@Select("select * from user")
	List<User> findAll();
	
	@Select("select * from user where user_id=#{userId}")
	User findOne(String userId);

	@Insert("insert into user (user_id,username,password,name,email,telephone,role) values (#{userId},#{username},#{password},#{name},#{email},#{telephone},#{role})")
	void saveUser(User user);

	void delete(String[] ids);

	@Update("update user set name=#{name},email=#{email},telephone=#{telephone},role=#{role} where user_id=#{userId}")
	void update(User user);

	@Select("select * from user where role='boss'")
	List<User> findAllMaster();

	@Select("select role from user where user_id=#{userId}")
	String findRoleById(String userId);

	@Select("select * from user where username=#{username}")
	User getByUserName(String username);
}
