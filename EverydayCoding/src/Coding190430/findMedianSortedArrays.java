package Coding190430;

import java.util.Arrays;

/**
 * @author josonlee
 * Topic4：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空
 * 
 * 最初想到的是移动下标比较两个数组数据，时间复杂度O((n+m)/2)
 */
public class findMedianSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num1 = {};
		int[] num2 = {4,5,6,7};
		System.out.println(solution(num1, num2));
	}
	
	public static double solution(int[] num1,int[] num2) {
		int len = num1.length+num2.length;
		int[] num = new int[len];
		int tmp = 0;
		int i=0,j=0;
		boolean flag = len%2==0? true:false;//标记是偶还是奇
		while(i<num1.length && j<num2.length) {
			num[tmp] = num1[i]<num2[j]?num1[i++]:num2[j++];
			if(flag) {
				if(tmp==len/2)
					return (num[tmp]+num[tmp-1])/2.0;
			}else {
				if(tmp==len/2) {
					return num[tmp];
				}
			}
			tmp++;
		}
		while(i<num1.length) {
			num[tmp] = num1[i++];
			if(flag) {
				if(tmp==len/2)
					return (num[tmp]+num[tmp-1])/2.0;
			}else {
				if(tmp==len/2)
					return num[tmp];
			}
			tmp++;
		}
		while(j<num2.length) {
			num[tmp] = num2[j++];
			if(flag) {
				if(tmp==len/2)
					return (num[tmp]+num[tmp-1])/2.0;
			}else {
				if(tmp==len/2) {
					System.out.println(Arrays.toString(num));
					return num[tmp];
				}
			}
			tmp++;
		}
		return 0.0;
	}
}
