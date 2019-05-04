package edu.taihu.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.taihu.pojo.User;
import edu.taihu.service.UserService;
import edu.taihu.tool.MD5Utils;

@Controller
public class LogistController {
	@Autowired
	private UserService userService;

	@RequestMapping("/tologin")
	public String tologin() {
		return "/login";
	}

	@RequestMapping("/login")
	public String login(HttpSession session,Model model, User user, String remname, String autologin, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		user.setPassword(MD5Utils.md5(user.getPassword()));
		User user2 = userService.login(user.getUsername(), user.getPassword());
		if (user2 == null) {
			model.addAttribute("msg", "用户名或密码错误！");
			return "redirect:/tologin";
		} else {
			if ("true".equals(remname)) {
				Cookie cookie = new Cookie("remname", URLEncoder.encode(user2.getUsername(), "utf-8"));
				cookie.setMaxAge(3600 * 24 * 30);// 30天
				cookie.setPath(request.getContextPath() + "/");
				response.addCookie(cookie);
			} else {// 取消记住用户名(删除Cookie)
				Cookie cookie = new Cookie("remname", "");
				cookie.setMaxAge(0);// 立即删除Cookie!
				cookie.setPath(request.getContextPath() + "/");
				response.addCookie(cookie);
			}
			// 30天自动登录
			if ("true".equals(autologin)) {
				// 创建cookie对象
				Cookie atlCk = new Cookie("autologin",URLEncoder.encode(user2.getUsername() + "," + user2.getPassword(), "UTF-8"));
				atlCk.setPath("/");
				atlCk.setMaxAge(2592000);// 30*24*3600
				response.addCookie(atlCk);
			}
			session.setAttribute("loginUser", user2);
			return "/index";
		}
	}
}
