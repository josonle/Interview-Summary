package Coding190430;

import java.util.HashMap;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author josonlee
 *         Topic3：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *         给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class lengthOfLongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new lengthOfLongestSubstring().solution("pwwkew"));
		System.out.println(new lengthOfLongestSubstring().solution1("pwwkew"));
	}

	private HashMap<Character, Integer> map = new HashMap();

	//内存开销大
	public int solution(String s) {
		int len = 0, tlen = 0;
		int l = 0;// 标记子串最左
		int i = 0;
		char[] arr = s.toCharArray();
		while(i<arr.length) {
			if (map.containsKey(arr[i])) {
				if (i - l > len) {
					len = i - l;
					System.out.println(l+"-"+i);
				}
				l = map.get(arr[i]) + 1;
				i = l;
				map.clear();
				tlen = 0;
				System.out.println("i:"+i);
			} else {
				map.put(arr[i], i);
				tlen++;
				i++;
			}
		}
		return len>tlen?len:tlen;
	}
	
	public int solution1(String str) {
		int len = 0;
		int i,j,left=0;
		for(i=0;i<str.length();i++) {
			for(j=left;j<i;j++) {
				if(str.charAt(j)==str.charAt(i))
					left = j+1;
				len = i-left+1>len?i-left+1:len;
			}
		}
		return len;
	}
}
