package cn.tedu.dao;

import cn.tedu.entity.User;

public interface UserDao {
	/**根据用户名和密码查询对应的用户信息，存在返回对应的用户信息,
	 * 反之返回null
	 * @param username:用户名
	 * @param password：密码
	 * @return 存在则返回User类对象，反之返回null
	 */
	User login(String username, String password);
	/**判断用户名是否存在
	 * @param username：用户名
	 * @return true:表示存在，false表示不能存在
	 */
	boolean unIsExist(String username);
	/**向数据库的user表中添加一条用户信息
	 * @param user：封装了用户信息User类对象
	 * @return 影响的行数
	 */
	int regist(User user);
}
