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
	/**��ѯ�����������Բ�һ�����ݣ�Ҳ���Բ�������ݣ�
	 * @param sql��sql���
	 * @param rsh����һ������new BeanHandler<T>(T.class)
	 * ��������� new BeanListHandler<T>(T.class)
	 * @param params:��ѯ�����Ĳ�ѯ
	 * @return ��ѯһ�� ����T t�����������List<T>
	 * @throws SQLException
	 */
	public static <T> T query(String sql, ResultSetHandler<T> rsh,
			Object... params) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//1��ȡ���ݿ�����
			conn = getConn();
			//2��Ԥ����sql��䲢����ps
			ps = conn.prepareStatement(sql);
			//3��Ϊռλ����ֵ
			for(int i =0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			//4��ִ�в�ѯ����,�����ؽ����
			rs = ps.executeQuery();
			//5��rs->T t��List<T>
			return rsh.handle(rs);
		}catch (SQLException e) {
			//6���׳��쳣
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
			//1��ȡ���ݿ�����
			//2��Ԥ����sql��䲢����ps
			ps = conn.prepareStatement(sql);
			//3��Ϊռλ����ֵ
			for(int i =0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			//4��ִ�в�ѯ����,�����ؽ����
			rs = ps.executeQuery();
			//5��rs->T t��List<T>
			return rsh.handle(rs);
		}catch (SQLException e) {
			//6���׳��쳣
			throw e;
		}finally{
			//7ǧǧ����Ҫ�ر����ݿ����Ӷ���conn
			DaoUtils.close(null, ps, rs);
		}
	}
	/**��ӡ��޸ġ�ɾ�������ø÷���
	 * @param sql��sql���
	 * @param params��Ϊռλ����ֵ�Ĳ������������飩
	 * @return Ӱ�������
	 * @throws SQLException
	 */
	public static int update(String sql, Object... params) throws SQLException {
		//1����������������ض���
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//2����ȡ���ݿ�����
			conn = getConn();
			//3��Ԥ����sql��䣬������ps����
			ps = conn.prepareStatement(sql);
			//4��Ϊռλ����ֵ
			/*for(int i =1;i<=params.length;i++){
				ps.setObject(i, params[i-1]);
			}*/
			for(int i = 0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			//5��ִ�в��������/�޸�/ɾ������������Ӱ�������
			return ps.executeUpdate();
		}catch (SQLException e) {
			//6�������׳��쳣
			throw e;
		}finally{
			//7���ر����ݿ�������ض���
			DaoUtils.close(conn, ps, null);
		}
	}
	public static int update(Connection conn,String sql, Object... params) throws SQLException {
		//1����������������ض���
		PreparedStatement ps = null;
		try{
			//3��Ԥ����sql��䣬������ps����
			ps = conn.prepareStatement(sql);
			//4��Ϊռλ����ֵ
			/*for(int i =1;i<=params.length;i++){
				ps.setObject(i, params[i-1]);
			}*/
			for(int i = 0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			//5��ִ�в��������/�޸�/ɾ������������Ӱ�������
			return ps.executeUpdate();
		}catch (SQLException e) {
			//6�������׳��쳣
			throw e;
		}finally{
			//7��ǧǧ����Ҫ�ر����ݿ�����
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
	 * �ر���Դ
	 * @param conn ���ݿ�����
	 * @param ps   ������
	 * @param rs   �����
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
