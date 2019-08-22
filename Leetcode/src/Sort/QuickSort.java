package Sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 8, 34, 64, 51, 33, 22, 44, 55, 88, 1, 0, 2, 2 };
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr,int low,int high) {
		if(low>high){
			return;
		}
		int i = low,j= high;
		System.out.println(i+" "+j);
		int tmp = arr[low];
		while(i!=j) {
			while(i<j&&arr[j]>=tmp) {//从右边找到一个比tmp小的
				j--;
			}
			while(i<j&&arr[i]<=tmp) {//从左边找到一个比tmp大的
				i++;
			}
			if (i<j) {//交换这两个元素(如果是i==j表明除了tmp之外是有序的)
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		arr[low] = arr[i];
		arr[i] = tmp;//i左边都比他小，右边都比他大
		quickSort(arr, low, i-1);//递归对左右也快排
		quickSort(arr, i+1, high);
	}
}
