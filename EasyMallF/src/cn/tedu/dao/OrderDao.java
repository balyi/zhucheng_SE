package cn.tedu.dao;

import java.sql.Connection;
import java.util.List;

import cn.tedu.entity.Order;
import cn.tedu.entity.OrderItem;
import cn.tedu.entity.SaleInfo;

public interface OrderDao {
	/**向orders表中添加一条订单信息的数据
	 * @param con：数据库连接对象
	 * @param order：封装了订单相关信息的对象
	 */
	void addOrder(Connection con, Order order);
	/**向orderItem表中添加一条订单项目信息的数据
	 * @param con：数据库连接对象
	 * @param item：封装了订单项目相关信息的对象
	 */
	void addOrderItem(Connection con, OrderItem item);
	/**根据用户id从orders表查询userId对应的全部订单
	 * @param userId:用户的id
	 * @return 对应全部订单
	 */
	List<Order> findOrdersByUid(int userId);
	/**根据用户id从orderitem表中查询userId对应的全部订单项目
	 *该查询涉及到两张表(orders和orderitem)的关联查询
	 * @param userId:用户id
	 * @return userId对应的全部订单项目
	 */
	List<OrderItem> findOrderItemsByUid(int userId);
	/**根据订单的id查询订单的详细信息（事务版）
	 * @param con：数据库连接对象
	 * @param oid：订单的id
	 * @return：对应的订单详细信息
	 */
	Order findOrderByOid(Connection con, String oid);
	/**根据订单id查询对应的订单下的全部订单项
	 * @param con：数据库连接对象
	 * @param oid：订单id
	 * @return oid对应订单下的全部订单项
	 */
	List<OrderItem> findOrderItemsByOid(Connection con, String oid);
	/**根据订单id从orderitem表中删除对应订单下的全部订单项目
	 * @param con：数据库连接对象
	 * @param oid：订单id
	 */
	void deleteOrderItemsByOid(Connection con, String oid);
	/**根据订单id从orders表删除对应的订单信息
	 * @param con：数据库连接对象
	 * @param oid：订单id
	 */
	void deleteOrderByOid(Connection con, String oid);
	/**根据订单的id查询订单的详细信息（非事务版）
	 * @param con：数据库连接对象
	 * @param oid：订单的id
	 * @return：对应的订单详细信息
	 */
	Order findOrderByOid(String oid);
	/**修改订单的支付状态
	 * @param oid：订单id
	 * @param paystate：修改后的订单状态
	 */
	void changePaystate(String oid, int paystate);
	/**查询全部的销售榜单列表
	 * @return 全部的销售榜单
	 */
	List<SaleInfo> findSaleInfos();
}
