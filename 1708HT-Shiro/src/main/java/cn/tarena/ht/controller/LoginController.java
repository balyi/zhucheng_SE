package cn.tarena.ht.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;
import cn.tarena.ht.tool.Md5Utils;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("tologin")
	public String tologin(){
		
		return "/sysadmin/login/login";
	}
//	@RequestMapping("login")
//	public String login(String username,String password,Model model,HttpSession session){
//		
//		
//		if (StringUtils.isEmpty(username)||StringUtils.isEmpty(password)) {
//			
//			 model.addAttribute("errorInfo","用户名或密码不能为空！");
//			return "/sysadmin/login/login";
//		}
//		
//		password = Md5Utils.getMd5(password, username);
//		
//		User user = userService.login(username,password);
//		
//		if (user==null) {
//			 model.addAttribute("errorInfo","用户名或密码不正确！");
//				return "/sysadmin/login/login";
//		}
//		//把登录成功的用户信息 保存到session域中
//		session.setAttribute("_CURRENT_USER", user);
//		
//		//登录成功跳转到首页
//		return "redirect:/home";
//	}
	
	
	@RequestMapping("login")
	public String login(String username,String password,Model model,HttpSession session){
		
		//代表当前用户
		 Subject subject = SecurityUtils.getSubject();
		
		 UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		 
		 
		 try {
			 subject.login(token);
			 
			 //得到登录成功的user
			 User user = (User) subject.getPrincipal();
			 
			 session.setAttribute("_CURRENT_USER", user);
			 
			 return "redirect:/home";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			
			 model.addAttribute("errorInfo","用户名或密码不正确！");
 			return "/sysadmin/login/login";
		}

	}
	
	
	//退出登录
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("_CURRENT_USER");
		
//		通知shiro框架 退出登录
		Subject subject = SecurityUtils.getSubject();
		
		//判断是否是登录状态 如果是则退出
		if (subject.isAuthenticated()) {
			subject.logout();
		}
		
		return "/sysadmin/login/logout";
		
	}
	

}
