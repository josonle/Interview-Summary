package 剑指Offer.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author josonlee
 * @title 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * 我之前想法是拼接后位数不变，所以每次拿数第一位比较，依次按位递归下去，最小的数放前面
 */
public class SortArrayToMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3};
		System.out.println(PrintMinNumber(num));
	}
	
	public static String PrintMinNumber(int [] numbers) {
        StringBuffer str = new StringBuffer();
        ArrayList<Integer> arr = new ArrayList();
        for(int n:numbers){
            arr.add(n);
        }
        Collections.sort(arr,new Comparator<Integer>(){
            
            public int compare(Integer a,Integer b){
                String as = a+""+b;
                String bs = b+""+a;
                return as.compareTo(bs);
            }
            
        });
        for(Integer i:arr){
            str.append(i);
        }
        return str.toString();
    }
}
