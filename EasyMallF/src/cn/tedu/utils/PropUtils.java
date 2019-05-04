package cn.tedu.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtils{
	//����Properties�����
	private static Properties prop = new Properties();
	//�����췽��˽�л�������ģʽ��
	private PropUtils(){}
	static{
		//��ȡ���ļ�������·�����ƣ�·��+�ļ�����+��׺���ƣ�
		String path = PropUtils.class.getClassLoader().
				getResource("conf.properties").getPath();
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
