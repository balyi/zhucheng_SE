package cn.tedu.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cn.tedu.entity.User;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.UserService;

public class AutoLoginFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//1���жϵ�ǰ�Ƿ��¼��ֻ��δ��¼�Ŵ����Զ���¼
		//1.1��ǿ������ת��
		HttpServletRequest req = (HttpServletRequest)request;
		//1.2����ȡsession�е�¼���û���Ϣ
		Object obj=req.getSession().getAttribute("loginUser");
		//1.3���ж��Ƿ�Ϊδ��¼
		if(obj==null){//δ��¼
			//2����ȡ���е�cookie
			Cookie[] cks = req.getCookies();
			//3��cks��Ϊnullʱ������cks
			if(cks!=null){
				//4������cks�����Զ���¼��cookie
				Cookie ck = null;
				for(int i =0;i<cks.length;i++){
					if("autologin".equals(cks[i].getName())){
						ck = cks[i];
						break;
					}
				}
				//5���ж��Ƿ�����Զ���¼��cookie
				if(ck!=null){
					//6����ȡ�û��������룬������URL������
					String up = URLDecoder.decode(ck.getValue(), "UTF-8");
					//7�����в��
					String username = up.split(",")[0];
					String password = up.split(",")[1];
					//8������ҵ������
					UserService us = BasicFactory.getFactory().
							getInstance(UserService.class);
					//9�����õ�¼�ķ���
					User user = us.login(username, password);
					//10���û�����������ȷʵ�ֵ�¼
					if(user!=null){
						req.getSession().setAttribute(
								"loginUser", user);
					}
				}
			}
		}
		//����
		chain.doFilter(request, response);
	}
	public void destroy() {
	}
}
