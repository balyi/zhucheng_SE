package edu.taihu.logistics.tool;

public class StringUtils {
	public static String addsub(String add) {
		int index=add.indexOf("-", add.indexOf("-")+1);
		add=add.substring(0, index);
		return add;
	}
}
