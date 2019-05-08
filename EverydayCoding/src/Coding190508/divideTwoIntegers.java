package Coding190508;

/**
 * @author josonlee
 * Topic28：https://leetcode-cn.com/problems/divide-two-integers/
 * 两数相除，给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class divideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(-7^3);
		System.out.println(divide(2,-1));
	}
	
	public static int divide(int dividend,int divisor) {
		if(dividend==0) return 0;
		if(dividend==Integer.MIN_VALUE&&divisor==-1)
			return Integer.MAX_VALUE;
		long t = Math.abs((long)dividend);
		long d = Math.abs((long)divisor);
		boolean flag = (dividend^divisor)<0;//异或小于零则互为正负
		if(d==1)
			return flag? -(int)t : (int)t;
		int result = 0;
		for(int i=31;i>=0;i--) {
			if((t>>i)>=d) {
				result += 1<<i;
				t -= d<<i;
			}
		}
		return flag? -result : result;
	}
}
