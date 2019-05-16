package Coding190515;

import java.util.Arrays;

/**
 * @author josonlee
 * Topic31：https://leetcode-cn.com/problems/next-permutation/
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
   如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
   必须原地修改，只允许使用额外常数空间。
 */
public class nextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,5,8,4,7,6,5,3,1};
//		new nextPermutation().solution(nums);
		solution1(nums);
		System.out.println(Arrays.toString(nums));
		
	}

	public static void solution1(int[] nums) {
		 int i;
	        for(i=nums.length-1;i>0;--i){
	            if(nums[i]>nums[i-1]) break;
	        }
	        if(i==0) 
	        	Arrays.sort(nums);
	        else{
	            int j;
	            for(j=i+1;j<nums.length;++j) 
	            	if(nums[j]<=nums[i-1]) break;
	            int t=nums[i-1];
	            nums[i-1]=nums[j-1];
	            nums[j-1]=t;
	            Arrays.sort(nums, i, nums.length);
	        }
	}
	public void solution(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
