package firstStep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

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
		Collections.reverse(aList);//翻转ArrayList
		System.out.println(aList);
		
		LinkedHashSet<Integer> aHashSet = new LinkedHashSet<Integer>();
		aHashSet.add(3);
		aHashSet.add(2);
		aHashSet.add(3);
		aHashSet.add(1);
		aHashSet.add(4);
//		System.out.println(aHashSet.toString());
		Iterator<Integer> itor = aHashSet.iterator();
		while (itor.hasNext()) {
			System.out.println(itor.next());
		}
		TreeSet<Integer> bTreeSet = new TreeSet<Integer>();
		bTreeSet.add(3);
		bTreeSet.add(2);
		bTreeSet.add(3);
		bTreeSet.add(1);
		bTreeSet.add(4);
		System.out.println(bTreeSet.toString());
	}

}
