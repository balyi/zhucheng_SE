package cn.tedu.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.entity.Order;
import cn.tedu.entity.OrderItem;
import cn.tedu.entity.Product;
import cn.tedu.entity.User;
import cn.tedu.exception.MsgException;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.OrderService;

public class OrderAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.判断用户是否登录
		//1.1从session中获取loginUser
		Object userObj=request.getSession().getAttribute("loginUser");
		//1.2判断userObj是否为Null
		if(userObj==null){//未登录->null
			request.setAttribute("msg", "添加订单请先登录");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
			//2.从session中获取cart，判断是否为null
			//2.1从session中获取cart
		Object cartObj=	request.getSession().getAttribute("cart");
		//2.2判断cartObj是否为null
		if(cartObj==null){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
		}
		//3.创建Order对象，并为属性赋值
		//3.1创建Order类对象order
		Order order=new Order();
		order.setId(UUID.randomUUID().toString());
		order.setOrdertime(new Date());
		order.setPaystate(0);
		order.setReceiverinfo(request.getParameter("receiverinfo"));
		order.setUser_id(((User)userObj).getId());
		//4.遍历购物车中的商品信息，封装List<OrderItem>和计算money值
		//4.1定义double类型的money
		double money=0;
		//4.2定义集合List<OrderItem>,保存订单项目对象的集合
		List<OrderItem> oiList=new ArrayList<OrderItem>();
		//4.3强制类型转换cartObj
		Map<Product, Integer> cart=(Map<Product, Integer>)cartObj;
		//4.4遍历cart
		for(Map.Entry<Product, Integer> entry:cart.entrySet()){
			//4.5创建OrderItem对象
			OrderItem item=new OrderItem();
			//4.6为item设置属性值
			item.setOrder_id(order.getId());
			item.setProduct_id(entry.getKey().getId());
			item.setBuynum(entry.getValue());
			//4.7计算小计
			money+=entry.getKey().getPrice()*entry.getValue();
			//4.8将item添加到list中
			oiList.add(item);
		}
		//5.为order设置money属性的值
		order.setMoney(money);
		//6.调用业务层添加订单的方法
		//6.1创建业务层对象
		OrderService os=BasicFactory.getFactory().getInstance(OrderService.class);
		
		try {
			//6.2调用业务层添加订单的方法
			os.addOrder(order,oiList);
			//7添加成功
			//7.1清空购物车
			cart.clear();
			//7.2提示添加成功
			response.getWriter().write("订单添加成功，将跳转");
			//7.3设置定刷新
			response.setHeader("Refresh", "1;url="+request.getContextPath()+"/OrderListServlet");
		} catch (MsgException e) {
			//8添加失败
			//8.1设置提示信息
			request.setAttribute("msg", e.getMessage());
			//8.2转发到cart.jsp
			request.getRequestDispatcher("/cart.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
