package 剑指Offer.Array;

import java.util.Stack;

/**
 * @author josonlee
 * @title 在一个二维数组中（每个一维数组的长度相同）， 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。【二维数组有序】
 *        请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * 
 *        从左下角开始查，左下角保证向上的比他小，向右的比他大
 */
public class orderedArray2Find {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(1);
		stack.push(2);
		stack.push(3);
//		System.out.println(stack.peek());
//		System.out.println(stack.pop());
//		System.out.println(stack.size());
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
		System.out.println(stack.size());
	}

	public boolean Find(int target, int[][] array) {
		int i = array.length - 1;
		int j = 0;
		while (i >= 0 && j < array.length) {
			if (target == array[i][j])
				return true;
			int a = target > array[i][j] ? j++ : i--;
		}
		return false;
	}
}
