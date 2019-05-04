package cn.tedu.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodeFilter implements Filter {
	private String encode;
	public void init(FilterConfig config) throws ServletException {
		encode = config.getInitParameter("encode");
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html;charset="+encode);
		chain.doFilter(new MyHttpSR(
				(HttpServletRequest)request), response);
	}
	public void destroy() {
	}
	class MyHttpSR extends HttpServletRequestWrapper{
		private Map<String,String[]> map =null;
		//��װ�εĶ���
		private HttpServletRequest request;
		public MyHttpSR(HttpServletRequest request) {
			super(request);
			this.request = request;
		}
		public Map<String,String[]> getParameterMap() {
			if(map==null){
				//�ж��ύ����ķ�ʽ��GET��POST����������������
				if("POST".equals(request.getMethod())){
					try {
						//��������
						request.setCharacterEncoding(encode);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					map = request.getParameterMap();
					return map;
				}else if("GET".equals(request.getMethod())){
					//��ȡ�ύ������
					map = request.getParameterMap();
					//��������ÿһ�������е�����
					for(Map.Entry<String, String[]> entry:map.entrySet()){
						//��ȡvalue��ֵ
						String vals[] = entry.getValue();
						//�����������е�����
						for(int i = 0;i<vals.length;i++){
							try {
								vals[i] = new String(vals[i].getBytes("iso8859-1"),encode);
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
						}
					}
					return map;
				}else{//���������ύ��������զ��զ��
					map= request.getParameterMap();
					return map;
				}
			}else{
				return map;
			}
		}
		@Override
		public String[] getParameterValues(String name) {
			return getParameterMap().get(name);
		}
		@Override
		public String getParameter(String name) {
			String vals[]= getParameterValues(name);
			return vals!=null?vals[0]:"";
		}
	}
}
