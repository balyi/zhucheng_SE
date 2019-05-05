package explore.delete;

import java.io.File;

public class File_delete {

	public static void main(String[] args) {
		File file=new File("text.txt");
		if(file.exists()){
			file.delete();
			System.out.println("删除成功");
		}else{
			System.out.println("文件不存在");
		}
	}

}
