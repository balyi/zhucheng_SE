package cn.tedu.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropPayUtils{
	//创建Properties类对象
	private static Properties prop = new Properties();
	//将构造方法私有化（单利模式）
	private PropPayUtils(){}
	static{
		//获取该文件的完整路径名称（路径+文件名称+后缀名称）
		String path = PropPayUtils.class.getClassLoader().
				getResource("merchantInfo.properties").getPath();
		try {
			prop.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Properties getProp(){
		return prop;
	}
	public static String getProperty(String key){
		return prop.getProperty(key);
	}
}
