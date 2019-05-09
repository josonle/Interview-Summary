package Coding190509;

/**
 * @author josonlee
 * Topic53：https://leetcode-cn.com/problems/maximum-subarray/
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class maximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
		if(nums==null||nums.length==0) return 0;
		int result = nums[0];
		int sum = 0;
//		for(int a : nums) {
//			if(sum>=0)
//				sum += a;
//			else //之前和sum<0，a<0时加上a只能更小，a>0时加上还是比a小，不如就等于a
//				sum = a;
//			result = Math.max(sum, result);
//		}
		for (int i : nums) {//这样更快一点，but ？？？
			if(sum<0)
				sum = 0;
			sum += i;
			result = Math.max(sum, result);
		}
		return result;
	}
}
