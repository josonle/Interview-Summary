package Test317;

import java.util.Random;

public class Test1 {

	public static void main(String[] args) {
		new Test1().version("0.123", "0.1");
	}
	
	public void version(String str1,String str2) {
		int index1 = str1.indexOf('.');
		int index2 = str2.indexOf('.');
//		System.out.println(str2.substring(0, index2));
		int flag = Integer.parseInt(str1.substring(0,index1))-Integer.parseInt(str2.substring(0,index2));
		if (flag>0) {
			System.out.println("1");
		}else if (flag<0) {
			System.out.println("-1");
		}else {
			int tmp = Integer.parseInt(str1.substring(index1+1))-Integer.parseInt(str2.substring(index2+1));
			if(tmp>0)
				System.out.println("1"+"-"+tmp);
			else if (tmp<0) {
				System.out.println("-1"+"-"+tmp);
			}else {
				System.out.println("0");
			}
		}
//		System.out.println(Integer.parseInt(strArray1[0])-Integer.parseInt(strArray2[0]));
	}
}
