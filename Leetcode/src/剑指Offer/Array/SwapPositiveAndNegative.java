package 剑指Offer.Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author josonlee
 * @title 有一个整形数组，包含正数和负数，然后 要求把数组内的所有负数移至正数的左边，且保证相对位置不变， 要求时间复杂度为O(n),
 *        空间复杂度为O(1)。 例如，{10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35}变化后是{-2,
 *        -4，-3, -88, -23,5, 8 ,10, 2, 7, 12, 35}
 *        
 * 不考虑0,思路来源于快排算法
 */
public class SwapPositiveAndNegative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35 };
		swapArray(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void swapArray(int[] arr) {
		int i = 0, j = arr.length - 1;
		ArrayList<Integer> aList = new ArrayList<Integer>();
		while (i <= j) {
			while (arr[i] < 0 && i < j)// i<j可以避免多遍历几个数据
				i++;
			while (arr[j] >= 0 && i < j) {
				if(arr[j]==0)
					aList.add(j);
				j--;
			}
			if (i == j) {
				return;
			}
			if (i != j) {// 交换正负数
				swap(arr, i, j);
			}
		}
	}
	public static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
