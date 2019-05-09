package Coding190509;

/**
 * @author josonlee
 * Topic35：https://leetcode-cn.com/problems/search-insert-position/
 * 一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置
 * 假设数组中无重复元素
 */
public class searchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,5,6};
		System.out.println(searchInsert(nums, 3));
	}
	//优化点就是二分查找了
	public static int searchInsert(int[] nums,int target) {
		if(nums==null||nums.length==0) return 0;
		int index = 0;
		for(int i=0;i<nums.length;i++) {
			if(target>nums[i])
				index++;
			else
				break;
		}
		return index;
	}
}
