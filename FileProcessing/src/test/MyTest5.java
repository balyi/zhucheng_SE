package test;

public class MyTest5 {
	public static void main(String[] args) {
//		String pattern = "([-+*/^()\\]\\[])";
//		String test = "1237019830+32[89-234]234";
		String pattern = "([\\w-+*/^()\\]\\[])";
		String test = "京白梨-275g，库尔勒梨-35g，麦饭石啤酒-100g；花卷-75g，芹菜叶汤-150g；米饭（蒸）-50g，苦苦菜-200g，胡萝卜（黄）-150g；";
		System.out.println("原字符串="+test);
		test = test.replaceAll(pattern, "");
		System.out.println("匹配后字符串="+test);
	}
}
