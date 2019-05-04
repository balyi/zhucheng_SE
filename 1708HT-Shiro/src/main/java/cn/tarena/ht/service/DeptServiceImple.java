package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.DeptMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.Dept;

@Service
public class DeptServiceImple implements DeptService{

	@Autowired
	private DeptMapper mapper;
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		
		
		return mapper.findAll();
	}

	@Override
	public void changeState(int i, String[] deptIds) {
		// TODO Auto-generated method stub
		
		mapper.changeState(i,deptIds);
	}

	@Override
	public void delete(String[] deptIds) {
		// TODO Auto-generated method stub
	
		//删除用户表里面
//		update user_p set dept_id="" where dept_id in (#{deptId}
		userMapper.deleteDepts(deptIds);
		
		mapper.delete(deptIds);
	}

	@Override
	public void saveDept(Dept dept) {
		// TODO Auto-generated method stub
		mapper.saveDept(dept);
	}

	@Override
	public Dept findOne(String id) {
		// TODO Auto-generated method stub
		
		return mapper.findOne(id);
	}

	@Override
	public void update(Dept dept) {
		// TODO Auto-generated method stub
		mapper.update(dept);
		
	}

}
