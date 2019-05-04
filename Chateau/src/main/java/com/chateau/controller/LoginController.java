package com.chateau.controller;

import com.chateau.pojo.User;
import com.chateau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping("/wel")
	public String welcome() {
		return "login/welcome";
	}

	@RequestMapping("/tologin")
	public String tologin() {
		return "login/login";
	}

	@RequestMapping("/toregist")
	public String toregist() {
		return "login/regist";
	}

	@RequestMapping("/toindex")
	public String toindex() {
		return "home/index";
	}

	@RequestMapping("/login")
	public String login(String username, String password, String remname,
						String rempwd,
						Model model, HttpSession session, HttpServletRequest request,
						HttpServletResponse response){

		User user=userService.login(username,password);

		if(user==null){
			model.addAttribute("errorInfo", "用户名或密码错误");
			return "login/login";
		}
		if("true".equals(remname)){
			Cookie cookie = new Cookie("remname",username);
			cookie.setMaxAge(3600 * 24 * 30);
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
		}else{
			Cookie cookie = new Cookie("remname", "");
			cookie.setMaxAge(0);
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
		}

		if("true".equals(rempwd)){
			Cookie atlCk=new Cookie("rempwd",password);
			atlCk.setPath("/");
			atlCk.setMaxAge(30*24*3600);
			response.addCookie(atlCk);
		}else{
			Cookie atlCk = new Cookie("rempwd", "");
			atlCk.setMaxAge(0);
			atlCk.setPath(request.getContextPath()+"/");
			response.addCookie(atlCk);
		}

		session.setAttribute("USER", user);
		return "redirect:/login/toindex";
	}

	@RequestMapping("/regist")
	public String tosave(User user,Model model,HttpServletResponse response) throws IOException {
		boolean result = userService.isExist(user.getUsername());
		//5.根据查询的是否存在的结果做对应的响应
		if(result){
			PrintWriter out = response.getWriter();
			out.print("<script language=\"javascript\">alert('用户名已存在！');window.location.href='Chateau/login/regist'</script>");
			model.addAttribute("msg","对不起，用户名已存在，请重新输入");
			return "forward:/login/toregist";
		}else{
			userService.saveUser(user);
			return "redirect:/login/tologin";
		}

	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request,
						 HttpServletResponse response){
		session.invalidate();
		//销毁自动登录的cookie
		Cookie ck=new Cookie("autologin", null);
		ck.setPath("/");
		ck.setMaxAge(0);
		response.addCookie(ck);

//		session.removeAttribute("USER");
		return "redirect:/login/toindex";
	}
}
