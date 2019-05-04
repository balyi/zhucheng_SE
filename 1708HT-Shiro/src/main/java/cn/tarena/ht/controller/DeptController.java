package cn.tarena.ht.controller;

import java.util.List;

import javax.jws.WebParam.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;

@Controller
@RequestMapping("/sysadmin/dept")
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	
	@RequestMapping("/list")
	public String deptList(Model model){
		List<Dept> depts = deptService.findAll();
 
		model.addAttribute("deptList", depts);
		
		return "/sysadmin/dept/jDeptList";
	}
	
	//*****************单个启用或停止*******************
//	@RequestMapping("/sysadmin/dept/stop")
//	public String startAction(String deptId){
//		
//		
//		deptService.changeState(0,deptId);
//		//继续显示部门列表页面 
////		重新发出一个 列表页面的请求
//		return "redirect:/sysadmin/dept/list";
//		
//	}
//	
//	@RequestMapping("/sysadmin/dept/start")
//	public String stopAction(String deptId){
//		
//		
//		deptService.changeState(1,deptId);
//		//继续显示部门列表页面 
////		重新发出一个 列表页面的请求
//		return "redirect:/sysadmin/dept/list";
//	}
	
	//*****************单个启用或停止*******************
	
//	批量启用或停止*******************
	@RequestMapping("/stop")
	public String startAction(@RequestParam(value="deptId",required=false)String[] deptIds){
		
		if (deptIds!=null) {
			
			deptService.changeState(0,deptIds);
		}
		//继续显示部门列表页面 
//		重新发出一个 列表页面的请求
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("/start")
	public String stopAction(@RequestParam(value="deptId",required=false)String[] deptIds){
	 
		if (deptIds!=null) {
			
			deptService.changeState(1,deptIds);
		}
		
		//继续显示部门列表页面 
//		重新发出一个 列表页面的请求
		return "redirect:/sysadmin/dept/list";
	}
//	批量启用或停止*******************
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="deptId", required=false)String[] deptIds){
		//只有当用户选择了删除的部门才做操作
		if (deptIds!=null) {
			
			deptService.delete(deptIds);
			
		}
		
		//让部门列表页面重新刷新
		return "redirect:/sysadmin/dept/list";
	}
	@RequestMapping("/tocreate")
	public String toCreate(Model model){
	 
		//给页面提供上级部门的信息 为了做下拉列表
		List<Dept> depts = deptService.findAll();
		model.addAttribute("deptList",depts);
		 
		return "/sysadmin/dept/jDeptCreate";
	}
	
//	拦截保存的请求
	@RequestMapping("/tosave")
	public String tosave(Dept dept){
		
 	deptService.saveDept(dept);
		
		
		return "redirect:/sysadmin/dept/list";
	}
//	拦截查看的请求
	@RequestMapping("/toview")
	public String toview(String deptId,Model model){
		
	Dept dept = deptService.findOne(deptId);
		
		model.addAttribute("dept", dept);
		return "/sysadmin/dept/jDeptView";
	}
	
	
	@RequestMapping("/toupdate")
	public String toupdate(String deptId,Model model){
		//查询单个对象
		Dept dept = deptService.findOne(deptId);
		
		model.addAttribute("dept", dept);
		//查询所有的部门 为了下拉列表
		List<Dept> parentDepts = deptService.findAll();
		model.addAttribute("parentDepts", parentDepts);

		return "/sysadmin/dept/jDeptUpdate";
	}
	@RequestMapping("/update")
	public String update(Dept dept){
		
		deptService.update(dept);
	 
		//修改完之后返回列表页面
		return "redirect:/sysadmin/dept/list";
	}
	
	
}
