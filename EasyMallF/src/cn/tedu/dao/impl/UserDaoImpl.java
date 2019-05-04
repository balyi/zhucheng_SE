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
	//ctrl+shift+O：导入用到的类型
	//Ctrl+Shift+Enter：在光标所在的行插入一个空行
	private Connection conn=null;
	//Shift+Enter：在光标所在行的下一行插入一个空行
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public User login(String username, String password) {
		try {//Ctrl+1:添加try catch语句块
			//A2、编写sql语句
			String sql = "select * from user" +
					" where username=?" +
					" and password=?";
			//A3、执行查询操作，并返回User类对象
			return DaoUtils.query(sql, 
					new BeanHandler<User>(User.class),
					username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//8不存在返回null
		return null;
	}
	public boolean unIsExist(String username) {
		try {
			//A2、编写sql
			String sql = "select * from user where username=?";
			//A3、查询返回结果，并处理结果
			return DaoUtils.query(sql, new BeanHandler<User>(User.class),
					username)!=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public int regist(User user) {
		try {
			//A1、创建QueryRunner对象
			//QueryRunner qr =new QueryRunner(DaoUtils.getPool());
			//A2、编写sql语句
			String sql = "insert into user(username,password,nickname,email,role)" +
					"values(?,?,?,?,?)";
			//A3、执行插入操作并返回影响的行数
			return DaoUtils.update(sql, user.getUsername(),user.getPassword(),
					user.getNickname(),user.getEmail(),"user");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} 
	}

}
