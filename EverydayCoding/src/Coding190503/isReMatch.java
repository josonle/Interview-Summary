package Coding190503;

/**
 * @author josonlee
 * Topic10：https://leetcode-cn.com/problems/regular-expression-matching/
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配，匹配是对整个字符串 (s) ，而不是部分字符串
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 */
public class isReMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("ab",".*c"));
	}

	public static boolean isMatchCore(char[] str, char[] exp, int i, int j) {
		// 已经匹配完毕
		if (j == exp.length) {
			return i == str.length;
		}
		// p的下一个字符不是* 则需要当前字符相等 且后面全部匹配
		if (j + 1 == exp.length || exp[j + 1] != '*') {
			return i < str.length && (str[i] == exp[j] || exp[j] == '.') && isMatchCore(str, exp, i + 1, j + 1);
		}

		// p的下一个字符是* 且有s[i] == p[j] || p[j] == '.')
		// p匹配s的1,2,3..直到s[i] ！= p[j]
		while (i < str.length && (str[i] == exp[j] || exp[j] == '.')) {
			if (isMatchCore(str, exp, i, j + 2)) {
				return true;
			}
			i++;
		}
		// 不能用*匹配时略过*
		return isMatchCore(str, exp, i, j + 2);
	}
	public static boolean solution(String s,String p) {
		if (s==null||p==null) {
			return false;
		}
		return isMatchCore(s.toCharArray(), p.toCharArray(), 0, 0);
//		return regexMatcher(s.toCharArray(),p.toCharArray(),0,0);
	}
	public static boolean regexMatcher(char[] str,char[] pattern,int i,int j) {
		if(j==pattern.length)//pattern已经遍历完，判断s有无剩余
			return i==str.length;
		//以下思想就是看当前和下一个字符是哪些情况，
		if(j+1==pattern.length||pattern[j+1]!='*')
			return (str[i]==pattern[j]||pattern[j]=='.')&&i<str.length&&regexMatcher(str, pattern, i+1, j+1);
		while(i<str.length&&(str[i]==pattern[j]||pattern[j]=='.')) {//a*/.*
			if(regexMatcher(str, pattern, i, j+2))
				return true;
			i++;
		}
		return regexMatcher(str, pattern, i, j+2);
	}
}
