package 编程之法.String;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * @author josonlee
 * 两个分别由字母组成的String A、B，B比A短，如何快速确定B中所有字母都包含在A内
 * 
 * 一、最初想法是转成set集合，做差集，只要SetB为空就全包含
 * 二、其次是，想着通过HashMap判断
 * 三、看到一种解法的空间复杂度O(1)，同样是用到了哈希表，不过用一个数代替哈希表
 */
public class containString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Character> setA = new HashSet<Character>();
		char[] carr = "abcdef".toCharArray();
		for (char c : carr) {
			setA.add(c);
		}
		
		Set<Character> setB = new HashSet<Character>();
		char[] carr2 = "chdedf".toCharArray();
		for (char c : carr2) {
			setB.add(c);
		}
		setB.removeAll(setA);
		System.out.println(setA.containsAll(setB));
		System.out.println(setB.isEmpty());
		
		System.out.println(contains("asdfkhas", "dfa"));
		System.out.println(contains1("asdfkhas", "defa"));
	}

	public static boolean contains(String astr,String bstr) {
		Set<Character> set = new HashSet<Character>(astr.length());
		for (int i = 0; i < astr.length(); i++) {
			set.add(astr.charAt(i));
		}
		for (int i = 0; i < bstr.length(); i++) {
			if (!set.contains(bstr.charAt(i)))
				return false;
		}
		return true;
	}
	
	public static boolean contains1(String astr,String bstr) {
		int hash = 0;
		for(int i=0;i<astr.length();i++)
			hash |= (1<<(astr.charAt(i)-'A'));
		for(int i=0;i<bstr.length();i++) {
			if((hash & (1 << (bstr.charAt(i)-'A')))== 0)
				return false;
		}
		return true;
	}
}
