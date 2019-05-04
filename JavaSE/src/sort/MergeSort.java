package sort;

import java.util.Arrays;

import util.Randoms;

/**
 * 归并排序
 * @author Administrator
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr=Randoms.randomArray(8, 100);
		System.out.println("排序前："+Arrays.toString(arr));
		mergeSort(arr, 0, arr.length-1);
		System.out.println("排序后："+Arrays.toString(arr));
	}
    public static int[] mergeSort(int[] arr, int low, int high) {  
        int mid = (low + high) / 2;  
        if (low < high) {  
            // 左边  
            mergeSort(arr, low, mid);  
            // 右边  
            mergeSort(arr, mid + 1, high);  
            // 左右归并  
            merge(arr, low, mid, high);  
        }  
        return arr;  
    }  
  
    public static void merge(int[] arr, int low, int mid, int high) {  
        int[] temp = new int[high - low + 1];  
        int i = low;// 左指针  
        int j = mid + 1;// 右指针  
        int k = 0;  
  
        // 把较小的数先移到新数组中  
        while (i <= mid && j <= high) {  
            if (arr[i] < arr[j]) {  
                temp[k++] = arr[i++];  
            } else {  
                temp[k++] = arr[j++];  
            }  
        }  
  
        // 把左边剩余的数移入数组  
        while (i <= mid) {  
            temp[k++] = arr[i++];  
        }  
  
        // 把右边边剩余的数移入数组  
        while (j <= high) {  
            temp[k++] = arr[j++];  
        }  
  
        // 把新数组中的数覆盖arr数组  
        for (int k2 = 0; k2 < temp.length; k2++) {  
            arr[k2 + low] = temp[k2];  
        }  
    }  
}
