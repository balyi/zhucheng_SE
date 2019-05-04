package util;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		A a=new A();
		Integer i=null;
		a.setA(i);
		System.out.println(a.getA());
		Date date=new Date();
		System.out.println(date);
	}
}
class A{
	private Integer a;

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}
	
}
