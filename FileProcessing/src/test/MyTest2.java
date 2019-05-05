package test;

public class MyTest2 {
	public static void main(String[] args) {
		String a1="asd";
		String a2="3we";
		String a3="abc";
		String regex="[bc0-9]+.*";
		boolean b1=a1.matches(regex);
		boolean b2=a2.matches(regex);
		boolean b3=a3.matches(regex);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
	}
}
