package cn.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.factory.BasicFactory;
import cn.tedu.service.UserService;
import cn.tedu.service.impl.UserServiceImpl;
import cn.tedu.utils.DaoUtils;

public class AjaxCheckUsernameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.处理响应正文和请求参数乱码
		//response.setContentType("text/html;charset=utf-8");
		//request.setCharacterEncoding("utf-8");
		//2.获取用户名(接收参数)
		String username = request.getParameter("username");
		//3创建业务层的对象
		UserService userService =BasicFactory.getFactory()
				.getInstance(UserService.class);
		//4.调用业务层的方法检查用户名是否存在
		boolean result = userService.unIsExist(username.trim());
		//5.根据查询的是否存在的结果做对应的响应
		if(result){
			response.getWriter().write("<font style='color:red'>用户名已存在!</font>");
		}else{
			response.getWriter().write("<font style='color:green'>恭喜，用户名可以使用!</font>");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
