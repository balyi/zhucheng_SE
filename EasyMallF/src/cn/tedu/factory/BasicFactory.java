package cn.tedu.factory;

import java.util.List;

import cn.tedu.utils.PropUtils;

public class BasicFactory {
	private BasicFactory(){}
	public static BasicFactory getFactory(){
		return new BasicFactory();
	}
	//T->UserDao.class
	public <T> T getInstance(Class<T> intfClz){
		//UserDao.class
		//"UserDao"
		String intfName = PropUtils.getProperty(
				intfClz.getSimpleName());
		try {
			Class clz = Class.forName(intfName);
			return (T)clz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
