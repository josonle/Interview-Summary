//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
//

class findMinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        int i=0,j = nums.length-1;
        int min = Integer.MAX_VALUE;

        while (i <= j) {
            int mid = (i+j)/2;
            if(nums[mid]>nums[mid+1])
                return nums[mid+1];
            if(nums[mid]>=nums[i]){//左部有序，i左部最小，往右找
                if(min>nums[i])
                    min = nums[i];
                i = mid+1;
            }else {//右部有序，mid右部最小，往左找
                if(min>nums[mid])
                    min = nums[mid];
                j = mid - 1;
            }
        }
        return min;
    }
}