package cn.tedu.dao;

import java.sql.Connection;
import java.util.List;

import cn.tedu.entity.Order;
import cn.tedu.entity.OrderItem;
import cn.tedu.entity.SaleInfo;

public interface OrderDao {
	/**��orders�������һ��������Ϣ������
	 * @param con�����ݿ����Ӷ���
	 * @param order����װ�˶��������Ϣ�Ķ���
	 */
	void addOrder(Connection con, Order order);
	/**��orderItem�������һ��������Ŀ��Ϣ������
	 * @param con�����ݿ����Ӷ���
	 * @param item����װ�˶�����Ŀ�����Ϣ�Ķ���
	 */
	void addOrderItem(Connection con, OrderItem item);
	/**�����û�id��orders���ѯuserId��Ӧ��ȫ������
	 * @param userId:�û���id
	 * @return ��Ӧȫ������
	 */
	List<Order> findOrdersByUid(int userId);
	/**�����û�id��orderitem���в�ѯuserId��Ӧ��ȫ��������Ŀ
	 *�ò�ѯ�漰�����ű�(orders��orderitem)�Ĺ�����ѯ
	 * @param userId:�û�id
	 * @return userId��Ӧ��ȫ��������Ŀ
	 */
	List<OrderItem> findOrderItemsByUid(int userId);
	/**���ݶ�����id��ѯ��������ϸ��Ϣ������棩
	 * @param con�����ݿ����Ӷ���
	 * @param oid��������id
	 * @return����Ӧ�Ķ�����ϸ��Ϣ
	 */
	Order findOrderByOid(Connection con, String oid);
	/**���ݶ���id��ѯ��Ӧ�Ķ����µ�ȫ��������
	 * @param con�����ݿ����Ӷ���
	 * @param oid������id
	 * @return oid��Ӧ�����µ�ȫ��������
	 */
	List<OrderItem> findOrderItemsByOid(Connection con, String oid);
	/**���ݶ���id��orderitem����ɾ����Ӧ�����µ�ȫ��������Ŀ
	 * @param con�����ݿ����Ӷ���
	 * @param oid������id
	 */
	void deleteOrderItemsByOid(Connection con, String oid);
	/**���ݶ���id��orders��ɾ����Ӧ�Ķ�����Ϣ
	 * @param con�����ݿ����Ӷ���
	 * @param oid������id
	 */
	void deleteOrderByOid(Connection con, String oid);
	/**���ݶ�����id��ѯ��������ϸ��Ϣ��������棩
	 * @param con�����ݿ����Ӷ���
	 * @param oid��������id
	 * @return����Ӧ�Ķ�����ϸ��Ϣ
	 */
	Order findOrderByOid(String oid);
	/**�޸Ķ�����֧��״̬
	 * @param oid������id
	 * @param paystate���޸ĺ�Ķ���״̬
	 */
	void changePaystate(String oid, int paystate);
	/**��ѯȫ�������۰��б�
	 * @return ȫ�������۰�
	 */
	List<SaleInfo> findSaleInfos();
}
