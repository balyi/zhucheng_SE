package sort.select;

import java.util.Arrays;

import util.Randoms;
/**
 * ∂—≈≈–Ú
 * @author Administrator
 *
 */
public class HeapSort {
	public static void main(String[] args) {
		int[] arr=Randoms.randomArray(8, 100);
		System.out.println("≈≈–Ú«∞£∫"+Arrays.toString(arr));
		heapSort(arr);
		System.out.println("≈≈–Ú∫Û£∫"+Arrays.toString(arr));
	}
	public static void heapSort(int[] arr) {  
		if (arr == null || arr.length <= 1) {  
			return;  
		}  

		buildMaxHeap(arr);  

		for (int i = arr.length - 1; i >= 1; i--) {  
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			maxHeap(arr, i, 0);  
		}  
	}  

	private static void buildMaxHeap(int[] arr) {  
		if (arr == null || arr.length <= 1) {  
			return;  
		}  

		int half = arr.length / 2;  
		for (int i = half; i >= 0; i--) {  
			maxHeap(arr, arr.length, i);  
		}  
	}  

	private static void maxHeap(int[] arr, int heapSize, int index) {  
		int left = index * 2 + 1;  
		int right = index * 2 + 2;  

		int largest = index;  
		if (left < heapSize && arr[left] > arr[index]) {  
			largest = left;  
		}  

		if (right < heapSize && arr[right] > arr[largest]) {  
			largest = right;  
		}  

		if (index != largest) {  
			int temp = arr[index];
			arr[index] = arr[largest];
			arr[largest] = temp;
			maxHeap(arr, heapSize, largest);  
		}  
	} 
}
