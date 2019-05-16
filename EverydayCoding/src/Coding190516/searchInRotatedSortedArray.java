class searchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int i=0,j = nums.length-1;
		int result = -1;
		while(i<=j) {
			int mid = (i+j)/2;
			if(target==nums[mid]) {
				result = mid;
				break;
			}
			if(nums[mid]>=nums[i]) {//mid左部局部有序
				if(target<nums[mid]&&target>=nums[i]) {
					j = mid-1;
				}else {
					i = mid+1;
				}
			}else {//mid右部有序
				if(target>nums[mid]&&target<=nums[j]) {
					i = mid+1;
				}else {
					j = mid -1;
				}
			}
		}
		return result;
    }
}
//runtime:2 ms
//memory:34.9 MB
