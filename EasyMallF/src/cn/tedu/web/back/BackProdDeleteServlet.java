package cn.tedu.web.back;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.factory.BasicFactory;
import cn.tedu.service.ProdService;

public class BackProdDeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1�����ղ���
		String id = request.getParameter("id");
		//2������ҵ������
		ProdService ps = BasicFactory.getFactory().
				getInstance(ProdService.class);
		//3������ɾ���ķ���
		boolean result = ps.deleteProdById(id);
		//4�����ݷ��ؽ��������ʾ��Ϣ
		if(result){
			response.getWriter().write("ɾ���ɹ�!");
		}else{
			response.getWriter().write("ɾ��ʧ��!");
		}
		//5���ö�ʱ��ת
		response.setHeader("refresh", "3;url="+
				request.getContextPath()+"/back/BackProdListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
