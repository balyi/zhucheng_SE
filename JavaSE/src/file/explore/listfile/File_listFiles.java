package file.explore.listfile;

import java.io.File;

public class File_listFiles {
	public static void main(String[] args) {
		File dir=new File("D:/Git");
		System.out.println(dir.getAbsolutePath());
		if(dir.isDirectory()){
			File[] subs=dir.listFiles();
			for(File sub:subs){
				System.out.print(sub.getName());
				if(sub.isFile()){
					System.out.println("是文件");
				}
				if(sub.isDirectory()){
					System.out.println("是目录");
				}
			}
		}
	}
}
