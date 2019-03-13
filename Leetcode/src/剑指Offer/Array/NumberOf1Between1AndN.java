package 剑指Offer.Array;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author josonlee
 * @title 求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
 */
public class NumberOf1Between1AndN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(NumberOf1Between1AndN_Solution(9999));
	}

	public static int NumberOf1Between1AndN_Solution(int n) {
        int count =0;
        while(n>0){
            count += find(n+"");
            n--;
        }
        return count;
    }
    public static int find(String str){
        Pattern p = Pattern.compile("1");
		Matcher m = p.matcher(str);
		int a = 0;
		while(m.find()) {
			a++;
		}
        return a;
    }
}
