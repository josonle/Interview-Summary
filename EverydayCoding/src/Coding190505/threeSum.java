package Coding190505;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author josonlee
 * Topic15：https://leetcode-cn.com/problems/3sum/
 * 三数之和为0
 */
public class threeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		List<List<Integer>> list = solution(nums);
		for (List<Integer> list2 : list) {
			System.out.println(Arrays.toString(list2.toArray()));
		}
	}
	/**
	 * 思路就是先排序，当前nums[k]看着target，对之后的数据做twoSum和为-target
	 * 去重的思路是target不重复
	 * 优化点target>0时不可能有和为0的点
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> solution(int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		for(int k=0;k<nums.length-2;k++) {
			if(nums[k]>0) break;//和不可能为0
			if(k>0&&nums[k]==nums[k-1]) continue;//去重
			int i = k+1;
			int j = nums.length-1;
			while(i<j) {
				int tmp = nums[i]+nums[j];
				if(tmp+nums[k]>0) {
					j--;
				}else if (tmp+nums[k]<0) {
					i++;
				}else {
					list.add(Arrays.asList(nums[k],nums[i],nums[j]));
					while(i<j&&nums[i]==nums[i+1]) i++;//这里需要去重，上面不去重因为不等但可能出现-4,2,2这种情况
					while(i<j&&nums[j]==nums[j-1]) j--;
					i++;
					j--;
				}
			}
		}
		return list;
	}
}
