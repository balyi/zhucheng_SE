package edu.taihu.logistics.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.taihu.logistics.pojo.Module;
import edu.taihu.logistics.pojo.Role;
import edu.taihu.logistics.service.ModuleService;
import edu.taihu.logistics.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	private ModuleService moduleService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/to_rolelist")
	public String to_rolelist(Model model){
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles",roles);
		return "/manage/role_manage";
	}
	@RequestMapping("/role_delete")
	public String role_delete(Model model,@RequestParam(value="roleId", required=false)String[] roleIds){
		if (roleIds!=null) {
			roleService.delete(roleIds);
		}
		return "redirect:/to_rolelist";
	}
	@RequestMapping("/to_role_create")
	public String to_role_create(){
		return "/manage/role_create";
	}
	
	@RequestMapping("/role_create")
	public String role_create(Model model,Role role){
		roleService.saveRole(role);
		return "redirect:/to_rolelist";
	}
	
	@RequestMapping("/to_role_update")
	public String to_role_update(String roleId,Model model){
		Role role = roleService.findOne(roleId);
		model.addAttribute("role",role);
		return "/manage/role_update";
	}
	
	@RequestMapping("/role_update")
	public String role_update(Model model,Role role){
		roleService.update(role);
		return "redirect:/to_rolelist";
	}
	
	@RequestMapping("/to_role_module")
	public String to_role_module(String roleId, Model model) throws IOException{
		List<Module> modules = moduleService.findAll();
		List<String> roleModules = moduleService.findModulesByRoleId(roleId);
		for (Module module : modules) {
			//判断角色拥有的模块id是否包含当前遍历的模块 如果包含则让
			if (roleModules.contains(module.getModuleId())) {
				module.setChecked(true);
			}
		}
//		给页面传递 zTree格式的json字符串
		ObjectMapper mapper = new ObjectMapper();
		String zTreeJson = mapper.writeValueAsString(modules);
		model.addAttribute("zTreeJson",zTreeJson);
		model.addAttribute("id",roleId);
		return "/manage/role_module";
	}
	
	
	@RequestMapping("/save_role_module")
	public String save_role_module(String roleId,String[] moduleIds,Model model){
		roleService.saveRoleModule(roleId,moduleIds);
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles",roles);
		return "/manage/role_manage";
	}
}
