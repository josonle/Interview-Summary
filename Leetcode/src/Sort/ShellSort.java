package Sort;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 8, 34, 64, 51, 33, 22, 44, 55, 88, 1, 0, 2, 2 };
		shellMove(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * shell排序：一种优化的插入排序
	 * 
	 * @param arr
	 */
	public static void shell(int[] arr) {
		int gap = arr.length / 2;
		for (; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				while (j - gap >= 0) {
					if (arr[j] < arr[j - gap]) {// 交换二者，也可以只是把arr[j-gap]后移gap位置,最后再把arr[i]赋给前面
						int tmp = arr[j];
						arr[j] = arr[j - gap];
						arr[j - gap] = tmp;
					}
					j -= gap;
				}
			}
		}
	}

	public static void shellMove(int[] arr) {
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int tmp = arr[j];
				while (j - gap >= 0&&tmp < arr[j - gap]) {
//					if (tmp < arr[j - gap]) {
//						arr[j] = arr[j - gap];
//					} else {
//						break;
//					}
					arr[j] = arr[j-gap];
					j -= gap;
				}
				arr[j] = tmp;
			}
			System.out.println(Arrays.toString(arr));
		}
	}
}
