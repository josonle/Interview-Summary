package 编程之法.String;

import sun.management.counter.StringCounter;

/**
 * 旋转字符串，要求时间复杂度O(n)，空间复杂度O(1)。如abcdef旋转为cdefab
 * @author josonlee
 */
public class reverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseStringByK("abcdef", 7));
	}

	public static void reverse(char[] carr,int from,int to) {
		int i=from, j=to;
		while(i<j) {
			char tmp = carr[i];
			carr[i] = carr[j];
			carr[j] = tmp;
			i++;
			j--;
		}
	}
	
	/**
	 * 看到一种方法叫做——三步反转法
	 * 比如X^T表示X反转，则(XY)^T = (X^TY^T)^T = YX
	 * 所以分三步，先反转X和Y，再反转X^TY^T
	 */
	public static String reverseStringByK(String str,int k) {
		k %= str.length();
		char[] carr = str.toCharArray();
		reverse(carr,0,k-1);
		reverse(carr, k, carr.length-1);
		reverse(carr, 0, carr.length-1);
		return new String(carr);
	}
	
	/**
	 * 最简单就是后移k次，每次一个字符，但是每次移动都要不断前移其余字符，时间复杂度O(kn)
	 */
}
