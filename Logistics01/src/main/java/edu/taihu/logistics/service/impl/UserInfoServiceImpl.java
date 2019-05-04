package edu.taihu.logistics.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.taihu.logistics.mapper.UserInfoMapper;
import edu.taihu.logistics.pojo.UserInfo;
import edu.taihu.logistics.service.UserInfoService;
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	

}
