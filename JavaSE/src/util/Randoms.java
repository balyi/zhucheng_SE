package util;

import java.util.Random;

public class Randoms {
	/**
	 * �����������int�������ݵķ���
	 * @param n ����Ԫ�ظ���
	 * @param max ������������ֵ
	 * @return ���ظ�����
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
