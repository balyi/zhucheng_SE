package cn.tedu.web.back;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.entity.SaleInfo;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.OrderService;

public class SaleInfoListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1����ҵ������
		OrderService os = BasicFactory.getFactory().
				getInstance(OrderService.class);
		//2����ҵ��㷽��
		List<SaleInfo> list = os.findSaleInfos();
		//3����ѯ������浽request
		request.setAttribute("list", list);
		//4ת����sale_list.jsp
		request.getRequestDispatcher("/back/sale_list.jsp").
			forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
