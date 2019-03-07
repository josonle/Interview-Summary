package firstStep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(1);
		aList.add(2);
		aList.add(3);
		aList.add(2);
		
		System.out.println(aList.toString());
		/*
		 * int length = aList.size(); for (int i = 0; i < length; i++) {
		 * aList.remove(0); System.out.println("aList"+aList.toString()+i); }
		 */
		ArrayList<Integer> bList = (ArrayList<Integer>)aList.clone();
		aList.remove((Object)2);
		System.out.println(aList.toString());
		aList.remove((Object)2);
		System.out.println(aList.toString());
		System.out.println(bList.toString());
		bList.remove(2);
		bList.remove(2);
		System.out.println(bList.toString());
	}

}
