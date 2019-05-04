package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Dept;

public interface DeptService {

	public List<Dept> findAll();

	public void changeState(int i, String[] deptIds);

	public void delete(String[] deptIds);

	public void saveDept(Dept dept);

	public Dept findOne(String id);

	public void update(Dept dept);
}
