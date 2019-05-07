package test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MyTest {
	public static void main(String[] args) {
		Map< String, Integer> map2=new HashMap<String,Integer>();
		map2.put("asd", 1);
		Integer a=map2.get("asd");
		System.out.println(a);
		
		Map<String,Integer> map= new HashMap<String,Integer>();
	map.put("语文", 99);
	map.put("数学", 98);
	map.put("英语", 97);
	map.put("物理", 96);
	map.put("化学", 95);
	//获取物理的成绩
	Integer num = map.get("物理");
	System.out.println("物理:"+num);
	
	//设置化学成绩
	map.put("化学",96);
	
	//删除英语
	map.remove("英语");
	
	//遍历key
	Set<String> keySet = map.keySet();
	for(String key : keySet){
		System.out.println("key:"+key);
	}
	
	//遍历Entry
	Set<Entry<String,Integer>> entrySet = map.entrySet();
	for(Entry<String,Integer> e : entrySet){
		System.out.println(e.getKey()+":"+e.getValue());
	}
	
	//遍历values
	Collection<Integer> values = map.values();
	for(Integer value : values){
		System.out.println("value:"+value);
	}
	}
}
