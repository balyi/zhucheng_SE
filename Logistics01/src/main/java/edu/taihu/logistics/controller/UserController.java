package edu.taihu.logistics.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.taihu.logistics.mapper.UserMapper;
import edu.taihu.logistics.pojo.Role;
import edu.taihu.logistics.pojo.User;
import edu.taihu.logistics.service.RoleService;
import edu.taihu.logistics.service.UserService;


@Controller
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/user_permit")
	public String user_permit(@RequestParam(value="userId",required=false)String[] ids){
		if (ids!=null) {
			userService.changeState(1,ids);
		}
		return "redirect:/to_userlist";
	}
	
	@RequestMapping("/user_forbit")
	public String user_forbit(@RequestParam(value="userId",required=false)String[] ids){
		if (ids!=null) {
			userService.changeState(0,ids);
		}
		return "redirect:/to_userlist";
	}
	
	@RequestMapping("/user_info")
	public String company_info(Model model,String userId) {
		User user = userService.findOneById(userId);
		model.addAttribute("user", user);
		return "/info/user_info";
	}
	@RequestMapping("/to_update_user")
	public String to_update_user(Model model,String userId) {
		User user = userService.findOneById(userId);
		model.addAttribute("user", user);
		return "/info/user_info_update";
	}
	@RequestMapping("/user_update")
	public String user_update(User user) {
		userService.updateUser(user);
		return "/info/user_info";
	}
	@RequestMapping("/to_userlist")
	public String to_userlist(Model model) {
		List<User> users=userService.findAll();
		model.addAttribute("users", users);
		return "/manage/user_manage";
	}
	
	@RequestMapping("/to_user_role")
	public String to_user_role(String userId,Model model) throws IOException{
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
		return "/manage/user_role";
	}
	@RequestMapping("/save_user_role")
	public String save_user_role(String userId,@RequestParam(required=false) String[] roleIds,Model model) throws JsonProcessingException{
		if (roleIds!=null) {
			//把用户和角色的关系保存到中间关系表中
			userService.saveUserAndRole(userId,roleIds);
		}
		return "redirect:/to_userlist";
	}
	
}
