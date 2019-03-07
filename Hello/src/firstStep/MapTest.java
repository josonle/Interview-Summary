package firstStep;

import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		System.out.println(hm.isEmpty());
		Object nObject = hm.put("a", 1);
		Object mObject = hm.put("a", 2);
		hm.put("lee", 2);
		hm.put("w", 3);
		System.out.println(nObject+","+mObject);//put如果key不存在插入并返回null，存在就更新value返回旧value
		System.out.println(hm.get("a"));
		System.out.println(hm.keySet().toString());
		System.out.println(hm.entrySet().toString());
		System.out.println(hm.containsKey("b"));
		System.out.println(hm.containsValue(1));
		hm.put(null, 1);
		System.out.println(hm.containsKey(null));
	}

}
