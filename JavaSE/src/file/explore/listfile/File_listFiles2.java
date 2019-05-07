package file.explore.listfile;

import java.io.File;
import java.io.FileFilter;

public class File_listFiles2 {
	public static void main(String[] args) {
		File dir=new File(".");
		FileFilter filter=new FileFilter() {
			public boolean accept(File pathname) {
				String str=pathname.getName();
				return str.endsWith(".txt");
			}
		};
		File[] subs=dir.listFiles(filter);
		for(File sub:subs){
			System.out.println(sub.getName());
		}
	}
}
