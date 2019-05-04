package cn.tedu.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.entity.Product;

public class CartDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1�����ղ���
		String id = request.getParameter("id");
		//2����session�л�ȡcart
		Object cartObj = request.getSession().
				getAttribute("cart");
		//3���ж�cartObj�Ƿ�Ϊnull
		if(cartObj==null){//Ϊnull->index.jsp
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{//��Ϊnull
			//4��ִ��ɾ����Ʒ�Ĳ���
			Map<Product,Integer> cart = 
					(Map<Product,Integer>)cartObj;
			Product prod = new Product();
			prod.setId(id);
			cart.remove(prod);
			//5��ת��cart.jsp
			response.sendRedirect(request.getContextPath()+"/cart.jsp");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
