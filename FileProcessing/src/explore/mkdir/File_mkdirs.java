package explore.mkdir;

import java.io.File;
/**
 * 创建多级目录
 * @author Administrator
 *
 */
public class File_mkdirs {
	public static void main(String[] args) {
		File dirs=new File("a/b/c");
		if(!dirs.exists()){
			dirs.mkdirs();
			System.out.println("创建成功");
		}else{
			System.out.println("文件已存在");
		}
	}
}
