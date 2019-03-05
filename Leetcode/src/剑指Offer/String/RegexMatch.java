package 剑指Offer.String;

/**
 * @author josonlee
 * @category String
 * @title 19：实现正则表达式中.和*的功能。.表示任意一个字符，*表示他前面的字符的任意次（含0次）
 *        比如aaa与a.a和ab*ac*a匹配，但与aa.a和ab*a不匹配
 */
public class RegexMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(match("aaa", "a.a"));
		System.out.println(match("aaa", "ab*ac*a"));
		System.out.println(match("aaa", "ab.a"));
		System.out.println(match("aaa", ".*"));
		System.out.println(match("aaa", ".a*"));
		System.out.println(match("abbab", ".*.*"));
		System.out.println(match("abbaacb", "..*.*..*"));
	}

	public static boolean match(String str, String Pstr) {
		if (str == null || Pstr == null) {
			return false;
		}
		return matchCore(str, 0, Pstr, 0);
	}

	private static boolean matchCore(String input, int i, String pattern, int p) {
        // 匹配串和模式串都到达尾，说明成功匹配
        if (i >= input.length() && p >= pattern.length()) {
            return true;
        }
        // 只有模式串到达结尾，说明匹配失败
        if (i != input.length() && p >= pattern.length()) {
            return false;
        }
        // 模式串未结束，匹配串有可能结束有可能未结束
        // p位置的下一个字符中为*号
        if (p + 1 < pattern.length() && pattern.charAt(p + 1) == '*') {
            // 匹配串已经结束
            if (i >= input.length()) {
                return matchCore(input, i, pattern, p + 2);
            }
            // 匹配串还没有结束
            else {
                if (pattern.charAt(p) == input.charAt(i) || pattern.charAt(p) == '.') {
                    return
                            // 匹配串向后移动一个位置，模式串向后移动两个位置
                            matchCore(input, i + 1, pattern, p + 2)
                                    // 匹配串向后移动一个位置，模式串不移动
                                    || (matchCore(input, i + 1, pattern, p)&& (input.charAt(i)==input.charAt(i+1)))
                                    // 匹配串不移动，模式串向后移动两个位置
                                    || matchCore(input, i, pattern, p + 2);
                } else {
                    return matchCore(input, i, pattern, p + 2);
                }
            }
        }
        //
        // 匹配串已经结束
        if (i >= input.length()) {
            return false;
        }
        // 匹配串还没有结束
        else {
            if (input.charAt(i) == pattern.charAt(p) || pattern.charAt(p) == '.') {
                return matchCore(input, i + 1, pattern, p + 1);
            }
        }
        return false;
    }
	
	private static boolean strMatch(String str, int sIndex, String pstr, int pIndex) {
		if (str.length() <=sIndex && pstr.length() <= pIndex)
			return true;
		if (pstr.length() == pIndex && str.length() != sIndex)// Pattern串没有完全匹配str
			return false;
		char[] sChar = str.toCharArray();
		char[] pChar = pstr.toCharArray();

		if (pIndex + 1 < pstr.length() && pChar[pIndex + 1] == '*') {// pStr下一个字符是*，涉及pStr当前字符是匹配0还是n次
			return strMatch(str, sIndex + 1, pstr, pIndex) 
					|| strMatch(str, sIndex, pstr, pIndex + 2)
					|| strMatch(str, sIndex + 1, pstr, pIndex + 2);
		} else {
			// pStr下一个字符不是*，则当前pStr是匹配或.，说以都跳过一个字符
			if(pChar[pIndex]=='.'||pChar[pIndex]==sChar[sIndex])
				return strMatch(str, sIndex + 1, pstr, pIndex + 1);
			//pStr下一个字符不是*,当前没有匹配
			return false;
		}
	}
}
