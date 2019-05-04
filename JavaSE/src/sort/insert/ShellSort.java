package sort.insert;

import java.util.Arrays;

import util.Randoms;
/**
 * ϣ�����򣨲�������
 * @author Administrator
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] arr=Randoms.randomArray(8, 100);
		System.out.println("����ǰ��"+Arrays.toString(arr));
		shellSort(arr);
		System.out.println("�����"+Arrays.toString(arr));
	}
	public static void shellSort(int[] arr){
		int j = 0;
        int temp = 0;
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            System.out.println("increment:" + increment);
            //increment��i��j֮��Ŀ��
            for (int i = increment; i < arr.length; i++) {
                // System.out.println("i:" + i);
                temp = arr[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    // System.out.println("j:" + j);
                    // System.out.println("temp:" + temp);
                    // System.out.println("arr[" + j + "]:" + arr[j]);
                    if (temp < arr[j]) {
                        arr[j + increment] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + increment] = temp;
            }
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
	}
}
