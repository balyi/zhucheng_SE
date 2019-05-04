package edu.taihu.logistics.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Utils {
	public static String getMd5(String password,String salt) {
 
		//source 加密源
		//salt 盐
		//hashIterations 和稀泥的次数
		Md5Hash mh = new Md5Hash(password, salt, 2);
		System.out.println(mh);
		return mh.toString();
	}
	public static void main(String[] args) {
		Md5Hash mh = new Md5Hash("root", "taihu", 2);
		System.out.println(mh);
	}
}
