package cn.tedu.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;
import cn.tedu.exception.MsgException;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.UserService;
import cn.tedu.service.impl.UserServiceImpl;
import cn.tedu.utils.MD5Utils;


public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		
		User user=new User();
		/**
		 * key				value
		 * String    		String[]
		 * username   {"abc"}
		 */
		//页面中表单name一定要和User中的类名和属性名一样
		try {
			BeanUtils.populate(user, request.getParameterMap());
			user.check();
		} catch (MsgException e) {
			// 跳转到注册页面
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/regist").forward(request, response);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	
		
		Object obj=request.getSession().getAttribute("code");
		if(obj==null||!user.getValistr().toUpperCase().equals((String)obj)){
			request.setAttribute("vali_msg", "验证码输入错误");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		String token1=request.getParameter("token");
		Object tkObj=request.getSession().getAttribute("token");
		if(tkObj!=null&&token1.equals((String)tkObj)){
			request.getSession().removeAttribute("token");
		}else{
			throw new RuntimeException("请不要重复提交");
		}
		
		
		UserService userService=BasicFactory.getFactory().getInstance(UserService.class);
		try {
			user.setPassword(MD5Utils.md5(user.getPassword()));
			boolean result=userService.regist(user);
			if(result){
			response.getWriter().write("<h6 stype='color:blue'>注册成功，将跳转</h6>");
			response.setHeader("Refresh", "3;url="+request.getContextPath()+"/index.jsp");
			}else{
				response.getWriter().write("<h6 stype='color:blue'>注册失败，将跳转</h6>");
				response.setHeader("Refresh", "3;url="+request.getContextPath()+"/regist.jsp");
			}
		} catch (MsgException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
