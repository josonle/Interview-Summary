package firstStep;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class HelloWorld {
	enum SIZE {
		Max, Min, Media
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(7 / 2. + "," + Math.pow(2, 3));
		double num = 1.23;
		System.out.println((int) num);
		int x = 1;
		x += 1.89;
		System.out.println(x + "," + (int) (1.6));

		System.out.println(String.join(",", "def", "abc", "ghi"));

		if ("abc".equals("abc")) {// if("abc".compareTo("abc")==0)
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		System.out.println("abc".indexOf("d"));
		System.out.println("abc".replace("bc", "aaa"));
		/*
		 * String str = "abc"; switch (str) { case "abc": System.out.println("匹配");
		 * break;
		 * 
		 * default: break; }
		 */
		int flag = 0;
		break_point: while (x < 10) {
			flag++;
			for (int i = 0; i < 5; i++) {
				if (x > 2) {
					x = 0;
					break break_point;
				}
				x++;
			}
		}
		System.out.println("Flag is: "+flag);
		
		BigInteger a = BigInteger.valueOf(100000000000000000l);
		BigInteger b = BigInteger.TEN;
		System.err.println(a.add(b));
		BigDecimal cDecimal = BigDecimal.valueOf(2,10);
		System.out.println(cDecimal);
		int[] list = new int[0];
		System.out.println(list);
		
		int[] list1 = new int[] {1,2,3,4};
		int[] list2 = list1;
		list2[1] = 5;
		System.out.println(Arrays.toString(list1));
		int[] list3 = Arrays.copyOf(list1, 8);
		System.out.println(Arrays.toString(list3));
		for (String i : args) {
			System.out.println(i);
		}
		
	}
}
