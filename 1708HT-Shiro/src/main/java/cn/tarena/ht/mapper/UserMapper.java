package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.User;

public interface UserMapper {

	public List<User> findAll();

	public void changeState(@Param("state")Integer i, @Param("ids")String[] ids);

	public void delete(String[] ids);

	public void saveUser(User user);

	public User findOne(String userId);

	public void update(User user);
 
	public void saveUserAndRole(@Param("userId")String userId, @Param("roleIds")String[] roleIds);

//	注解形式的查询数据库操作 返回值是什么类型 结果集就会封装到什么类型里面，相当于resultType
	@Select("select role_id from role_user_p where user_id=#{userId}")
	public List<String> findRoles(String userId);
	@Delete("delete from role_user_p where user_id=#{userId}")
	public void deleteRoles(String userId);

	
	public void deleteDepts(String[] deptIds);

	public User login(@Param("username")String username, @Param("password")String password);

	public User findOneByUsername(String username);

	public List<String> findModuleNamesBy(String userId);
	
}
