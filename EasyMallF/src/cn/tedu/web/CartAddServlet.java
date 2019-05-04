package cn.tedu.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.entity.Product;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.ProdService;

public class CartAddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1�����ղ���
		String id = request.getParameter("id");
		int buynum=Integer.parseInt(request.
				getParameter("buynum"));
		//2������ҵ�񷽷���ѯ��Ӧ����Ʒ����
		//2.1����ҵ������
		ProdService ps = BasicFactory.getFactory().
				getInstance(ProdService.class);
		//2.2����ҵ��㷽��
		Product prod = ps.findProdById(id);
		//3����session��ȡcart����
		Object cartObj=request.getSession().
				getAttribute("cart");
		//4���ж�cartObj�Ƿ�Ϊnull�������Ƿ�Ϊnull,ִ�к�Ҫ��
		//֤session���ڹ��ﳵ��Ӧ��Map����
		//4.1����һ�����϶���
		Map<Product,Integer> cart = null;
		//4.2ִ���ж�
		if(cartObj==null){//���״Ρ�������Ʒ
			cart = new HashMap<Product,Integer>();
			request.getSession().setAttribute("cart", cart);
		}else{//���״ι���
			cart = (Map<Product,Integer>)cartObj;
		}
		//5��prod��buynum���浽cart��
		if(cart.containsKey(prod)){//��ǰ��Ʒ�Ѿ������
			cart.put(prod, cart.get(prod)+buynum);
		}else{//��ǰ��δ�����
			cart.put(prod, buynum);
		}
		//6��ת��cart.jsp
		response.sendRedirect(request.getContextPath()+"/cart.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
