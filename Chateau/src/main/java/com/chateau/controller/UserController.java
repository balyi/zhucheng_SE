package com.chateau.controller;

import com.chateau.pojo.User;
import com.chateau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by tedu on 2017/11/24.
 */
@Controller
@RequestMapping("/back")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/customer")
	public String userlist(Model model){
		List<User> users=userService.findAll();
		model.addAttribute("users", users);
		return "back/customer";
	}


	@RequestMapping("/deleteUser")
	public String delete(@RequestParam(value="userId",required=false)String[] ids){
		if(ids!=null){
			userService.delete(ids);
		}
		return "redirect:/back/customer";
	}

	@RequestMapping("/toUpdateUser")
	public String toupdate(String userId,Model model){
		User user=userService.findOne(userId);
		model.addAttribute("user", user);
		return "back/UserUpdate";

	}
	@RequestMapping("/updateUser")
	public String update(User user){
		userService.update(user);
		return "redirect:/back/customer";
	}

	@RequestMapping("/toCreateUser")
	public String toCreate(){
		return "back/UserCreate";
	}

	@RequestMapping("/toSaveUser")
	public String toSave(User user){
		userService.saveUser(user);
		return "redirect:/back/customer";
	}

}
