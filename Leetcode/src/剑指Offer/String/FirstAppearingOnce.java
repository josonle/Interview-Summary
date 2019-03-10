package 剑指Offer.String;

import java.util.HashMap;
import java.util.Scanner;


public class FirstAppearingOnce {
	String str;
	StringBuilder stringBuilder = new StringBuilder();
	HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
	
	public FirstAppearingOnce(String string) {
		// TODO Auto-generated constructor stub
		this.str = string;
	}
	public void insert(char ch) {
//		stringBuilder.append(ch);//MMP终于知道它字符来源就是这个输入的char
		if (hMap.containsKey(ch)) {
			hMap.put(ch, 0);
		}else {
			hMap.put(ch, 1);
		}
	}
	@SuppressWarnings("resource")
	public char FirstAppearOnce() {
//		Scanner scanner = new Scanner(System.in);
//		String str = scanner.nextLine();
		for (char c : str.toCharArray()) {
			insert(c);
		}
		int index = 0;
		for (char c1 : str.toCharArray()) {
			if (hMap.get(c1)==1) {
				break;
			}
			index++;
		}
		if (index==str.length()) 
			return '#';
		
		return str.charAt(index);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstAppearingOnce a = new FirstAppearingOnce("google");
		System.out.println(a.FirstAppearOnce());
	}

}
