package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * 计算Java代码量
 * @author Administrator
 *
 */
public class CountCodeExer2 {
	static int count=0;
	public static void main(String[] args) throws Exception{
		File dir=new File(".");
		count(dir);
		System.out.println(count);
	}
	public static void count(File file) throws IOException{
		if(file==null){
			throw new NullPointerException();
		}
		if(file.isDirectory()){
			File[] files=file.listFiles();
			for(File f:files){
				count(f);
			}
 		}else if(file.getName().endsWith(".java")){
 			BufferedReader br=new BufferedReader(new FileReader(file));
 			while(br.readLine()!=null){
 				count++;
 			}
 			br.close();
 		}
	}
}
