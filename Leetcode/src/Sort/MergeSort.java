package Sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 8, 34, 64, 51, 33, 22, 44, 55, 88, 1, 0, 2, 2 };
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			sort(arr, low, mid);// 左边递归排序
			sort(arr, mid + 1, high);// 右边递归排序
			merge(arr, low, mid, high);// 左右归并
		}
//		System.out.println(Arrays.toString(arr));
	}

	public static void merge(int[] arr, int low, int mid, int high) {
		int i = low, j = mid + 1;
		int k = 0;
		int[] tmp = new int[high - low + 1];

		while (i <= mid && j <= high) { 
			tmp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
		}
		System.out.println("tmp1 :" + Arrays.toString(tmp));
		while (j <= high) {// 右边数组有剩余
			tmp[k++] = arr[j++];
		}
		while (i <= mid) {// 左边数组有剩余
			tmp[k++] = arr[i++];
		}
		System.out.println("tmp2 :" + Arrays.toString(tmp));
//		for (int l = 0; l < tmp.length; l++) {// 重新赋值
//			arr[l + low] = tmp[l];
//		}
		System.arraycopy(tmp, 0, arr, low,tmp.length);//这也是复制，效率更高，其次是Arrays.copyOf（浅复制）。for循环效率最低
	}
}
