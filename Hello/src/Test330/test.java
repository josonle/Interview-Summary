package Test330;

import java.util.ArrayList;
import java.util.Arrays;

public class test {
	public static void main(String[] args) {
//		System.out.println(getK(11, 120));
		//数组和列表转换
//		Integer[] arr = {1,2,3,4,5};//注意这里是Integer，不能是int
//		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
//		System.out.println(list);
//		Integer[] arr1 = list.toArray(new Integer[list.size()]);
//		System.out.println(Arrays.toString(arr1));
		Integer aInteger = new Integer(256);
		Integer bInteger = new Integer(256);
		System.out.println(aInteger.equals(bInteger));
		System.out.println(aInteger==bInteger);
//		System.out.println((int)aInteger-200);
	}
	public static int getK(int m,int n){
		int sum = 0;
        while(m>0) {
        	sum += m%10;
        	m /= 10; 
        }
        while(n>0) {
        	sum += n%10;
        	n /= 10; 
        }
        return sum;
    }
}
