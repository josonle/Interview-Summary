package Leetcode.StringSolution;

public class AddToN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Answer is "+solution(3));
		System.out.println(add(5, 6));
	}
	/**
	 * @author josonlee
	 * @title 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
	 */
	public static int solution(int n) {
		int ans = n;
		boolean flag = (ans>0) && (ans += solution(n-1))>0;
		return ans;
	}
	/**
	 * @title 函数内不得使用+、-、*、/四则运算符号做加法
	 */
	public static int add(int n1,int n2) {
		int tmp;
		while(n2!=0) {
			tmp = n1^n2;//计算加法（不含进位）
			n2 = (n1&n2)<<1;//计算进位
			n1 = tmp;
		}
		return n1;
	}
}



class Solution {
 
    public int movingCount(int threshold, int rows, int cols) {
        int flag[][] = new int[rows][cols]; //记录是否已经走过
        return helper(0, 0, rows, cols, flag, threshold);
    }
 
    private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j)  > threshold || flag[i][j] == 1) return 0;    
        flag[i][j] = 1;
        return helper(i - 1, j, rows, cols, flag, threshold)
            + helper(i + 1, j, rows, cols, flag, threshold)
            + helper(i, j - 1, rows, cols, flag, threshold)
            + helper(i, j + 1, rows, cols, flag, threshold)
            + 1;
    }
 
    private int numSum(int i) {
        int sum = 0;
        do{
            sum += i%10;
        }while((i = i/10) > 0);
        return sum;
    }
}
