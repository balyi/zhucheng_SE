package cn.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.entity.Product;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.ProdService;

public class ProdInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1��������Ʒid
		String id = request.getParameter("id");
		//2������ҵ������
		ProdService ps =BasicFactory.getFactory().
				getInstance(ProdService.class);
		//3������ҵ��������Ʒid��ѯ��Ʒ����ķ���
		Product prod =ps.findProdById(id);
		//4����prod���浽request��
		request.setAttribute("prod",prod);
		//5��ת��prod_list.jsp
		request.getRequestDispatcher("/prod_info.jsp")
			.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
