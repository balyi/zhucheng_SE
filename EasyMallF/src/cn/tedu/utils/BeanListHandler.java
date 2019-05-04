package cn.tedu.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*List<User> list =query(sql,
new BeanListHandler<User>(User.clas));
*/
public class BeanListHandler<T> 
	implements ResultSetHandler<List<T>> {
	private Class<T> clz;
	public BeanListHandler(Class<T> clz){
		this.clz = clz;
	}
	public List<T> handle(ResultSet rs) throws SQLException {
		List<T> list = new ArrayList<T>();
		try {
			while(rs.next()){
				//创建对象
				T t = clz.newInstance();
				BeanInfo bi = Introspector.getBeanInfo(clz);
				PropertyDescriptor[] pds = bi.getPropertyDescriptors();
				for(int i =0;i<pds.length;i++){
					PropertyDescriptor pd = pds[i];
					//获取属性名称
					String name = pd.getName();
					//获取set方法
					Method md = pd.getWriteMethod();
					try{
						Object obj = null;
						if(pd.getPropertyType()==int.class){
							obj = rs.getInt(name);
						}else{
							obj = rs.getObject(name);
						}
						md.invoke(t,obj);
					}catch (SQLException e) {
						continue;
					}
				}
				//添加到集合中
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}

}
