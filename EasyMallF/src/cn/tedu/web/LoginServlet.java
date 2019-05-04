package cn.tedu.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.tedu.entity.User;
import cn.tedu.service.UserService;
import cn.tedu.service.impl.UserServiceImpl;
import cn.tedu.utils.DaoUtils;
import cn.tedu.utils.MD5Utils;
/**
 * 处理用户的登陆请求
 */
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理请求参数乱码
		//request.setCharacterEncoding("utf-8");
		//1获取登陆信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remname = request.getParameter("remname");
		//A2.创建业务层对象
		UserService userService=new UserServiceImpl();
		//A3.调用业务层的方法
		password = MD5Utils.md5(password);
		User user = userService.login(username,password);
		//A4.判断登陆是否成功
		if(user==null){
			//A5登陆失败,提示用户名或密码错误->login.jsp
			request.setAttribute("msg", "用户名或密码错误！");
			request.getRequestDispatcher("/login.jsp").
				forward(request,response);
		}else{
			//A6登录成功
			//判断是否需要记住用户名
			if("true".equals(remname)){
				//将用户名进行url编码之后再存入Cookie中
				Cookie cookie = new Cookie("remname", URLEncoder.encode(username, "utf-8"));
				//设置Cookie的最大存活时间
				cookie.setMaxAge(3600 * 24 * 30);//30天
				//设置Cookie的路径
				cookie.setPath(request.getContextPath()+"/");
				//将Cookie添加到响应中
				response.addCookie(cookie);
			}else{//取消记住用户名(删除Cookie)
				Cookie cookie = new Cookie("remname", "");
				cookie.setMaxAge(0);//立即删除Cookie!
				cookie.setPath(request.getContextPath()+"/");
				response.addCookie(cookie);
			}
			//30天自动登录
			if("true".equals(request.getParameter(
					"autologin"))){
				//创建cookie对象
				Cookie atlCk = new Cookie("autologin",
						URLEncoder.encode(username+","+password, "UTF-8"));
				atlCk.setPath("/");
				atlCk.setMaxAge(2592000);//30*24*3600
				response.addCookie(atlCk);
			}
			//A7将用户信息保存进session中
			request.getSession().setAttribute(
					"loginUser", user);
			//登陆成功, 跳转到首页!!
			response.sendRedirect(request.getContextPath()
						+"/index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
