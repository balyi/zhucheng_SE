package sort.insert;

import java.util.Arrays;

import util.Randoms;
/**
 * 直接插入排序
 * @author Administrator
 *
 */
public class InsertionSort {
	public static void main(String[] args) {
		int[] arr=Randoms.randomArray(8, 100);
		System.out.println("排序前："+Arrays.toString(arr));
		insertionSort1(arr);
		System.out.println("排序后："+Arrays.toString(arr));
	}
	public static void insertionSort1(int[] arr) {
		int i,j,target;
		for (i = 1; i < arr.length; i++) {
			j=i;
			target=arr[i];
			while(j>0&&target<arr[j-1]) {
				arr[j]=arr[j-1];
				j--;
			}
			arr[j]=target;
		}
	}
}
