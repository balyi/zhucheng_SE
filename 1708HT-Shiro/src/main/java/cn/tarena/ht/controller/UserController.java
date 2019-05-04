package cn.tarena.ht.controller;

import java.util.List;

import javax.jws.WebParam.Mode;

import org.apache.commons.collections.functors.FalsePredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.DeptService;
import cn.tarena.ht.service.RoleService;
import cn.tarena.ht.service.UserInfoService;
import cn.tarena.ht.service.UserService;

@Controller
@RequestMapping("/sysadmin/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/list")
	public String userlist(Model model){
		
		List<User> users = userService.findAll();
		
		model.addAttribute("users", users);
		
		return "/sysadmin/user/jUserList";
	}
	
	@RequestMapping("/stop")
	public String stop(@RequestParam(value="userId",required=false)String[] ids){
		
		if (ids!=null) {
			userService.changeState(0,ids);
		}
		
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("/start")
	public String start(@RequestParam(value="userId",required=false)String[] ids){
		
		if (ids!=null) {
			userService.changeState(1,ids);
		}
		
		return "redirect:/sysadmin/user/list";
	}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="userId",required=false)String[] ids){
		
		if (ids!=null) {
			userService.delete(ids);
 		}
		
		return "redirect:/sysadmin/user/list";
	}
	@RequestMapping("/tocreate")
	public String tocreate(Model model){
		
		//给页面返回所有部门的数据
		//得到所有的部门
		List<Dept> depts = deptService.findAll();
		model.addAttribute("deptList", depts);
		//得到所有的用户信息
		List<UserInfo> userInfos = userInfoService.findAll();
		
		model.addAttribute("userInfos", userInfos);
		
		return "/sysadmin/user/jUserCreate";
	}
	
	
	@RequestMapping("/tosave")
	public String toSave(User user){
		
		
		userService.saveUser(user);
		
		return "redirect:/sysadmin/user/list";
	}
	@RequestMapping("/toupdate")
	public String toupdate(String userId,Model model){
		
		//通过id查询user并返回到页面中
		 User user = userService.findOne(userId);
		 
		 model.addAttribute("user",user);
		
		 
			List<Dept> depts = deptService.findAll();
			model.addAttribute("deptList", depts);
			//得到所有的用户信息
			List<UserInfo> userInfos = userInfoService.findAll();
			
			model.addAttribute("userInfos", userInfos);

		 
		 
		return "/sysadmin/user/jUserUpdate";
	}
	@RequestMapping("/update")
	public String update(User user){
		
		 
		userService.update(user);
		
		return "redirect:/sysadmin/user/list";
	}
	
	
	@RequestMapping("/toview")
	public String toview(String userId,Model model){
		
		//通过id查询user并返回到页面中
		 User user = userService.findOne(userId);
		 
		 model.addAttribute("user",user);
		return "/sysadmin/user/jUserView";
	}
	
	@RequestMapping("/role")
	public String role(String userId,Model model) throws JsonProcessingException{
			
		
		//得到传递过来用户所对应的所有角色
		List<String> userRoles = userService.findRoles(userId);
 
		//获取所有的角色
		List<Role> roles = roleService.findAll();
		
	
		//遍历所有的角色 如果此角色是用户所拥有的 则让checked=true
		for (Role role : roles) {
			
			//判断当前的角色是否在用户角色列表里面
			if (userRoles.contains(role.getId())) {
				role.setChecked(true);
			}
		}
		
		
		
		//把对象转成json字符串
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(roles);
		System.out.println(jsonString);
		model.addAttribute("zTreeJson",jsonString);
		
		//把id传递到页面中 因为下次请求需要用到
		model.addAttribute("id",userId);
		 
		return "/sysadmin/user/jUserRole";
	}
	@RequestMapping("/saveUserRole")
	public String saveUserRole(String userId,@RequestParam(required=false) String[] roleIds,Model model) throws JsonProcessingException{
		
		if (roleIds!=null) {
			//把用户和角色的关系保存到中间关系表中
			userService.saveUserAndRole(userId,roleIds);
			
		}
		
		
		
		return "redirect:/sysadmin/user/list";
	}
	
}
