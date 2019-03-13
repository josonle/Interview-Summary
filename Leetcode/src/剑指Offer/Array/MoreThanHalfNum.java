package 剑指Offer.Array;

import java.util.HashMap;

/**
 * @author josonlee
 * @title 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *        由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 *        我想的是HashMap，O(n)
 * 
 *        看到了以下几种思路： 1、排序，如果有一定是最中间那个数，然后统计那个数出现次数，时间复杂度更差
 *        2、如果有，那该数出现的次数比其他所有数字出现的次数和还要多。 在遍历数组时保存两个值：一是数组中一个数字，一是次数。
 *        遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；若次数为0，则保存下一个数字，并将次数置为1。
 *        遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可
 */
public class MoreThanHalfNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 3, 2, 2, 2, 3, 2, 2 };
		System.out.println(MoreThanHalfNum_Solution(arr));
		System.out.println(anotherSolution(arr));
	}

	public static int MoreThanHalfNum_Solution(int[] array) {
		if (array.length == 0 || array == null)
			return 0;
		int half = array.length / 2;
		if (half == 0)
			return array[0];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : array) {
			int count = map.getOrDefault(i, 0);
			if (count == 0) {
				map.put(i, 1);
			} else {
				count++;
				if (count > half)
					return i;
				map.put(i, count);
			}
		}
		return 0;
	}

	public static int anotherSolution(int[] arr) {
		if (arr.length == 0 || arr == null) {
			return 0;
		}
		int sum = 1;
		int num = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (num == arr[i])
				sum++;
			else
				sum--;
			if(sum==0) {
				num = arr[i];
				sum = 1;
			}
		}
		return sum > 1 ? num : 0;
	}
}
