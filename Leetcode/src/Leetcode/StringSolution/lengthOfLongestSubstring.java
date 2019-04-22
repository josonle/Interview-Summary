package Leetcode.StringSolution;

import java.util.HashMap;

/**
 * @author josonlee 求最长不包含重复字符子串的长度
 */
public class lengthOfLongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestStr("abcabcbb"));
		System.out.println(solution("abcabcbb"));
	}

	public static int lengthOfLongestStr(String str) {
		int max = 0;
		if (str == null || str.length() == 0)
			return 0;
		char[] arr = str.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			int tmp = 0;
			// map存储字符及字符当前下标
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int j = i; j < arr.length; j++) {
				if (map.get(arr[j]) == null) {
					map.put(arr[j], j);
					tmp++;
				} else {
					max = tmp > max ? tmp : max;
					i = map.get(arr[j]);// 下一次遍历，从第一个重复字符下一位开始
					break;
				}
			}
		}
		return max;
	}

	public static int solution(String str) {
		int max = 0, L = 0, R = -1;
		if(str==null||str.length()==0)
			return 0;
		char[] arr = str.toCharArray();
		int[] hasArr = new int[256];
		
		while(R+1<str.length()) {
			if(hasArr[arr[R+1]]==0) {
//				hasArr[arr[R+1]] = 1;
//				R++;
				hasArr[arr[++R]] = 1;
			}else {//当前字符已经访问过，移动左边界（其实和上面解法是一致的，并非O(n)，有重复访问部分）
				hasArr[arr[L++]] = 0;
			}
			max = Math.max(R-L+1, max);
		}
		return max;
	}
}
