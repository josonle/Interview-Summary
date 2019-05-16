package Coding190510;

import java.util.Arrays;

/**
 * @author josonlee
 * Topic66：https://leetcode-cn.com/problems/plus-one/
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
   最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
   你可以假设除了整数 0 之外，这个整数不会以零开头。
   如[4,3,2,1]表示4321，加一即[4,3,2,2]
 */
public class plusOne {

	public static void main(String[] args) {
		int[] nums = {8,9,9,9};
		System.out.println(Arrays.toString(solution(nums)));
//		int[] arr = new int[5];
//		System.arraycopy(nums, 0, arr, 1, 4);
//		System.out.println(nums.length);
//		System.out.println(arr.length);
//		System.out.println(arr[1]);
	}
    	
	public static int[] solution(int[] digits) {
		
		int i = digits.length-1;
		for(;i>=0;i--) {
			digits[i] += 1;
			if(digits[i]==10) {//有进位
				digits[i] -= 10;
			}else {
				break;
			}
		}
		if(i==-1) {
			int[] nums = new int[digits.length+1];
			nums[0] = 1;
// 			System.arraycopy(digits, 0, nums, 1, digits.length);//没必要复制了，因为进位之后原数组位置都是0，直接nums[0] = 1即可
			return nums;
		}
		return digits;
	}
}
