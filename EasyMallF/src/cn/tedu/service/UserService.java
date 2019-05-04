package cn.tedu.service;

import cn.tedu.entity.User;
import cn.tedu.exception.MsgException;

public interface UserService {
	/**ҵ�������û���������ʵ�ֵ�¼����������û�������
	 * �ܹ���ѯ���û���Ϣ�򷵻ظ��û�����Ϣ����֮����null
	 * @param username���û���
	 * @param password������
	 * @return �����򷵻�User user���������򷵻�null
	 */
	public User login(String username, String password);
	/**�ж��û�����user�����Ƿ����
	 * @param username���û���
	 * @return true:��ʾ���ڣ�false��ʾ������
	 */
	public boolean unIsExist(String username);
	/**ע���û�
	 * @param user��User��Ķ��󣨷�װ���û���ע��ҳ���ύ
	 * ����Ϣ)
	 * @return true:��ʾע��ɹ���false��ʾע��ʧ��
	 * @throws MsgException �û����Ѵ����׳��쳣
	 */
	public boolean regist(User user) throws MsgException;
}
