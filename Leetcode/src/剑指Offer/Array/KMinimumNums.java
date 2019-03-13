package 剑指Offer.Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author josonlee
 * @title 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 * 
 * 直接用PriorityQueue构建最小堆，限制容量为k，插入即可
 */
public class KMinimumNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,5,1,6,2,7,3,8};
		System.out.println(GetLeastNumbers_Solution(arr, 8));
	}
	public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        //插入排序？O(kn)
        int min = 0;
        int tmp ;
        int len = input.length;
        ArrayList<Integer> arr =  new ArrayList<Integer>(k);
        if(k>input.length||k<=0)
        	return arr;
        for(int i=0;i<k;i++){
            tmp = input[i];
            min = i;
            for(int j=i+1;j<len;j++){
                if(tmp>input[j]){
                    min = j;
                    tmp = input[j];
                }
            }
            input[min] = input[i];
            input[i] = tmp;
            System.out.println(Arrays.toString(input));
            arr.add(input[i]);
        }
        return arr;
    }
}
