package cn.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.utils.VerifyCode;

public class ValiImageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* �����������Ҫ������֤��ͼƬ */
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		
		/* ����һ����֤��ͼƬ���͸������ */
		VerifyCode vc = new VerifyCode();
		vc.drawImage(response.getOutputStream());
		//��ȡ��֤���ı�
		String valistr = vc.getCode();
		//����֤���ַ������浽session��,�Ա���ע���
		//servlet����֤ʹ�á�
		System.out.println("code="+valistr);
		request.getSession().
			setAttribute("code", valistr);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
