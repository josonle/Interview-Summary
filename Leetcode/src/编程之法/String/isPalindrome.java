package 编程之法.String;

/**
 * @author josonlee
 * 回文字符串判断，及最长回文子串
 */
public class isPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("aasddsfgghhggf"));
	}
	/**
	 * 不同于以往想法，这个是从中间向两边遍历的
	 * @param str
	 * @return 最长回文长度
	 */
	public static int longestPalindrome(String str) {
		if(str==null||str.length()==0)
			return 0;
		int max = 0;
		char[] arr = str.toCharArray();
		int len = arr.length;
		for(int i=0;i<len;i++) {
			int tmp = 0;
			for(int l=0;(i-l>=0)&&(i+l<len);l++) {//子串为奇
				if(arr[i+l] != arr[i-l])
					break;
				tmp = 2*l+1;
			}
			if(tmp>max)
				max = tmp;
			for(int l=0;(i-l>=0)&&(i+l+1<len);l++) {//子串为偶
				if(arr[i+l+1] != arr[i-l])
					break;
				tmp = 2*(l+1);
			}
			if(tmp>max)
				max = tmp;
		}
		return max;
	}
	public static boolean isPalindromeStr(String str) {
		if(str==null||str.length()==0)
			return false;
		char[] arr = str.toCharArray();
		int i=0, j=arr.length-1;
		while(i<j) {
			if(arr[i]!=arr[j])
				return false;
		}
		return true;
	}
}
