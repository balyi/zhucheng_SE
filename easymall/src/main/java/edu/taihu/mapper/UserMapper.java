package edu.taihu.mapper;

import org.apache.ibatis.annotations.Param;

import edu.taihu.pojo.User;

public interface UserMapper {

	User login(@Param("username")String username, @Param("password")String password);

}
