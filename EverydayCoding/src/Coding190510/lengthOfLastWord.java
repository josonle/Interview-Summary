package Coding190510;

/**
 * @author josonlee
 * Topic58：https://leetcode-cn.com/problems/length-of-last-word/
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 */
public class lengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("   ".split(" ").length);
		System.out.println(solution("hello world "));
	}

	public static int solution(String str) {
		if(str==null||str.length()==0) return 0;
		String[] arr = str.trim().split(" ");
		return arr.length==0? 0 : arr[arr.length-1].length();
	}
}
