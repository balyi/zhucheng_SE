package cn.tedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;
import cn.tedu.utils.BeanHandler;
import cn.tedu.utils.DaoUtils;

public class UserDaoImpl implements UserDao {
	//ctrl+shift+O�������õ�������
	//Ctrl+Shift+Enter���ڹ�����ڵ��в���һ������
	private Connection conn=null;
	//Shift+Enter���ڹ�������е���һ�в���һ������
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public User login(String username, String password) {
		try {//Ctrl+1:���try catch����
			//A2����дsql���
			String sql = "select * from user" +
					" where username=?" +
					" and password=?";
			//A3��ִ�в�ѯ������������User�����
			return DaoUtils.query(sql, 
					new BeanHandler<User>(User.class),
					username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//8�����ڷ���null
		return null;
	}
	public boolean unIsExist(String username) {
		try {
			//A2����дsql
			String sql = "select * from user where username=?";
			//A3����ѯ���ؽ������������
			return DaoUtils.query(sql, new BeanHandler<User>(User.class),
					username)!=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public int regist(User user) {
		try {
			//A1������QueryRunner����
			//QueryRunner qr =new QueryRunner(DaoUtils.getPool());
			//A2����дsql���
			String sql = "insert into user(username,password,nickname,email,role)" +
					"values(?,?,?,?,?)";
			//A3��ִ�в������������Ӱ�������
			return DaoUtils.update(sql, user.getUsername(),user.getPassword(),
					user.getNickname(),user.getEmail(),"user");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} 
	}

}
