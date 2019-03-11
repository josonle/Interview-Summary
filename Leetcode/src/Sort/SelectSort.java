package Sort;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 8, 34,64, 51, 33, 22, 44, 55, 88, 1, 0, 2, 2 };
		selection(arr);
	}
	/**
	 * 每次扫描未排序序列选最小（大）和未排序序列头交换，最终构成有序序列
	 * @param arr
	 */
	public static void selection(int[] arr) {
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length-1; i++) {
			int min = i;//最小值下标
			int tmp = arr[i];//最小值
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]<tmp) {
					min = j;
					tmp = arr[j];
				}
			}
			arr[min] = arr[i];
			arr[i] = tmp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
