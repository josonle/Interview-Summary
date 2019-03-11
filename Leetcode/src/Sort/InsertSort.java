package Sort;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 8, 34,64, 51, 33, 22, 44, 55, 88, 1, 0, 2, 2 };
		insert(arr);
	}

	public static void insert(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			int j = i+1;
			int tmp = arr[j];
			while (j>0&&tmp<arr[j-1]) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = tmp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
