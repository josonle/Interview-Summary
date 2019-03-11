package Sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {8, 34,64, 51, 33, 22, 44, 55, 88, 1, 0, 2, 2};
		bubble(arr);
		bubbleFast(arr);
	}
	/**
	 * 冒泡是每次遍历一趟两两交换最小（大）值，把最大值放在最后面
	 * 两层循环，外层i=length次，内层length-i-1次
	 * @param arr
	 */
	public static void bubble(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("*************************");
	}
	/**
	 * 优化版的冒泡，优化点在于后期可能已经排好序了，但还是在遍历
	 * 所以应该设置一个标志位，如果一次遍历没有交换（已排好序）就跳出遍历
	 * @param arr
	 */
	public static void bubbleFast(int[] arr) {
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					flag = false;
				}
			}
			if(flag)//flag为true表示未交换已经有序，跳出
				break;
		}
		System.out.println(Arrays.toString(arr));
	}
}
