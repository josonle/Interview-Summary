package 剑指Offer.Array;

/**
 * @author josonlee
 * @title 求数组中相邻元素的和的最大值
 */
public class MaxSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,8,1,5,9};
		name(arr);
	}
	public static void name(int[] array) {
		int max = array[0],res = array[0];
		for(int i=1;i<array.length;i++){
            max = Math.max(max+array[i],array[i]);//求加上当前元素的最大和max
            res = Math.max(max,res);//比较当前元素之前的最大和res 和 加上当前最大元素的最大和max
            System.out.println(max+" "+res);
        }
		System.out.println("result :"+res);
	}
}
