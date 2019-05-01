package Coding190501;

public class reverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-2147483648));
	}

	public static int reverse(int num) {
		if(num==0)
			return 0;
		while(num%10==0) {
			num /= 10;
		}
		System.out.println(num);
		StringBuffer stb = new StringBuffer();
		Long n = 0L;
		if(num>=0) {
			stb.append(num);
			n = Long.parseLong(stb.reverse().toString());
		}else {
			stb.append(-num);
			n = -1*Long.parseLong(stb.reverse().toString());
		}
		if(n>Integer.MAX_VALUE||n<Integer.MIN_VALUE)
			return 0;
		return n.intValue();
	}
}
