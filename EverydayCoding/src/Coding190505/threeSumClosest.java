package Coding190505;

import java.util.Arrays;
/**
 * @author josonlee
 * Topic16：https://leetcode-cn.com/problems/3sum-closest/
 * 三数之和最接近target的唯一结果
 */
public class threeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums1 = {6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10};
//		System.out.println(solution(nums1,-52));
		
		int[] num = {1,1,-2,-1,4,7};
		System.out.println(threeSumSmaller(num, 5));
		int[] arr = {-2, 0, 1, 3};
		System.out.println(threeSumSmaller(arr, 2));
	}

	public static int solution(int[] nums, int target) {//还有问题
        if(nums==null||nums.length<3)
            return 0;
        Arrays.sort(nums);
        int minDev = Integer.MAX_VALUE;//sum-target
        int minSum = Integer.MAX_VALUE;
        for(int k=0;k<nums.length-2;k++){
            if(nums[k]>=0&&nums[k]>=target){
                if(nums[k]+nums[k+1]+nums[k+2]<minSum)
                    minSum = nums[k]+nums[k+1]+nums[k+2];
                break;
            }
            int i = k+1,j=nums.length-1;
            while(i<j){
                int tmp = nums[i]+nums[j]+nums[k];
                System.out.println(i+"-"+j+"-"+tmp);
                if(tmp<target){
                	if (Math.abs(tmp-target)<minDev) {
						minDev = Math.abs(tmp-target);
						minSum = tmp;
					}
                    i++;
                }else if(tmp>target){
                	if (Math.abs(tmp-target)<minDev) {
						minDev = Math.abs(tmp-target);
						minSum = tmp;
					}
                    j--;
                }else{
                	System.out.println("k"+k+"-"+"i"+i+"-"+"j"+j);
                    return target;
                }
            }
        }
        return minSum;
    }
	/**
	 * Topic259:https://leetcode.com/problems/3sum-smaller
	 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
	 * For example, given nums = [-2, 0, 1, 3], and target = 2.Return 2.
	 * @param nums
	 * @param target
	 * @return n种三元组满足三数之和小于target
	 */
	public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int cnt = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum >= target){
                    right--;
                } else {
                    // right左移right - left位都满足
                    cnt += right - left;
                    left++;
                }
            }
        }
        return cnt;
    }
}
