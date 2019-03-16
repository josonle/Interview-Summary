package Test313;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = new String("abc");
		String str2 = new String("abc");
		System.out.println(str1.hashCode()+" "+str2.hashCode());//hashCode相等
		System.out.println(str1==str2);//false，String重写了hashCode方法，由String的内容决定而非地址
		char c = '0';
	}

}
