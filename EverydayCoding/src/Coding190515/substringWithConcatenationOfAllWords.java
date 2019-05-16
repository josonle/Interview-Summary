package Coding190515;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import Coding190504.intToRoman;

/**
 * @author josonlee
 * Topic30：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * 给定一个字符串 s 和一些长度相同的单词 words。
 * 找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
   注意子串要与 words 中的单词完全匹配，中间不能有其他字符，
   但不需要考虑 words 中单词串联的顺序。
 */
public class substringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		"wordgoodgoodgoodbestword"
		String str = "wordgoodgoodgoodbestword";
		String[] words = {"word","good","best","good"};
		List<Integer> list = findSubstring(str, words);
		System.out.println(Arrays.toString(list.toArray()));
	}
	/**
	 * 思路：map保存words中word出现的次数，因为word长度相等，可以遍历s时截取word长度的子串看是否在Map中
	 * 在的话对应value减一，不在的话遍历s下一个位置
	 * 时间复杂度是O(nK),n是words长度
	 * @param s
	 * @param words
	 * @return
	 */
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<>();
		if(s==null||words.length==0||words==null) return list;
		if(words[0].length()*words.length>s.length()) return list;
		int wdLen = words[0].length();
		HashMap<String, Integer> map = new HashMap<>(words.length);
		for (int i=0;i<words.length;i++) {
			map.put(words[i],map.getOrDefault(words[i], 0)+1);
		}
		for(int i=0;i<s.length()-wdLen*words.length+1;i++) {
			boolean flag = true;
			HashMap<String, Integer> tMap = new HashMap<>(map);
			for(int j=0;j<words.length;j++) {//匹配所有word
				int start = i+j*wdLen;
				String wd = s.substring(start, start+wdLen);
				int index = tMap.getOrDefault(wd, 0);
//				System.out.println(wd+"-"+index);
				if(index==0) {//没一个匹配
					flag = false;
					break;
				}
//				System.out.println("index:"+index);
				tMap.put(wd, index-1);
			}
			if (flag) {//flag true全部匹配
				list.add(i);
			}
		}
		return list;
	}
}
