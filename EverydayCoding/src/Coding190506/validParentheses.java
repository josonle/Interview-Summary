package Coding190506;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author josonlee
 * Topic20：https://leetcode-cn.com/problems/valid-parentheses/
 *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
	左括号必须用相同类型的右括号闭合。
	左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class validParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid(")"));
	}
	public static HashMap<String, String> map = new HashMap<>(3);
	public static boolean isValid(String s) {
		if(s==null||s.length()==0) return true;
		char[] arr = s.toCharArray();
		Stack<String> stack = new Stack<>();
		map.put(")", "(");
		map.put("]", "[");
		map.put("}", "{");
		
		for(char c:arr) {
			if(c=='('||c=='['||c=='{') {
				stack.push(Character.toString(c));
			}else {
				if(stack.isEmpty())//可能第一个插入的就是右括
					return false;
				if(map.get(Character.toString(c)).equals(stack.peek()))
					stack.pop();
				else 
					return false;
			}
		}
		return stack.isEmpty();
	}
}
