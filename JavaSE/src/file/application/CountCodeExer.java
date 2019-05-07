package file.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * 计算Java代码�?
 * @author Administrator
 *
 */
public class CountCodeExer {
	static int count=0;

	public static void main(String[] args) throws Exception{
		File dir=new File(".");
		count(dir);
		System.out.println(count);
	}
	private static void count(File file) throws IOException{
		if(file==null){
			throw new NullPointerException();
		}
		if(file.isDirectory()){
			File[] fs=file.listFiles();
			for(File f:fs){
				count(f);
			}
		}else if(file.getName().endsWith(".java")){
			BufferedReader br=new BufferedReader(new FileReader(file));
			while(br.readLine()!=null){
				count++;
			}
		}
	}
}
