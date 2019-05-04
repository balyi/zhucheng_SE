package cn.tedu.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.entity.Order;
import cn.tedu.entity.OrderItem;
import cn.tedu.entity.Product;
import cn.tedu.entity.User;
import cn.tedu.exception.MsgException;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.OrderService;

public class OrderAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.�ж��û��Ƿ��¼
		//1.1��session�л�ȡloginUser
		Object userObj=request.getSession().getAttribute("loginUser");
		//1.2�ж�userObj�Ƿ�ΪNull
		if(userObj==null){//δ��¼->null
			request.setAttribute("msg", "��Ӷ������ȵ�¼");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
			//2.��session�л�ȡcart���ж��Ƿ�Ϊnull
			//2.1��session�л�ȡcart
		Object cartObj=	request.getSession().getAttribute("cart");
		//2.2�ж�cartObj�Ƿ�Ϊnull
		if(cartObj==null){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
		}
		//3.����Order���󣬲�Ϊ���Ը�ֵ
		//3.1����Order�����order
		Order order=new Order();
		order.setId(UUID.randomUUID().toString());
		order.setOrdertime(new Date());
		order.setPaystate(0);
		order.setReceiverinfo(request.getParameter("receiverinfo"));
		order.setUser_id(((User)userObj).getId());
		//4.�������ﳵ�е���Ʒ��Ϣ����װList<OrderItem>�ͼ���moneyֵ
		//4.1����double���͵�money
		double money=0;
		//4.2���弯��List<OrderItem>,���涩����Ŀ����ļ���
		List<OrderItem> oiList=new ArrayList<OrderItem>();
		//4.3ǿ������ת��cartObj
		Map<Product, Integer> cart=(Map<Product, Integer>)cartObj;
		//4.4����cart
		for(Map.Entry<Product, Integer> entry:cart.entrySet()){
			//4.5����OrderItem����
			OrderItem item=new OrderItem();
			//4.6Ϊitem��������ֵ
			item.setOrder_id(order.getId());
			item.setProduct_id(entry.getKey().getId());
			item.setBuynum(entry.getValue());
			//4.7����С��
			money+=entry.getKey().getPrice()*entry.getValue();
			//4.8��item��ӵ�list��
			oiList.add(item);
		}
		//5.Ϊorder����money���Ե�ֵ
		order.setMoney(money);
		//6.����ҵ�����Ӷ����ķ���
		//6.1����ҵ������
		OrderService os=BasicFactory.getFactory().getInstance(OrderService.class);
		
		try {
			//6.2����ҵ�����Ӷ����ķ���
			os.addOrder(order,oiList);
			//7��ӳɹ�
			//7.1��չ��ﳵ
			cart.clear();
			//7.2��ʾ��ӳɹ�
			response.getWriter().write("������ӳɹ�������ת");
			//7.3���ö�ˢ��
			response.setHeader("Refresh", "1;url="+request.getContextPath()+"/OrderListServlet");
		} catch (MsgException e) {
			//8���ʧ��
			//8.1������ʾ��Ϣ
			request.setAttribute("msg", e.getMessage());
			//8.2ת����cart.jsp
			request.getRequestDispatcher("/cart.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
