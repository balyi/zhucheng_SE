package application;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class ExtractPicture {
	public static void main(String[] args) {
		String path = "F:/new";
		File dir = new File(path);
		System.out.println(dir.getAbsolutePath());
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (dir.isDirectory() && null != dir) {
			File[] subs = dir.listFiles();
			for (File sub : subs) {
				String fullName = sub.getName();
				System.out.println(fullName);
				String[] split = fullName.split("\\.");
				String fileName=split[0];
				//判断是否为组图
				boolean ifGroup=fileName.matches("^.*p.*$");
				if(ifGroup) {
					String[] split2 = split[0].split("_p");
					// 获取图片编号
					String picture = split2[0];
					// 获取图片下标
					Integer num = Integer.parseInt(split2[1]);
					if (num > 0) {
						// 获取已存入的该组图片下标
						Integer numOdd = map.get(picture);
						if (null == numOdd)
							numOdd = 0;
						if (numOdd < num)
							numOdd = num;
						map.put(picture, num);
					}
				}
			}
			Set<Entry<String, Integer>> entrySet = map.entrySet();
			for (Entry<String, Integer> e : entrySet) {
				String dirName = e.getKey() + "_" + (e.getValue() + 1);
				File picDir = new File(path + "/" + dirName);
				picDir.mkdir();
			}
			for (File sub : subs) {
				String fullName = sub.getName();
				String[] split = fullName.split("\\.");
				String[] split2 = split[0].split("_p");
				// 获取图片编号
				String picture = split2[0];
				Integer num=map.get(picture);
				if(null!=num) {
					String dirName=picture+"_"+(num+1);
					sub.renameTo(new File(path + "/" +dirName,sub.getName()));
				}
			}
		}
	}
}
