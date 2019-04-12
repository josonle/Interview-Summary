package Test411;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		//A：65，a：97,0:48
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int k = in.nextInt();
//		int m = in.nextInt();
		
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
//			arr[i] = in.nextInt();
			solution3(in.nextInt());
		}
//		for (int i : arr) {
//			solution3(i);
//		}
//		int m = in.nextInt();
//		solution(n, m);
	}
	
	public static void solution2(int n,int k,int m) {
		
	}
	public static void solution3(int m) {
		if(m<=0||m>1000)
			return;
		int count = 0;
		while(m!=1) {
			if(m%2==0) {
				m = m/2;
				count++;
			}else {
				m = 3*m+1;
				count++;
			}
		}
		System.out.println(count);
	}
	public static void solution(int n,int m) {
		if(n<=0||m<=0||m>=1000)
			return;
		int count = 0;
		LinkedList<Integer> link = new LinkedList<Integer>();
		ArrayList<Integer> arrayList = new ArrayList<Integer>(n);
		System.out.println(n+"-"+m);
		for(int i=1;i<=n;i++) {
			link.push(i);
			count++;
			if(count==m) {
				System.out.println("--:"+link.peekFirst()+"-"+count);
				arrayList.add(link.removeFirst());
				count = 0;
			}
		}
		while(link.size()!=1) {
			Integer tmp = link.removeLast();
			link.push(tmp);
			count++;
			if(count==m) {
				arrayList.add(link.removeFirst());
				count = 0;
			}
		}
		StringBuffer str = new StringBuffer();
		if(!arrayList.isEmpty()) {
			for (Integer integer : arrayList) {
//				System.out.print(integer+" ");
				str.append((int)integer+" ");
			}
			System.out.println(str.toString().trim());
		}
//		System.out.println();
		System.out.println(link.peek());
	}
}
