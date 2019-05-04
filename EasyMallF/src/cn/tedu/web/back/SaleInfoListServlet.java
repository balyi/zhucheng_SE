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
		//1创建业务层对象
		OrderService os = BasicFactory.getFactory().
				getInstance(OrderService.class);
		//2调用业务层方法
		List<SaleInfo> list = os.findSaleInfos();
		//3将查询结果保存到request
		request.setAttribute("list", list);
		//4转发到sale_list.jsp
		request.getRequestDispatcher("/back/sale_list.jsp").
			forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
