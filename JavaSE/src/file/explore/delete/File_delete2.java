package file.explore.delete;

import java.io.File;

public class File_delete2 {
	public static void main(String[] args) {
		File dir=new File("demo");
		boolean result=deleteFiles(dir,true);
		if (result) {
			System.out.println("删除成功");
		} else {
			System.out.println("文件不存在或删除失败");
		}
	}
	/**
	 * 
	 * @param dir 目录名
	 * @param ifDeleteDir 是否删除目录本身
	 * @return
	 */
	public static boolean deleteFiles(File dir,boolean ifDeleteDir) {
		if(null==dir||!dir.isDirectory()) {
			return false;
		}
		boolean result=false;
		File[] subs=dir.listFiles();
		for(File sub:subs){
			if(sub.isDirectory()&&null!=sub.listFiles()){
				result=deleteFiles(sub,ifDeleteDir);
			}else {
				result=sub.delete();
			}
		}
		if(ifDeleteDir) {
			dir.delete();
		}
		return result;
	}
	/**
	 * 删除文件，广度优先
	 * @param file
	 * @return
	 */
	public static boolean deleteFile(File file){
		File[] subs=file.listFiles();
		for(File sub:subs){
			if(sub.isDirectory()&&sub.listFiles()!=null){
				deleteFile(sub);
			}else{
				sub.delete();
			}
		}
		file.delete();
		return true;
	}
	/**
	 * 删除文件，深度优先
	 * @param file
	 * @return
	 */
	public static boolean deleteFile2(File file){
		if(file.isDirectory()){
			File[] subs=file.listFiles();
			for(File sub:subs){
				deleteFile(sub);
			}
		}
		file.delete();
		return true;
	}
}
