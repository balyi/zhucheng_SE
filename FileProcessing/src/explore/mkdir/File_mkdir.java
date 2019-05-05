package explore.mkdir;

import java.io.File;
/**
 * 创建单个文件或文件夹
 * @author Administrator
 *
 */
public class File_mkdir {
	public static void main(String[] args) {
		File dir=new File("demo");
		System.out.println("文件的完整路径为"+dir.getAbsolutePath());
		if(!dir.exists()){
			dir.mkdir();
			System.out.println("创建成功");
		}else{
			System.out.println("文件已存在");
		}
	}
}
