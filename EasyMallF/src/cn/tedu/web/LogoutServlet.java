package cn.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����session
		request.getSession().invalidate();
		//�����Զ���¼��cookie
		Cookie ck = new Cookie("autologin",null);
		ck.setPath("/");
		ck.setMaxAge(0);
		response.addCookie(ck);
		//�ض���index.jsp
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		/*request.getRequestDispatcher("/index.jsp").
			forward(request, response);*/
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
