package edu.taihu.logistics.service;

import java.util.List;

import edu.taihu.logistics.pojo.Module;

public interface ModuleService {
	public List<Module> findAll();

	public void delete(String[] moduleIds);

	public void save(Module module);

	public Module findOne(String moduleId);

	public void update(Module module);

	public List<String> findModulesByRoleId(String roleId);
}
