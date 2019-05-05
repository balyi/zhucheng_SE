package application;

import java.io.File;
import java.util.Set;
import java.util.Map.Entry;

public class DeleteDuplication {
	public static void main(String[] args) {
		String path = "F:/new";
		File dir = new File(path);
		if (dir.isDirectory() && null != dir) {
			File[] subs = dir.listFiles();
			int count=0;
			for (File sub : subs) {
				String fullName = sub.getName();
				String[] split = fullName.split("\\.");
				String fileName=split[0];
				//判断是否重复图片
				boolean ifDuplicate=fileName.matches("^.*\\(\\d+\\).*$");
				if(ifDuplicate) {
					sub.delete();
					count++;
				}
			}
			System.out.println("一共删除"+count+"个重复文件");
		}
	}
}
