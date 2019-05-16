//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
//

class findFirstLastpositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums==null||nums.length==0)
            return result;
        if(target<nums[0]||target>nums[nums.length-1])
            return result;
        int i = 0,j = nums.length-1;
        while(i<=j){
            int mid = (i+j)>>1;
            if(target>nums[mid])
                i = mid+1;
            else if(target<nums[mid])
                j = mid -1;
            else{
                int low = mid,high = mid;
                while(low>i&&nums[low]==nums[low-1])
                    low--;
                while(high<j&&nums[high]==nums[high+1])
                    high++;
                result[0] = low;
                result[1] = high;
                break;
            }
        }
        return result;
    }
}