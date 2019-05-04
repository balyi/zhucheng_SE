package cn.tedu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.entity.OrderInfo;
import cn.tedu.entity.User;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.OrderService;

public class OrderListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1、判断用户是否登录
		//1.1从session中获取登录的用户信息
		Object userObj = request.getSession().
				getAttribute("loginUser");
		//1.2判断userObj是否为null
		if(userObj==null){//未登录->login.jsp
			response.sendRedirect(request.
					getContextPath()+"/login.jsp");
			return;
		}
		//2获取登录的用户id
		int userId=((User)userObj).getId();
		//3调用业务层的方法查询结果
		//3.1创建业务层对象
		OrderService os=BasicFactory.getFactory().
				getInstance(OrderService.class);
		//3.2调用业务的方法查询结果
		List<OrderInfo> list = os.findOrderInfosByUid(userId);
		//4将查询结果保存到request中
		request.setAttribute("list",list);
		//5、转发到order_list.jsp
		request.getRequestDispatcher("/order_list.jsp").
			forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
