package cn.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.exception.MsgException;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.OrderService;

public class OrderDeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1接收订单id
		String oid=request.getParameter("id");
		//2创建业务层对象
		OrderService os = BasicFactory.getFactory().
				getInstance(OrderService.class);
		//3、调用业务层删除订单相关信息的方法
		try{
			os.deleteOrderByOid(oid);
			//4、删除成功，给予提示
			response.getWriter().write("恭喜您删除成功!");
		}catch(MsgException me){
			//4删除失败，给予提示
			response.getWriter().write(me.getMessage());
		}
		//5设置自动跳转
		response.setHeader("refresh", "3;url="+
		request.getContextPath()+"/OrderListServlet");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
