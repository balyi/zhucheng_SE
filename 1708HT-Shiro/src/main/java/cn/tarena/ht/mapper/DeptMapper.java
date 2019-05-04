package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Dept;

public interface DeptMapper {

	public List<Dept> findAll();
//mapper默认只能传递一个参数 多个的话 可以封装到对象中或者是装到 map中
//	@Param 把参数 自动封装到Map中 注解中的字符串为 key  参数为value
	public void changeState(@Param("state")int i, @Param("deptIds")String[] deptIds);
	
	public void delete(String[] deptIds);
	public void saveDept(Dept dept);
	public Dept findOne(String id);
	public void update(Dept dept);
}
