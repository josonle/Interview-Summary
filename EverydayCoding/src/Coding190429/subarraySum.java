package Coding190429;

import java.util.HashMap;

/**
 * @author josonlee
 * Topic560：https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数
 */
public class subarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3};
		System.out.println(solution1(arr, 3));
	}
	/**
	 * 连续子数组和为k，首先想到滑动窗口(好吧，以下方法适合不包含负数的情况，负数想不通)
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int solution(int[] nums,int k) {
		int count = 0;
		int sum = nums[0];
		int i=0,j=0;
		while(i<=nums.length-1&&j<=nums.length-1) {
			if(sum==k) {
				count++;
				//System.out.println("i:"+i+"-j:"+j);
				sum -= nums[i++];
			}else if (sum<k) {
				if(j+1<nums.length)
					sum += nums[++j];
				else 
					break;
			}else {
				sum -= nums[i++];
			}
		}
		return count;
	}
	/**
	 * 参考别人写的，P[i]= a0+a1+...+ai,P[j]= a0+a1+...+aj,如果k=P[j]-P[i],说明ai+1~aj的子数组和为k
	 * 用HashMap，k存当前的P[i],v存P[i]出现的次数(负数会造成同一个P[i]出现多次)
	 * 还有就是k=num[i]的情况，所以要map.put(0,1)
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int solution1(int[] nums,int k) {
		int count = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();//k存放P[j],v存放sum[j]出现的次数
		map.put(0, 1);
		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
			if(map.containsKey(sum-k)) {
				count += map.get(sum-k);
			}
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		return count;
	}
}
