package Leetcode.Other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author josonlee
 * 3 Sum，找出数组中所有满足三数之和为0的非重复三元组
 */
public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-1,0,1,2,1,-1,-3};
		ArrayList<ArrayList<Integer>> aList = solution(arr);
		for (ArrayList<Integer> list : aList) {
			System.out.println(list.toString());
		}
		System.out.println("*****************");
		ArrayList<ArrayList<Integer>> aList2 = solution2(arr);
		for (ArrayList<Integer> list : aList2) {
			System.out.println(list.toString());
		}
	}

	public static ArrayList<ArrayList<Integer>> solution(int[] arr) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		if(arr==null||arr.length<3)
			return arrayList;
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			if(i+1<arr.length&&arr[i]==arr[i+1])
				continue;//跳过重复
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int j=i+1;j<arr.length;j++) {
				int c = -(arr[i]+arr[j]);
				if(map.containsKey(c)) {
					arrayList.add(new ArrayList<Integer>(Arrays.asList(arr[i],arr[j],c)));
				}
				map.put(arr[j], j);
				while(j+1<arr.length&&arr[j]==arr[j+1])
					j++;
			}
		}
		return arrayList;
	}
	//双指针移动
	public static ArrayList<ArrayList<Integer>> solution2(int[] arr) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		if(arr==null||arr.length==0)
			return arrayList;
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			int L = i+1, R = arr.length-1;
			while(L<arr.length&&arr[L]==arr[i]) {
				i++;
				L = i+1;
			}
			while(L<R) {
				if(arr[i]+arr[L]+arr[R]<0) {
					L++;
				}else if (arr[i]+arr[L]+arr[R]>0) {
					R--;
				}else {
					arrayList.add(new ArrayList<Integer>(Arrays.asList(arr[i],arr[L],arr[R])));
					while(L+1<R&&arr[L]==arr[L+1]) L++;
					while(L<R-1&&arr[R]==arr[R-1]) R--;
					L++;
					R--;
				}
			}
		}
		return arrayList;
	}
}
