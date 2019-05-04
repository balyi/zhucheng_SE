package sort.exchange;

import java.util.Arrays;

import util.Randoms;

/**
 * 快速排序
 * @author Administrator
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr=Randoms.randomArray(8, 100);
		System.out.println("排序前："+Arrays.toString(arr));
		quickSort(arr, 0, arr.length-1);
		System.out.println("排序后："+Arrays.toString(arr));
	}
	public static void quickSort(int[] arr,int low,int high){
		int start=low;
		int end=high;
		int key=arr[low];
		while(end>start){//在两个指针相遇之前
			//从后往前比较
			while(end>start&&arr[end]>=key)
				//如果不比关键值小，比较下一个
				end--;
				if(arr[end]<=key){//如果比关键值小，调换位置，使之在关键值左边
					int temp=arr[end];
					arr[end]=arr[start];
					arr[start]=temp;
				}
			
			//从前往后比较
			while(end>start&&arr[start]<=key)
				//如果不比关键值大，比较下一个
				start++;
				if(arr[start]>=key){//如果比关键值大，调换位置，使之在关键值右边
					int temp=arr[end];
					arr[end]=arr[start];
					arr[start]=temp;
				}
			//递归
			if(start>low)
				quickSort(arr, low, start-1);
			if(end<high)
				quickSort(arr, end+1, high);
		}
	}
}
