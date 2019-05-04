package edu.taihu.logistics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.taihu.logistics.pojo.Module;
import edu.taihu.logistics.service.ModuleService;

@Controller
public class ModuleController {

	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping("/to_modulelist")
	public String findAll(Model model){
		List<Module> modules = moduleService.findAll();
		model.addAttribute("modules",modules);
		return "/manage/module_manage";
	}
	@RequestMapping("/to_module_update")
	public String to_module_update(String moduleId,Model model){
		Module module = moduleService.findOne(moduleId);
		model.addAttribute("module",module);
		return "/manage/module_update";
	}
	
	@RequestMapping("/module_update")
	public String module_update(Model model,Module module){
		moduleService.update(module);
		return "redirect:/to_modulelist";
	}
	
}
