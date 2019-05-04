package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;

public interface UserInfoMapper {

 
	public void delete(String[] ids);

	public List<UserInfo> findAll();

	public void saveUserInfo(UserInfo userInfo);

	public void update(UserInfo userInfo);
}
