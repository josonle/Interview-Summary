package Test423;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner in = new Scanner(System.in);
//		int k = in.nextInt();
//		int[] arr = new int[k];
//		for (int i=0; i<k; i++) {
//			arr[i] = in.nextInt();
//		}
//		for (int i : arr) {
//			System.out.println(solution(i));
//		}
		System.out.println(1+1<<32);
//		String sString = in.nextLine();
//		String tString = in.nextLine();
////		System.out.println(sString+"-"+tString);
//		System.out.println(solution3(sString, tString));
	}
	/**
	 * 字符串匹配
	 * 给出一个仅由大小写字母和‘？’组成的字符串S，和一个仅由大小写字母组成的字符串T，已知‘？’可以由任何一个大小写字母替代，问S字符串最多可以匹配多少个T字符串，两个不同的匹配之间可以重合，
	 * 例如S=ababa，T=aba，则S最多同时匹配两个T串。
	 * @param 
	 * @return
	 * 尼玛，只过了0.45，也没报错，不知道哪出了问题
	 */
	public static int solution3(String str,String tstr) {
		int tmp = 0;//标记匹配次数
		if(str==null||tstr==null||str.length()==0||tstr.length()==0||str.length()<tstr.length())
			return 0;
		char[] sarr = str.toCharArray();
		char[] tarr = tstr.toCharArray();
		int[] flag = new int[sarr.length-tarr.length];
		int j = 0;//j表示flag加入了几个匹配到了值的下标
		
		for (int i = 0; i < sarr.length; i++) {
			if(sarr[i]=='?'||sarr[i] == tarr[0]) {
				if(j>=flag.length)
					break;
				System.out.println("j::"+j+"-"+i);
				flag[j++] = i;
			}
		}
		for (int i = 0; i < j; i++) {
			int index = flag[i];
			boolean hased = true;
			for(int k=1;k<tarr.length;k++) {
				if(sarr[index+k]!='?'&&sarr[index+k]!=tarr[k]) {
					hased = false;
					break;
				}
			}
			if(hased) {
				tmp++;
			}
		}
		return tmp;
	}
	/**
	 * n×n的方形跑道，每次跑n+1就停下了做标记，如果遇到了重复标记就停止（最后一次也会做标记）
	 * 问最多会标记多少次？
	 * @param n
	 * @return
	 * 
	 * 像n=4，标记17次（16+1）
	 * 尼玛，也是过了0.45，报的是数组空间分配过大，确实比如n过大时申请的HashSet也很大，但用的位置不多
	 */
	public static int solution(int n) {
		if(n<=0)
			return 0;
		int tmp = 1;
		HashSet<Integer> set = new HashSet<Integer>();
		while(true) {
			int ans = (tmp*(n+1))%(4*n);
			if(set.contains(ans)){
				System.out.println(ans);
				break;
			}
			set.add(ans);
			tmp++;
		}
		return tmp;
	}
	/**
	 * 同上题，本想用数移位来替代HashSet，后来想到1<<32=1,想法是好的，实现有问题
	 * @param n
	 * @return
	 */
	public static int solution2(int n) {
		if(n<=0)
			return 0;
		int tmp = 1;
		int flag = 0;
		while(true) {
			int ans = (tmp*(n+1))%(4*n);
			if((flag&(1<<ans))!=0){
//				tmp++;
				System.out.println(ans);
				break;
			}
			flag += 1<<ans;
			tmp++;
		}
		return tmp;
	}
}
