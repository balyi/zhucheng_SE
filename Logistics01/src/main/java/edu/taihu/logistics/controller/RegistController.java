package edu.taihu.logistics.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.taihu.logistics.pojo.User;
import edu.taihu.logistics.service.UserService;

@Controller
public class RegistController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/toregist")
	public String tologin(){
		return "/logist/regist";
	}
	@RequestMapping("/regist")
	public String tosave(User user,Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(user.getUserInfo().getCompany().equals("")||user.getUserInfo().getCompany()==null) {
			model.addAttribute("msg","公司名称不能为空");
			model.addAttribute("user",user);
			return "/logist/regist";
		}
		if(user.getUsername().equals("")||user.getUsername()==null) {
			model.addAttribute("msg","账号不能为空");
			model.addAttribute("user",user);
			return "/logist/regist";
		}
		if(user.getPassword().equals("")||user.getPassword()==null) {
			model.addAttribute("msg","密码不能为空");
			model.addAttribute("user",user);
			return "/logist/regist";
		}
		if(!user.getPassword2().equals(user.getPassword())) {
			model.addAttribute("msg","两次密码不一致");
			model.addAttribute("user",user);
			return "/logist/regist";
		}
		if(user.getUserInfo().getName().equals("")||user.getUserInfo().getName()==null) {
			model.addAttribute("msg","负责人不能为空");
			model.addAttribute("user",user);
			return "/logist/regist";
		}
		if(user.getUserInfo().getEmail().equals("")||user.getUserInfo().getEmail()==null) {
			model.addAttribute("msg","邮箱不能为空");
			if(user.getUserInfo().getEmail().matches("^\\w+@\\w+(\\.[a-z]+)+$"));
			model.addAttribute("msg","邮箱格式不正确");
			model.addAttribute("user",user);
			return "/logist/regist";
		}
		if(user.getUserInfo().getTel().equals("")||user.getUserInfo().getTel()==null) {
			model.addAttribute("msg","手机号不能为空");
			if(user.getUserInfo().getTel().matches("^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\\d{8}$"));
			model.addAttribute("msg","手机号格式不正确");
			model.addAttribute("user",user);
			return "/logist/regist";
		}
		boolean result = userService.isExist(user.getUsername());
		//5.根据查询的是否存在的结果做对应的响应
		if(result){
			model.addAttribute("msg","对不起，用户名已存在，请重新输入");
			model.addAttribute("user",user);
			return "/logist/regist";
		}else{
			userService.saveUser(user);
			return "redirect:/tologin";
		}

	}
}
