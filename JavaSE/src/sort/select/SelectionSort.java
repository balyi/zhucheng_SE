package sort.select;

import java.util.Arrays;

import util.Randoms;
/**
 * ѡ������
 * @author Administrator
 *
 */
public class SelectionSort {
	public static void main(String[] args) {
		int[] arr=Randoms.randomArray(8, 100);
		System.out.println("����ǰ��"+Arrays.toString(arr));
		selectionSort(arr);
		System.out.println("�����"+Arrays.toString(arr));
	}
	public static void selectionSort(int[] arr){
		for(int i = 0; i < arr.length - 1; i++) {// ����i������
			int k = i;
			for(int j = k + 1; j < arr.length; j++){// ѡ��С�ļ�¼
				if(arr[j] < arr[k]){ 
					k = j; //����Ŀǰ�ҵ�����Сֵ���ڵ�λ��
				}
			}
			//���ڲ�ѭ��������Ҳ�����ҵ�����ѭ������С�����Ժ��ٽ��н���
			if(i != k){  //����a[i]��a[k]
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
			}    
		}
	}
}
