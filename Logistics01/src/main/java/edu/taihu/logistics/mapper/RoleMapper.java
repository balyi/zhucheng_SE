package edu.taihu.logistics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.taihu.logistics.pojo.Role;

public interface RoleMapper {

//	@Select
//	@Update
//	@Insert
//	@Delete
	//使用@select注解形式 在注解里面写sql语句 通过范围值来控制 结果集的封装
	//单表的增删改查时 可以用到注解形式  如果使用了注解之后 需要把mapper映射文件里面的sql去掉不然会报错
	@Select("select * from role")
	public List<Role> findAll();

//	@Delete("") 因为 sql中需要遍历roleIds 需要使用<foreach标签所以不能注解形式
	public void delete(String[] roleIds);
	@Insert("insert into role (role_id,name,remarks) values (#{roleId},#{name},#{remarks})")
	public void saveRole(Role role);

	@Select("select * from role where role_id=#{roleId}")
	public Role findOne(String roleId);
	@Update("update role set name=#{name},remarks=#{remarks} where role_id=#{roleId}")
	public void update(Role role);

	public void saveRoleModule(@Param("roleId")String roleId, @Param("moduleIds")String[] moduleIds);

	@Delete("delete from role_module where role_id=#{roleId}")
	public void deleteModules(String roleId);

	
 
	public void deleteByUserIds(String[] ids);

	
	public void deleteUserRole(String[] roleIds);

	public void deleteRoleModules(String[] roleIds);
	
	
}
