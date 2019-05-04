package cn.tedu.service;

import java.util.List;

import cn.tedu.entity.Order;
import cn.tedu.entity.OrderInfo;
import cn.tedu.entity.OrderItem;
import cn.tedu.entity.SaleInfo;
import cn.tedu.exception.MsgException;

public interface OrderService {
	/**添加订单相关信息（向orders添加一条，向orderitem表中
	 * 添加oiList.size()条数据，修改products表对应商品的库存）
	 * @param order：封装了订单信息的对象
	 * @param oiList：封装了订单项相关信息对象的集合对象
	 * @throws MsgException遇到添加的商品库存不足抛出异常
	 */
	void addOrder(Order order, List<OrderItem> oiList) 
			throws MsgException;
	/**根据用户id查询对应用户的全部订单信息
	 * @param userId：用户id
	 * @return 对应用户的全部订单 信息
	 */
	List<OrderInfo> findOrderInfosByUid(int userId);
	/**根据订单id删除该订单相关信息，并还原该订单购买的所用
	 * 商品的库存
	 * @param oid：订单id
	 * @throws MsgException：删除非“未支付”的订单时抛出异常
	 */
	void deleteOrderByOid(String oid) throws MsgException;
	/**根据订单id查询对应订单的相关信息（来自于orders）
	 * @param oid:订单id
	 * @return 对应订单的相关信息
	 */
	Order findOrderByOid(String oid);
	/**修改订单的支付状态 0：表示未支付,1表示已支付
	 * @param oid：订单id
	 * @param paystate：修改后的支付状态
	 */
	void changePaystate(String oid, int paystate);
	/**查询全部的销售榜单列表
	 * @return 全部的销售榜单
	 */
	List<SaleInfo> findSaleInfos();
}
