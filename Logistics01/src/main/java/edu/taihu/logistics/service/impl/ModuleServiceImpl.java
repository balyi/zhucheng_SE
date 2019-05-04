package edu.taihu.logistics.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.taihu.logistics.mapper.ModuleMapper;
import edu.taihu.logistics.pojo.Module;
import edu.taihu.logistics.service.ModuleService;
@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleMapper moduleMapper;
	@Override
	public List<Module> findAll() {
		return moduleMapper.findAll();
	}
	@Override
	public void delete(String[] moduleIds) {
		moduleMapper.deleteModuleRole(moduleIds);
		moduleMapper.delete(moduleIds);
	}
	@Override
	public void save(Module module) {
		module.setModuleId(UUID.randomUUID().toString());
		moduleMapper.save(module);
	}
	@Override
	public Module findOne(String moduleId) {
		return moduleMapper.findOne(moduleId);
	}
	@Override
	public void update(Module module) {
		  moduleMapper.update(module);
	}
	@Override
	public List<String> findModulesByRoleId(String roleId) {
		return moduleMapper.findModulesByRoleId(roleId);
	}

}
