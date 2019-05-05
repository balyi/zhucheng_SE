package explore.mkdir;

import java.io.File;
import java.io.IOException;
/**
 * 创建新文件
 * @author Administrator
 *
 */
public class File_createNewFile {

	public static void main(String[] args) throws IOException {
		File file=new File("text.txt");
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("文件创建成功");
		} else {
			System.out.println("文件已存在");

		}
	}

}
