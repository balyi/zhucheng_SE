package sort;

import java.util.Arrays;

import util.Randoms;

/**
 * �鲢����
 * @author Administrator
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr=Randoms.randomArray(8, 100);
		System.out.println("����ǰ��"+Arrays.toString(arr));
		mergeSort(arr, 0, arr.length-1);
		System.out.println("�����"+Arrays.toString(arr));
	}
    public static int[] mergeSort(int[] arr, int low, int high) {  
        int mid = (low + high) / 2;  
        if (low < high) {  
            // ���  
            mergeSort(arr, low, mid);  
            // �ұ�  
            mergeSort(arr, mid + 1, high);  
            // ���ҹ鲢  
            merge(arr, low, mid, high);  
        }  
        return arr;  
    }  
  
    public static void merge(int[] arr, int low, int mid, int high) {  
        int[] temp = new int[high - low + 1];  
        int i = low;// ��ָ��  
        int j = mid + 1;// ��ָ��  
        int k = 0;  
  
        // �ѽ�С�������Ƶ���������  
        while (i <= mid && j <= high) {  
            if (arr[i] < arr[j]) {  
                temp[k++] = arr[i++];  
            } else {  
                temp[k++] = arr[j++];  
            }  
        }  
  
        // �����ʣ�������������  
        while (i <= mid) {  
            temp[k++] = arr[i++];  
        }  
  
        // ���ұ߱�ʣ�������������  
        while (j <= high) {  
            temp[k++] = arr[j++];  
        }  
  
        // ���������е�������arr����  
        for (int k2 = 0; k2 < temp.length; k2++) {  
            arr[k2 + low] = temp[k2];  
        }  
    }  
}
