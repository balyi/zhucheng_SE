package cn.tedu.service;

import java.util.List;

import cn.tedu.entity.Order;
import cn.tedu.entity.OrderInfo;
import cn.tedu.entity.OrderItem;
import cn.tedu.entity.SaleInfo;
import cn.tedu.exception.MsgException;

public interface OrderService {
	/**��Ӷ��������Ϣ����orders���һ������orderitem����
	 * ���oiList.size()�����ݣ��޸�products���Ӧ��Ʒ�Ŀ�棩
	 * @param order����װ�˶�����Ϣ�Ķ���
	 * @param oiList����װ�˶����������Ϣ����ļ��϶���
	 * @throws MsgException������ӵ���Ʒ��治���׳��쳣
	 */
	void addOrder(Order order, List<OrderItem> oiList) 
			throws MsgException;
	/**�����û�id��ѯ��Ӧ�û���ȫ��������Ϣ
	 * @param userId���û�id
	 * @return ��Ӧ�û���ȫ������ ��Ϣ
	 */
	List<OrderInfo> findOrderInfosByUid(int userId);
	/**���ݶ���idɾ���ö��������Ϣ������ԭ�ö������������
	 * ��Ʒ�Ŀ��
	 * @param oid������id
	 * @throws MsgException��ɾ���ǡ�δ֧�����Ķ���ʱ�׳��쳣
	 */
	void deleteOrderByOid(String oid) throws MsgException;
	/**���ݶ���id��ѯ��Ӧ�����������Ϣ��������orders��
	 * @param oid:����id
	 * @return ��Ӧ�����������Ϣ
	 */
	Order findOrderByOid(String oid);
	/**�޸Ķ�����֧��״̬ 0����ʾδ֧��,1��ʾ��֧��
	 * @param oid������id
	 * @param paystate���޸ĺ��֧��״̬
	 */
	void changePaystate(String oid, int paystate);
	/**��ѯȫ�������۰��б�
	 * @return ȫ�������۰�
	 */
	List<SaleInfo> findSaleInfos();
}
