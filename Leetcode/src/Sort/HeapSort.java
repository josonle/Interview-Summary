package Sort;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author josonlee
 * 借助java自带的PriorityQueue（默认小顶堆）实现堆排序
 */
public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;//返回-1的话是升序（默认的，即o1-o2）,1的话是降序
			}
		});
		int[] arr = { 8, 34, 64, 51, 33, 22, 44, 55, 88, 1, 0, 2, 2 };
		for (int i : arr) {
			queue.offer(i);
		}
		Iterator<Integer> itor = queue.iterator();
		while (itor.hasNext()) {
			System.out.println((Integer) itor.next());
		}
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
