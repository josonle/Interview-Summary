package Coding190506;

import java.util.LinkedList;
import java.util.List;

/**
 * @author josonlee
 * Topic22：https://leetcode-cn.com/problems/generate-parentheses/
 * 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
public class generateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> result = generate(1);
		for (String str : result) {
			System.out.println(str);
		}
	}
	public static List<String> list = new LinkedList<>();
	
	/**
	 * @param n
	 * @return
	 */
	public static List<String> generate(int n) {
		if(n<1)
			return null;
		StringBuilder stb = new StringBuilder("(");
		generateValidParenthes(stb, n-1, n);//n-1保证第一次添加有效，(
		return list;
	}
	/**
	 * 
	 * @param stb
	 * @param lNums:左括号剩余个数
	 * @param rNums：右括号剩余个数
	 * 左括号剩的的比右括号多就是无效括号组合，都不剩时加到list中
	 */
	public static void generateValidParenthes(StringBuilder stb,int lNums,int rNums) {
		if(lNums>rNums) return;
		if (lNums==0&&rNums==0) {
			list.add(stb.toString());
			return ;
		}
		if (lNums>0) {
			stb.append("(");
			generateValidParenthes(stb, lNums-1, rNums);
			stb.delete(stb.length()-1, stb.length());
		}
		if (rNums>0) {
			stb.append(")");
			generateValidParenthes(stb, lNums, rNums-1);
			stb.deleteCharAt(stb.length()-1);
		}
//		System.out.println("stb:"+stb.toString());
	}
}
