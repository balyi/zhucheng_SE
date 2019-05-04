package cn.tedu.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.tedu.dao.OrderDao;
import cn.tedu.dao.ProdDao;
import cn.tedu.entity.Order;
import cn.tedu.entity.OrderInfo;
import cn.tedu.entity.OrderItem;
import cn.tedu.entity.Product;
import cn.tedu.entity.SaleInfo;
import cn.tedu.exception.MsgException;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.OrderService;
import cn.tedu.utils.DaoUtils;

public class OrderServiceImpl implements OrderService {
	//����OrderDao��ProdDao����
	private ProdDao prodDao=BasicFactory.getFactory().
			getInstance(ProdDao.class);
	private OrderDao orderDao=BasicFactory.getFactory().
			getInstance(OrderDao.class);
	//����Connection����
	private Connection con =null;
	public void addOrder(Order order, List<OrderItem> oiList)
			throws MsgException {
		try {
			//1����ȡ���ݿ����ӡ���������
			//1.1��ȡ���ݿ�����
			con = DaoUtils.getConn();
			//1.2��������
			con.setAutoCommit(false);
			//2.�����orders�������һ�����ݵķ���
			orderDao.addOrder(con,order);
			//3.����oiList,��һ���в���
			for(OrderItem item:oiList){
				//4�жϿ���Ƿ���ڣ������׳��Զ����쳣
				//4.1������Ʒid��ѯ��Ʒ����ϸ��Ϣ
				Product prod=prodDao.findProdById(con,
						item.getProduct_id());
				//4.2�жϿ���Ƿ����
				if(prod.getPnum()<item.getBuynum()){
					throw new MsgException("��治��,id:"+prod.getId()
					+",name:"+prod.getName()+",pnum:"+prod.getPnum());
				}
				//5���㣬�޸���Ʒ�Ŀ��
				prodDao.changePnum(con,prod.getId(),
							prod.getPnum()-item.getBuynum());
				//6��orderitem�������һ����Ϣ
				orderDao.addOrderItem(con,item);
			}
			//7�ύ����
			con.commit();
		} catch (MsgException me) {
			//7�ع�����
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			//���Ž�me�׸�OrderAddServlet
			throw me;
		}catch (SQLException e) {
			e.printStackTrace();
			//7�ع�����
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			//8�ر����ݿ�����
			DaoUtils.close(con, null, null);
		}
	}
	public List<OrderInfo> findOrderInfosByUid(int userId) {
		//1���弯�϶��󱣴�����
		List<OrderInfo> resultList=
				new ArrayList<OrderInfo>();
		//2��orders���ѯuserId��Ӧȫ������
		List<Order> orderList=orderDao.findOrdersByUid(userId);
		//3��orderitem���ѯuserId��Ӧȫ��������
		List<OrderItem> itemList=orderDao.
				findOrderItemsByUid(userId);
		//4������orderList
		for(Order order:orderList){
			//5����OrderInfo����
			OrderInfo info=new OrderInfo();
			//6Ϊinfo�����Ը�ֵ
			//6.1Ϊ����order��ֵ
			info.setOrder(order);
			//6.2Ϊ����map��ֵ
			//6.2.1����Map<Product,Integer> map
			Map<Product,Integer> map=
					new HashMap<Product,Integer>();
			//6.2.2����itemList
			for(OrderItem item:itemList){
				if(item.getOrder_id().equals(order.getId())){
					Product prod =prodDao.findProdById(
							item.getProduct_id());
					map.put(prod, item.getBuynum());
				}
			}
			//6.2.3��map���浽info��map����
			info.setMap(map);
			//7��info��ӵ�resultList��
			resultList.add(info);
		}
		return resultList;
	}
	public void deleteOrderByOid(String oid) throws MsgException {
		//1����ȡ���ݿ����Ӳ���������
		try {
			//1.1��ȡ���ݿ�����
			con = DaoUtils.getConn();
			//1.2��������
			con.setAutoCommit(false);
			//2ֻ��δ֧���Ķ������ܹ�ɾ��
			//2.1���ݶ���id��ѯ������Ϣ
			Order order=orderDao.findOrderByOid(con,oid);
			//2.2����ö����Ѿ�������ɾ��
			if(order==null){
				throw new MsgException("�ö��������ڣ�����Ҫ�ٴ�ɾ����");
			}
			//2.3�������δ֧���Ķ����׳��Զ����쳣
			if(order.getPaystate()!=0){
				throw new MsgException("ֻ��δ֧���Ķ�������ɾ��");
			}
			//3.���ݶ�����ѯ�ö��������еĶ�����
			List<OrderItem> itemList=orderDao.
					findOrderItemsByOid(con,oid);
			//4����itemList����ԭÿһ����Ʒ�Ŀ��
			for(OrderItem item:itemList){
				prodDao.updatePnum(con,item.getProduct_id(),
						item.getBuynum());
			}
			//5�����ݶ���id(oid)ɾ��orderitem���е����ж�����
			orderDao.deleteOrderItemsByOid(con,oid);
			//6�����ݶ���id��oid��ɾ��orders����һ����¼
			orderDao.deleteOrderByOid(con,oid);
			//7�ύ����
			con.commit();
		}catch(MsgException me){
			//7�ع�����
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//���Զ����쳣�����׸����ø÷�����
			throw me;
		} catch (SQLException e) {
			e.printStackTrace();
			//7�ع�����
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			//8�ر����ݿ����Ӷ���
			DaoUtils.close(con, null, null);
		}
	}
	public Order findOrderByOid(String oid) {
		return orderDao.findOrderByOid(oid);
	}
	public void changePaystate(String oid, int paystate) {
		orderDao.changePaystate(oid,paystate);
	}
	public List<SaleInfo> findSaleInfos() {
		return orderDao.findSaleInfos();
	}
}
