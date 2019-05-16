package Coding190515;

/**
 * @author josonlee
 * Topic33：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 搜索旋转数组
 * 按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 你可以假设数组中不存在重复的元素。
 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class searchRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,1,3};
		System.out.println(search(nums, 5));
	}

	public static int search(int[] nums, int target) {
		int i=0,j = nums.length-1;
		int result = -1;
		while(i<=j) {
			int mid = (i+j)/2;
			if(target==nums[mid]) {
				result = mid;
				break;
			}
			System.out.println(i+"-:"+j);
			if(nums[mid]>=nums[i]) {//mid左部局部有序
				if(target<nums[mid]&&target>=nums[i]) {
					j = mid-1;
				}else {
					i = mid+1;
				}
			}else {//mid右部有序
				System.out.println(i+"----"+j);
				if(target>nums[mid]&&target<=nums[j]) {
					i = mid+1;
				}else {
					j = mid -1;
				}
			}
			System.out.println(i+"-"+j);
		}
		return result;
	}
}
