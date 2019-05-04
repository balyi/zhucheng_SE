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
		//1���ն���id
		String oid=request.getParameter("id");
		//2����ҵ������
		OrderService os = BasicFactory.getFactory().
				getInstance(OrderService.class);
		//3������ҵ���ɾ�����������Ϣ�ķ���
		try{
			os.deleteOrderByOid(oid);
			//4��ɾ���ɹ���������ʾ
			response.getWriter().write("��ϲ��ɾ���ɹ�!");
		}catch(MsgException me){
			//4ɾ��ʧ�ܣ�������ʾ
			response.getWriter().write(me.getMessage());
		}
		//5�����Զ���ת
		response.setHeader("refresh", "3;url="+
		request.getContextPath()+"/OrderListServlet");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
