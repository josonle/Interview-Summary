package Coding190503;

import com.sun.swing.internal.plaf.synth.resources.synth_pt_BR;

public class countAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(4));
		System.out.println(solution(5));
		System.out.println(solution(6));
	}
	
	public static String solution(int n) {
		StringBuilder input = new StringBuilder("1");
		int i = 2;
		while(i<=n) {
			input = countToStr(input);
			i++;
		}
		return input.toString();
	}
	private static StringBuilder stb ;
	public static StringBuilder countToStr(StringBuilder input) {
		char tmp;
		int count = 1;
		stb = new StringBuilder();
		for(int i=0;i<input.length();) {
			tmp = input.charAt(i);
			for(int j=i+1;j<input.length()&&input.charAt(j)==tmp;j++)
				count++;
			stb.append(count).append(tmp);
			i += count;
			count = 1;
		}
		return stb;
	}
}
