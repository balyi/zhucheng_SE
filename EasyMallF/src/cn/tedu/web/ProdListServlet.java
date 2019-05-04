package cn.tedu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.entity.Product;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.ProdService;

public class ProdListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1�����ղ���
		String nameStr=request.getParameter("name");
		String cateStr = request.getParameter("category");
		String minpriceStr=request.getParameter("minprice");
		String maxpriceStr=request.getParameter("maxprice");
		//2������Ϊnull�Ĵ���
		//2.1�����ĸ��������ֱ��Ĭ��ֵ
		String name="";
		String cate = "";
		Double min = null;
		Double max = null;
		//2.2.����Ϊnull
		//String:�жϽ��ղ���������ȥ���ո��ֵ
		if(nameStr!=null&&!"".equals(nameStr)){
			name = nameStr.trim();
		}
		if(cateStr!=null&&!"".equals(cateStr)){
			cate = cateStr.trim();
		}
		//Double:�жϽ��յĲ���������,ȥ���ո�����ת�����ڸ�ֵ
		if(minpriceStr!=null&&!"".equals(minpriceStr)){
			min = Double.parseDouble(minpriceStr.trim());
		}
		if(maxpriceStr!=null&&!"".equals(maxpriceStr)){
			max = Double.parseDouble(maxpriceStr);
		}
		//3������ҵ������
		ProdService ps =BasicFactory.getFactory().
					getInstance(ProdService.class);
		//4�����ø��ݲ�ѯ������ȫ��������������Ʒ
		List<Product> list = ps.findAllByKey(name,
				cate,min,max);
		//5����list���浽request��������
		request.setAttribute("list", list);
		//6�����ĸ���������request ->ʵ�ֲ�ѯ�����Ļ���
		request.setAttribute("name", name);
		request.setAttribute("cate", cate);
		request.setAttribute("min", min);
		request.setAttribute("max", max);
		//7��ת����/prod_list.jsp
		request.getRequestDispatcher("/prod_list.jsp").
			forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
