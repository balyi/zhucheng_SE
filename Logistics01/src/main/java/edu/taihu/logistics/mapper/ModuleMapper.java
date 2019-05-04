package edu.taihu.logistics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.taihu.logistics.pojo.Module;

public interface ModuleMapper {
	
	public List<Module> findAll();
	
	public void delete(String[] moduleIds);

	@Insert("insert into module (module_id,name,ctype,remark) values (#{moduleId},#{name},#{ctype},#{remark})")
	public void save(Module module);

	public Module findOne(String moduleId);

	@Update("update module set name=#{name},ctype=#{ctype},remark=#{remark} where module_id=#{moduleId}")
	public void update(Module module);
	
	@Select("select module_id from role_module where role_id=#{roleId}")
	public List<String> findModulesByRoleId(String roleId);

	public void deleteModuleRole(String[] moduleIds);

	public String[] findModuleIdsBy(String userId);

	public List<String> findModuleNamesByIds(String[] moduleIds);
}
