package Coding190504;

/**
 * @author josonlee
 * Topic14：https://leetcode-cn.com/problems/longest-common-prefix/
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * 所有输入只包含小写字母 a-z 。
 */
public class longestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] strs = {"flower","flow","flight"};
//		String[] strs1 = {"dog","racecar","car"};
//		System.out.println(solution(strs));
//		System.out.println(solution(strs1));
		System.out.println("flowe".indexOf("flowe"));
//		System.out.println("ab".substring(0, 0));
	}
	/**
	 * 就比较m个字符串的每列，最短比较minLength次，最差比较m*minLength次
	 * @param strs
	 * @return
	 * 还有一种差不多的方法，prefix = strs[0],str.indexOf(prefix)!=0返回0表示有匹配,prefix.substring(length-1)去掉后一位
	 */
	public static String solution(String[] strs) {
		if(strs==null||strs.length==0)
			return "";
		int minLength = Integer.MAX_VALUE,len = strs.length,maxIndex = 0;
		for(int i=0;i<len;i++) {
			minLength = minLength>strs[i].length()?strs[i].length():minLength;
		}
		boolean flag = true;
		while(maxIndex<minLength) {
			char tmp = strs[0].charAt(maxIndex);
			for(String s:strs) {
				if(s.charAt(maxIndex)!=tmp) {
					flag = false;
					break;//maxIndex-1
				}
			}
			if(!flag)
				break;
			maxIndex++;
		}
		return strs[0].substring(0, maxIndex);
	}
}
