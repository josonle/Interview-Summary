package 剑指Offer.String;

import java.util.regex.Pattern;

public class isNumeric {

	public static boolean isNumeric(char[] str) {
        String pattern = "(\\+|\\-)?[0-9]*(\\.*[0-9]*)?([eE][\\+\\-]?[0-9]+)?";
        String p = "[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?";
        return Pattern.matches(pattern,String.valueOf(str));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isNumeric("-233e".toCharArray()));
	}

}
