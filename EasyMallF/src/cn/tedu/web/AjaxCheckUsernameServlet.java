package cn.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.factory.BasicFactory;
import cn.tedu.service.UserService;
import cn.tedu.service.impl.UserServiceImpl;
import cn.tedu.utils.DaoUtils;

public class AjaxCheckUsernameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.������Ӧ���ĺ������������
		//response.setContentType("text/html;charset=utf-8");
		//request.setCharacterEncoding("utf-8");
		//2.��ȡ�û���(���ղ���)
		String username = request.getParameter("username");
		//3����ҵ���Ķ���
		UserService userService =BasicFactory.getFactory()
				.getInstance(UserService.class);
		//4.����ҵ���ķ�������û����Ƿ����
		boolean result = userService.unIsExist(username.trim());
		//5.���ݲ�ѯ���Ƿ���ڵĽ������Ӧ����Ӧ
		if(result){
			response.getWriter().write("<font style='color:red'>�û����Ѵ���!</font>");
		}else{
			response.getWriter().write("<font style='color:green'>��ϲ���û�������ʹ��!</font>");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
