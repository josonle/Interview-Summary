package 剑指Offer.Link;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author josonlee
 * @title 从尾到头返回一个ArrayList
 */
public class PrintListFromTailToHead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(0, 1);
		arrayList.add(0,2);
		System.out.println(arrayList.toString());
		Collections.reverse(arrayList);
		System.out.println(arrayList.toString());
	}
	
}
