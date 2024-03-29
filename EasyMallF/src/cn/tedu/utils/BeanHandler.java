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
			//A1、声明对象
			T t = null;
			//A3、判断rs中是否有数据
			if(rs.next()){//有数据
				//A4创建对象
				t = clz.newInstance();
				//A5、为t对象属性赋值（值来至于rs）
				//t.setXxx(rs.getObject("属性的名称"));
				//A5.1、获取clz对应的BeanInfo对象
				BeanInfo bi = Introspector.getBeanInfo(clz);
				//A5.2、获取clz对应类的所有的属性方
				//法对应的PropertyDescriptor数组
				PropertyDescriptor[] pds = 
						bi.getPropertyDescriptors();
				//A5.3、遍历数组，为t的每一个属性赋值
				for(int i = 0;i<pds.length;i++){
					PropertyDescriptor pd = pds[i];
					//A5.4获取属性的名称eg："username"
					String name = pd.getName();
					//A5.5获取属性对应的setXxx()方法
					Method setMd = pd.getWriteMethod();
					//A5.6执行set方法
					//username(User类属性名)-username(user表中字段名)
					try{
						setMd.invoke(t, rs.getObject(name));
					}catch (SQLException e) {
						continue;
					}
				}
			}
			//A2、返回对象
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
