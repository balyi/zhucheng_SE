package cn.tedu.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cn.tedu.entity.User;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DaoUtils {
	private static ComboPooledDataSource pool = new ComboPooledDataSource();
	private DaoUtils(){}
	public static ComboPooledDataSource getPool(){
		return pool;
	}
	public static Connection getConn() throws SQLException{
		return pool.getConnection();
	}
	/**查询方法（即可以查一条数据，也可以查多条数据）
	 * @param sql：sql语句
	 * @param rsh：查一条数据new BeanHandler<T>(T.class)
	 * 查多条数据 new BeanListHandler<T>(T.class)
	 * @param params:查询条件的查询
	 * @return 查询一条 返回T t；查多条返回List<T>
	 * @throws SQLException
	 */
	public static <T> T query(String sql, ResultSetHandler<T> rsh,
			Object... params) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//1获取数据库连接
			conn = getConn();
			//2、预编译sql语句并返回ps
			ps = conn.prepareStatement(sql);
			//3、为占位符赋值
			for(int i =0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			//4、执行查询操作,并返回结果集
			rs = ps.executeQuery();
			//5、rs->T t或List<T>
			return rsh.handle(rs);
		}catch (SQLException e) {
			//6、抛出异常
			throw e;
		}finally{
			DaoUtils.close(conn, ps, rs);
		}
	}
	public static <T> T query(Connection conn,String sql, ResultSetHandler<T> rsh,
			Object... params) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//1获取数据库连接
			//2、预编译sql语句并返回ps
			ps = conn.prepareStatement(sql);
			//3、为占位符赋值
			for(int i =0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			//4、执行查询操作,并返回结果集
			rs = ps.executeQuery();
			//5、rs->T t或List<T>
			return rsh.handle(rs);
		}catch (SQLException e) {
			//6、抛出异常
			throw e;
		}finally{
			//7千千万万不要关闭数据库连接对象conn
			DaoUtils.close(null, ps, rs);
		}
	}
	/**添加、修改、删除都调用该方法
	 * @param sql：sql语句
	 * @param params：为占位符赋值的参数（对象数组）
	 * @return 影响的行数
	 * @throws SQLException
	 */
	public static int update(String sql, Object... params) throws SQLException {
		//1、声明数据连接相关对象
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//2、获取数据库连接
			conn = getConn();
			//3、预编译sql语句，并返回ps对象
			ps = conn.prepareStatement(sql);
			//4、为占位符赋值
			/*for(int i =1;i<=params.length;i++){
				ps.setObject(i, params[i-1]);
			}*/
			for(int i = 0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			//5、执行操作（添加/修改/删除），并返回影响的行数
			return ps.executeUpdate();
		}catch (SQLException e) {
			//6、继续抛出异常
			throw e;
		}finally{
			//7、关闭数据库连接相关对象
			DaoUtils.close(conn, ps, null);
		}
	}
	public static int update(Connection conn,String sql, Object... params) throws SQLException {
		//1、声明数据连接相关对象
		PreparedStatement ps = null;
		try{
			//3、预编译sql语句，并返回ps对象
			ps = conn.prepareStatement(sql);
			//4、为占位符赋值
			/*for(int i =1;i<=params.length;i++){
				ps.setObject(i, params[i-1]);
			}*/
			for(int i = 0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			//5、执行操作（添加/修改/删除），并返回影响的行数
			return ps.executeUpdate();
		}catch (SQLException e) {
			//6、继续抛出异常
			throw e;
		}finally{
			//7、千千万万不要关闭数据库连接
			DaoUtils.close(null, ps, null);
		}
	}
	public static void main(String[] args) {
		String sql = "select * from user ";
		try {
			List<User> list = query(sql, 
					new BeanListHandler<User>(User.class));
			for (User user : list) {
				System.out.println(user.getId()+","+user.getUsername());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 关闭资源
	 * @param conn 数据库连接
	 * @param ps   传输器
	 * @param rs   结果集
	 */
	public static void close(Connection conn, Statement stat, ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				rs = null;
			}
		}
		if( stat != null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				stat = null;
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				conn = null;
			}
		}
	}
}
