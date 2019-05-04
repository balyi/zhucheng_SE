package edu.taihu.logistics.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTool {
	
	public static String getTime(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	public static String getTimeStamp(){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}
}	
