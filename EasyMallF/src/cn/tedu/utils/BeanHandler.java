package cn.tedu.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BeanHandler<T> implements ResultSetHandler<T> {
	private Class<T> clz;
	public BeanHandler(Class<T> clz){
		this.clz = clz;
	}
	//rs->T t
	public T handle(ResultSet rs) throws SQLException {
		try {
			//A1����������
			T t = null;
			//A3���ж�rs���Ƿ�������
			if(rs.next()){//������
				//A4��������
				t = clz.newInstance();
				//A5��Ϊt�������Ը�ֵ��ֵ������rs��
				//t.setXxx(rs.getObject("���Ե�����"));
				//A5.1����ȡclz��Ӧ��BeanInfo����
				BeanInfo bi = Introspector.getBeanInfo(clz);
				//A5.2����ȡclz��Ӧ������е����Է�
				//����Ӧ��PropertyDescriptor����
				PropertyDescriptor[] pds = 
						bi.getPropertyDescriptors();
				//A5.3���������飬Ϊt��ÿһ�����Ը�ֵ
				for(int i = 0;i<pds.length;i++){
					PropertyDescriptor pd = pds[i];
					//A5.4��ȡ���Ե�����eg��"username"
					String name = pd.getName();
					//A5.5��ȡ���Զ�Ӧ��setXxx()����
					Method setMd = pd.getWriteMethod();
					//A5.6ִ��set����
					//username(User��������)-username(user�����ֶ���)
					try{
						setMd.invoke(t, rs.getObject(name));
					}catch (SQLException e) {
						continue;
					}
				}
			}
			//A2�����ض���
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
