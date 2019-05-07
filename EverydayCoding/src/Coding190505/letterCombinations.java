package Coding190505;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author josonlee
 * Topic17：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 可以任意选择答案输出的顺序
 */
public class letterCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println('2'-'0'-2);
		List<String> c = solution("232");
		for(String str:c) {
			System.out.println(str);
		}
	}

	public static List<String> getString(String[] sArr, List<String> c) {
        List<String> result = new ArrayList<>();
        for (String s : sArr) {
            if (!c.isEmpty()) {
                for (String ss : c) {
                    ss += s;
                    result.add(ss);
                }
            } else {
                result.add(s);
            }
        }
//        值传递和引用传递
//        System.out.println(Arrays.toString(result.toArray()));
//        System.out.println(Arrays.toString(c.toArray()));
        return result;
    }
	
	public static List<String> solution(String digits) {
		List<String> list = new ArrayList<>();
		String[] arr = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		char[] carr = digits.toCharArray();
		for (char c : carr) {
			String tmp = arr[c-'0'-2];
			list = addCharToString(tmp,list);
		}
		return list;
	}
	public static List<String> addCharToString(String str,List<String> list) {
		List<String> result = new ArrayList<>();
		if(!list.isEmpty()) {
			for(int i=0;i<str.length();i++) {
				for (String s : list) {
					s += str.charAt(i);
					result.add(s);
				}
			}
		}else {
			for(int i=0;i<str.length();i++) {
				result.add(str.substring(i, i+1));
			}
		}
		return result;
	}
}
