package Test409;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int w = in.nextInt();
		int arr[] = new int[2*n];
		for(int i=0;i<2*n;i++) {
			 arr[i]	 = in.nextInt();
		}
		
		System.out.printf("%.6f", solution2(n, w, arr));
//		int[] arr = {1,4,3,4,5};
//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 2, 4)));
//		int b = in.nextInt();
//		int c = in.nextInt();
//		System.out.println(solution(n, a, b, c));
	}
	/**
	 * 男孩女孩各n个，有2n个杯子，每个杯子容量ai，有w升水
	 * 要求：
	 * 男孩被子里的水一样多
	 * 女孩被子里的水一样多
	 * 男孩被子里的水是女孩杯子里的水的两倍
	 * 求最多到多少水
	 * @param n
	 * @param w
	 * @param arr 一组杯子的容量
	 * @return 最多到多少水
	 * 
	 * 也不难，逻辑理清即可，关键是女孩杯子中的水不能超过杯子中最小容量。其次没有规定男孩女孩固定用哪些杯子
	 */
	public static double solution2(int n,int w,int[] arr) {
		double boyCount = 0.0,girlCount = 0.0;
		Arrays.sort(arr);
		int[] girl = Arrays.copyOfRange(arr, 0, n);
		int[] boy = Arrays.copyOfRange(arr, n, 2*n);
		double girlMin = girl[0];
		double boyMin = 2*girlMin;
		if(boyMin>boy[0]) {
			boyMin = boy[0];
			girlMin = boyMin/2.0;
			if(n*(boyMin+girlMin)<=w) {
				boyCount = boyMin;
				girlCount = girlMin;
			}else {
				return w;
			}
		}else {
			if(n*(boyMin+girlMin)<=w) {
				boyCount = boyMin;
				girlCount = girlMin;
			}else {
				return w;
			}
		}
		return n*boyCount+n*girlCount;
	}
	/**
	 * 买巧克力，c元每块，买a块送b块，问有n块钱，最多买多少块
	 * @param n
	 * @param a
	 * @param b
	 * @param c
	 * @return 最多能买多少块
	 * 
	 * 最先以为有什么难点，用数学推导分析一下没看出坑在哪，O(∩_∩)O~
	 * 问题就是送的m块，如果超过a，还会再送m/a×b块
	 */
	public static int solution(int n,int a,int b,int c) {
		if(n<=0||c<=0||a<=0|b<=0)
			return 0;
		int count = 0;
		int tmp = n/c;//买多少块
		if(tmp<a)//不送
			count += tmp;
		else {//送
			count += tmp;
			count += tmp/a*b;
			int flag = (tmp/a)*b;
            while(flag/a>0){
                count += (flag/a)*b;
                flag = flag/a;
            }
		}
		return count;
	}
}
