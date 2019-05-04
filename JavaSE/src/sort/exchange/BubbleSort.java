package sort.exchange;

import java.util.Arrays;

import util.Randoms;
/**
 * √∞≈›≈≈–Ú
 * @author Administrator
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr=Randoms.randomArray(8, 100);
		System.out.println("≈≈–Ú«∞£∫"+Arrays.toString(arr));
		BubbleSort1(arr);
		System.out.println("≈≈–Ú∫Û£∫"+Arrays.toString(arr));
	}
	public static void BubbleSort1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j <arr.length-i; j++) {
				if(arr[j-1]>arr[j]) {
					int temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
			}
		}
	}
}
