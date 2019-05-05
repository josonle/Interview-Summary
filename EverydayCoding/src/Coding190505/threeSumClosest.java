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

	}

	public int solution(int[] nums, int target) {//还有问题
        if(nums==null||nums.length<3)
            return 0;
        Arrays.sort(nums);
        int minDev = Integer.MAX_VALUE;//sum-target
        int minSum = Integer.MAX_VALUE;
        for(int k=0;k<nums.length-2;k++){
            if(nums[k]>=target){
                if(nums[k]+nums[k+1]+nums[k+2]<minSum)
                    minSum = nums[k]+nums[k+1]+nums[k+2];
                break;
            }
            int i = k+1,j=nums.length-1;
            while(i<j){
                int tmp = nums[i]+nums[j]+nums[k];
                if(tmp<target){
                    minSum = Math.abs(tmp-target)<minDev?tmp:minSum;
                    minDev = Math.abs(tmp-target)<minDev?Math.abs(tmp-target):minDev;
                    i++;
                }else if(tmp>target){
                    minSum = Math.abs(tmp-target)<minDev?tmp:minSum;
                    minDev = Math.abs(tmp-target)<minDev?Math.abs(tmp-target):minDev;
                    j--;
                }else{
                    minSum = target;
                    return target;
                }
            }
        }
        return minSum;
    }
}
