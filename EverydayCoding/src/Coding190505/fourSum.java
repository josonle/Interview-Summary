package Coding190505;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author josonlee
 * Topic18：https://leetcode-cn.com/problems/4sum/
 * 四数之和为target，答案中不可以包含重复的四元组
 */
public class fourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 0, -1, 0, -2, 2};
		int[] num = {-1,0,1,2,-1,-4};
		List<List<Integer>> list = solution(num, -1);
		for (List<Integer> list2 : list) {
			System.out.println(Arrays.toString(list2.toArray()));
		}
	}

	public static List<List<Integer>> solution(int[] nums,int target){
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<>();
		for(int i=0;i<nums.length-3;i++) {
			if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target) break;
			if(i>0&&nums[i]==nums[i-1]) continue;
			
			for(int j=i+1;j<nums.length-2;j++) {//从这里开始就是3Sum
				if(j>i+1&&nums[j]==nums[j-1]) continue;//注意这里是大于i+1，来判断重复
				System.out.println(i+"-"+j);
				int tmp = target-nums[i]-nums[j];//target1=tmp
				int m = j+1,n = nums.length-1;
				System.out.println(m+":"+n);
				while(m<n) {
					if(nums[m]+nums[n]<tmp) {
						m++;
					}else if (nums[m]+nums[n]>tmp) {
						n--;
					}else {
						list.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
						while(m<n&&nums[m]==nums[m+1]) m++;
						while(m<n&&nums[n]==nums[n-1]) n--;
						m++;
						n--;
					}
				}
			}
		}
		return list;
	}
}
