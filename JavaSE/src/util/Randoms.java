package util;

import java.util.Random;

public class Randoms {
	/**
	 * 用于随机产生int数组内容的方法
	 * @param n 数组元素个数
	 * @param max 数组随机的最大值
	 * @return 返回该数组
	 */
	public static int[] randomArray(int n,int max) {
		Random rand=new Random();
		int[] arr=new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=rand.nextInt(max);
		}
		return arr;
	}
}
