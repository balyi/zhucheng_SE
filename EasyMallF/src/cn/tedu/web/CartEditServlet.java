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
		//1���ղ���
		String id = request.getParameter("id");
		int buynum=Integer.parseInt(request.
				getParameter("newBuyNum"));
		//2����session�ӻ�ȡcart
		Object cartObj =request.getSession().
				getAttribute("cart");
		//3�ж�cartObj�Ƿ�Ϊnull
		if(cartObj==null){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{//4��Ϊnull
			//4.1ǿ������ת
			Map<Product,Integer> cart = 
					(Map<Product,Integer>)cartObj;
			//4.2����Product����
			Product prod =new Product();
			prod.setId(id);
			//5ִ���޸Ĳ���
			cart.put(prod, buynum);
			//6����ת��cart.jsp
			response.sendRedirect(request.getContextPath()+"/cart.jsp");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
