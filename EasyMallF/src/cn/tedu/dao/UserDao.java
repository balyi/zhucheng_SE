package cn.tedu.dao;

import cn.tedu.entity.User;

public interface UserDao {
	/**�����û����������ѯ��Ӧ���û���Ϣ�����ڷ��ض�Ӧ���û���Ϣ,
	 * ��֮����null
	 * @param username:�û���
	 * @param password������
	 * @return �����򷵻�User����󣬷�֮����null
	 */
	User login(String username, String password);
	/**�ж��û����Ƿ����
	 * @param username���û���
	 * @return true:��ʾ���ڣ�false��ʾ���ܴ���
	 */
	boolean unIsExist(String username);
	/**�����ݿ��user�������һ���û���Ϣ
	 * @param user����װ���û���ϢUser�����
	 * @return Ӱ�������
	 */
	int regist(User user);
}
