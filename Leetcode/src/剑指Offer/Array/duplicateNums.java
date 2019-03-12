package 剑指Offer.Array;

import java.util.HashMap;

/**
 * @author josonlee
 * @title 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 （就是判断有无重复数字）
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2
 */
public class duplicateNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,4,5,2};
		System.out.println(duplicate(arr, arr.length, new int[1]));
	}
	/**
	 * 
	 * @param numbers
	 * @param length:numbers长度
	 * @param duplication：返回任意重复一个值给duplication[0]
	 * @return
	 */
	public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length==0)
            return false;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>(length);
        boolean flag = false;
        
        for(int n:numbers){
            if(map.get(n)!=null){
                flag = true;
                duplication[0] = n;
                break;
            }else{
                map.put(n,1);
            }
        }
        return flag;
    }
}
