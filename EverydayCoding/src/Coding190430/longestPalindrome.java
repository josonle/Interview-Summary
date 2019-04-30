package Coding190430;

/**
 * @author josonlee
 * Topic5：https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 */
public class longestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution1("bb"));
		System.out.println(solution2("bab"));
	}

	public static String solution1(String str) {
		int len =0,maxLen = 0,n = str.length();
		int start = 0;
		for(int i=0;i<n;i++) {//i标记回文串的中点，不过要区分奇偶
			for(int j=0;(i-j>=0)&&(i+j<n);j++) {//j代表回文串长度一半
				if(str.charAt(i-j)!=str.charAt(i+j))
					break;
				len = j*2+1;//奇数串
			}
			if(len>maxLen) {
				maxLen = len;
				start = i-len/2;
			}
			for(int j=0;(i-j>=0)&&(i+j+1<n);j++) {
				if(str.charAt(i-j)!=str.charAt(i+j+1))
					break;
				len = (j+1)*2;//偶数串
			}
			if(len>maxLen) {
				maxLen = len;
				start = i-len/2+1;
			}
		}
		System.out.println("start:"+start);
		return str.substring(start, start+maxLen);
	}
	
	public static String solution2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int[] range = new int[2];
        char[] chars = s.toCharArray();
        int low;
        int high;
        for (int i = 0; i < chars.length; i++) {
            low = i;
            high = low;
            while (high < chars.length - 1 && chars[high+1] == chars[low]) {
                high++;
            }
            i = high;
            while (low > 0 && high < chars.length - 1 && chars[low - 1] == chars[high + 1]) {
                low--;
                high++;
            }
            if (high - low > range[1] - range[0]) {
                range[0] = low;
                range[1] = high;
            }
        }
        return s.substring(range[0], range[1] + 1);
    }
}
