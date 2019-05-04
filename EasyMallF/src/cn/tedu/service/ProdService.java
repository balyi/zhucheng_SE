package cn.tedu.service;

import java.util.List;

import cn.tedu.entity.Product;
//���ȹ��ŵ��ӿ�������->Ctrl+T->�¼�ͷ
public interface ProdService {
	/**��ѯȫ����Ʒ
	 * @return ȫ����Ʒ��Ӧ���϶���
	 */
	public List<Product> findAll();
	/**�޸���Ʒ�Ŀ��
	 * @param id����Ʒid
	 * @param pnum���޸ĺ����Ʒ����
	 * @return true:��ʾ�޸ĳɹ���false����ʾ�޸�ʧ��
	 */
	public boolean changePnum(String id, int pnum);
	/**������Ʒidɾ����Ʒ��Ϣ
	 * @param id����Ʒid
	 * @return true:��ʾɾ���ɹ���false��ʾɾ��ʧ��
	 */
	public boolean deleteProdById(String id);
	/**���ݹؼ��ֲ�ѯ������������Ʒ
	 * @param name����Ʒ���ƹؼ���
	 * @param cate����Ʒ����ؼ���
	 * @param min���۸��������Сֵ
	 * @param max���۸���������ֵ
	 * @return ������ӵ���Ʒ����
	 */
	public List<Product> findAllByKey(String name, String cate, Double min,
			Double max);
	/**������Ʒid��ѯ��Ӧ��Ʒ����ϸ��Ϣ����
	 * @param id����Ʒid
	 * @return����Ӧ��Ʒ����ϸ��Ϣ
	 */
	public Product findProdById(String id);
}
