package test;

import java.util.Random;

public class MyTest3 {
	public static void main(String[] args) {
		String a="";
		StringBuilder sb=new StringBuilder(a);
		Random rand=new Random();
		for(int i=0;i<566;i++) {
			int b=rand.nextInt(2);
			if(b==1)
				b=2;
			String c=String.valueOf(b);
			sb.append(c).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
