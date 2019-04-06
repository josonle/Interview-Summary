package Test405;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
//		int[] gonfu = new int[n];
//		int[] money = new int[n];
//		for (int i = 0; i < n; i++) {
//			gonfu[i] = in.nextInt();
//		}
//		for (int i = 0; i < n; i++) {
//			money[i] = in.nextInt();
//		}
//		System.out.println(Arrays.toString(gonfu));
//		System.out.println(Arrays.toString(money));
//		System.out.println(solution2(gonfu, money));
//		in.nextLine();
		String str = in.nextLine();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = in.nextInt();
		}
		int[] nums = new int[arr.length];
//		System.out.println(m+"-"+n);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(solution(m, Arrays.sort(arr);));
	}
	/**
	 * 字符串由0和1组成，如果0和1相邻可消去，问最终最短str长度
	 * @param str
	 * 腾讯19年卷，一次AC
	 */
	public static void solutin3(String str) {
		StringBuffer sb = new StringBuffer(str);
		while(sb.indexOf("01")!=-1||sb.indexOf("10")!=-1)
		{
			int index1 = sb.indexOf("01");
			if(index1!=-1)
				sb.replace(index1, index1+2, "");
			int index2 = sb.indexOf("10");
			if(index2!=-1)
				sb.replace(index2, index2+2, "");
		}
		System.out.println(sb.toString().length());
	}
	/**
	 * @title n个怪兽，每个怪兽有一个武力值，以及一个贿赂金额。小明通过山谷遇到怪兽的话可以选择贿赂它，并雇为保镖。
	 * 如果当前保镖的总武力值超过遇到的怪兽可以选择不雇佣。问最少花费多少钱可以通过山谷
	 * @param gonfu[] 怪兽武力值
	 * @param money[] 贿赂金额
	 * @return 最小花费
	 * 来源腾讯19年卷，通过率80%，剩下0.2不知道，下次再想吧
	 */
	public static int solution2(int[] gonfu,int[] money) {
		int flag = 0;//武力总和
		int minMoney = 0;//最少money
		boolean[] haved = new boolean[gonfu.length];//标记购买
		for (boolean b : haved) {
			b = false;
		}
		for (int i=0;i<gonfu.length;i++) {
			if(flag<gonfu[i]) {
				int minIndex = 0;
				int mon = Integer.MAX_VALUE;
				boolean tmp = false;//标记之前有
				for(int j=0;j<i;j++) {
					if(gonfu[j]+flag>=gonfu[i]&&!haved[j]) {
						if(money[j]<mon) {
							mon = money[j];
							minIndex = j;
							tmp = true;
						}
					}
				}
				if(tmp) {
					if(minMoney<money[i]) {
						flag += gonfu[minIndex];
						minMoney += money[minIndex];
						haved[minIndex] = true;
					}else if (minMoney>money[i]) {
						flag += gonfu[i];
						minMoney += money[i];
						haved[i] = true;
					}else {
						if(gonfu[minIndex]>gonfu[i]) {
							flag += gonfu[minIndex];
							minMoney += money[minIndex];
							haved[minIndex] = true;
						}else {
							flag += gonfu[i];
							minMoney += money[i];
							haved[i] = true;
						}
					}
				}else {
					flag += gonfu[i];
					minMoney += money[i];
					haved[i] = true;
				}
			}
			System.out.println("min:"+minMoney);
			System.out.println(Arrays.toString(haved));
		}
		return minMoney;
	}
	/**
	 * 一组硬币面值arr[]，问怎么凑能保证凑齐金额1～m，而且要保证硬币数目最少
	 * 比如说1,2,5,10元，凑齐1～20元，最少需要5枚（1,2,2,5,10）
	 * @param m
	 * @param arr 排序后数组
	 * @param nums 本想递归，每次找满足的最大面值硬币arr[i]，使nums[i]+=1
	 * @return 最少硬币个数
	 * 腾讯19年卷，没写出来，下面是错的，想糊涂了
	 */
	public static int solution(int m,int[] arr,int[] nums) {
//		if(m<arr[0])
//			return -1;
		int index = 0;//记录m到底有多大
		for(int i=arr.length-1;i>=0;i++) {
			if(m/arr[i]>0) {
				index = i;
				nums[i] += 1;
				break;
			}
		}
		return solution(m-m/arr[index]*arr[index], arr, nums)+solution(m-1, arr, nums);
	}
}
