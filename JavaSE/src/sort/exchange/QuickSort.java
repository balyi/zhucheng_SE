package sort.exchange;

import java.util.Arrays;

import util.Randoms;

/**
 * ��������
 * @author Administrator
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr=Randoms.randomArray(8, 100);
		System.out.println("����ǰ��"+Arrays.toString(arr));
		quickSort(arr, 0, arr.length-1);
		System.out.println("�����"+Arrays.toString(arr));
	}
	public static void quickSort(int[] arr,int low,int high){
		int start=low;
		int end=high;
		int key=arr[low];
		while(end>start){//������ָ������֮ǰ
			//�Ӻ���ǰ�Ƚ�
			while(end>start&&arr[end]>=key)
				//������ȹؼ�ֵС���Ƚ���һ��
				end--;
				if(arr[end]<=key){//����ȹؼ�ֵС������λ�ã�ʹ֮�ڹؼ�ֵ���
					int temp=arr[end];
					arr[end]=arr[start];
					arr[start]=temp;
				}
			
			//��ǰ����Ƚ�
			while(end>start&&arr[start]<=key)
				//������ȹؼ�ֵ�󣬱Ƚ���һ��
				start++;
				if(arr[start]>=key){//����ȹؼ�ֵ�󣬵���λ�ã�ʹ֮�ڹؼ�ֵ�ұ�
					int temp=arr[end];
					arr[end]=arr[start];
					arr[start]=temp;
				}
			//�ݹ�
			if(start>low)
				quickSort(arr, low, start-1);
			if(end<high)
				quickSort(arr, end+1, high);
		}
	}
}
