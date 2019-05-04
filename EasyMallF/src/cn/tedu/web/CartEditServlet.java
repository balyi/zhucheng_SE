package cn.tedu.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.entity.Product;

public class CartEditServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1接收参数
		String id = request.getParameter("id");
		int buynum=Integer.parseInt(request.
				getParameter("newBuyNum"));
		//2、从session从获取cart
		Object cartObj =request.getSession().
				getAttribute("cart");
		//3判断cartObj是否为null
		if(cartObj==null){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{//4不为null
			//4.1强制类型转
			Map<Product,Integer> cart = 
					(Map<Product,Integer>)cartObj;
			//4.2创建Product对象
			Product prod =new Product();
			prod.setId(id);
			//5执行修改操作
			cart.put(prod, buynum);
			//6、跳转到cart.jsp
			response.sendRedirect(request.getContextPath()+"/cart.jsp");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
