package Test317;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LinkedList<Integer> link = new LinkedList<Integer>();
//		link.offer(null);
//		link.offerFirst(1);
//		System.out.println(link.indexOf(null));
//		link.set(link.indexOf(null), 2);
//		link.push(3);
//		System.out.println(Arrays.toString(link.toArray()));
//		Vector<Integer> vec = new Vector<Integer>();
//		vec.add(null);
//		vec.add(1);
//		System.err.println(vec.indexOf(null));
		
//		TreeSet<Integer> treeSet1 = new TreeSet<Integer>();
//		treeSet.add(5);
//		treeSet.add(3);
//		treeSet.add(2);
//		treeSet.add(6);
//		treeSet.add(1);
//		TreeSet<Integer> treeSet = new TreeSet<Integer>(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o2-o1;
//			}
//			
//		});
//		treeSet1.add(5);
//		treeSet1.add(3);
//		treeSet1.add(2);
//		treeSet1.add(6);
//		treeSet1.add(1);
//		treeSet1.add(null);
//		for (Integer integer : treeSet1) {
//			System.out.println(integer);
//		}
//		System.out.println("the leaest element lower > 5 :"+treeSet.lower(5)+",floor>=3 :"+treeSet.floor(3));
//		System.out.println("the leaest element lower > 5 :"+treeSet1.lower(5)+",floor>=3 :"+treeSet1.floor(3));
//		NavigableSet<Integer> navigableSet = treeSet.descendingSet();
//		Iterator<Integer> itor = navigableSet.iterator();
//		while(itor.hasNext())
//			System.out.println(itor.next());
//		Set set = Collections.synchronizedNavigableSet(treeSet);
//		HashSet<Integer> set = new HashSet<Integer>();
//		set.add(null);	
//		set.add(1);
//		set.add(5);
//		set.add(7);
//		set.add(2);
//		set.add(300);
//		set.add(150);
//		for (Integer i : set) {
//			System.out.println(i);
//		}
//		System.out.println("**************");
//		LinkedHashSet<Integer> lSet = new LinkedHashSet<Integer>();
//		lSet.add(2);
//		lSet.add(5);
//		lSet.add(6);
//		lSet.add(1);
//		lSet.add(3);
//		for (Integer i : lSet) {
//			System.out.println(i);
//		}
//		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
////		treeMap.put(null, 0);//理论不允许插入null
//		System.out.println(treeMap.descendingKeySet());
		
		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
		hMap.put(null, null);
		System.out.println(hMap.get(null));
		Hashtable<Integer, String> hTable = new Hashtable<Integer, String>();
		hTable.put(1, "1");
		System.out.println(hTable.get(1));
	}
}
