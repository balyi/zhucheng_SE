package edu.taihu.logistics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.taihu.logistics.pojo.User;
import edu.taihu.logistics.pojo.UserInfo;

public interface UserInfoMapper {
	public void saveUserInfo(UserInfo userInfo);

	public void updateUserInfo(UserInfo userInfo);
}
