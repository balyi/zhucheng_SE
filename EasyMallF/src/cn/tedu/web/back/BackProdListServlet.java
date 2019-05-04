package cn.tedu.web.back;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.entity.Product;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.ProdService;

public class BackProdListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.����ҵ������
		ProdService prodService=BasicFactory.getFactory().
					getInstance(ProdService.class);
		//2.����ҵ����ѯȫ����Ʒ�ķ���
		List<Product> list = prodService.findAll();
		//3.��list����request��������
		request.setAttribute("list", list);
		//4.ת����/back/prod_list.jsp
		request.getRequestDispatcher("/back/prod_list.jsp")
			.forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
