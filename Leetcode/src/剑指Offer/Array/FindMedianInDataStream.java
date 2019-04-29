package 剑指Offer.Array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author josonlee 获取数据流中的中位数（所谓数据流即数据是不断输入的）
 * 划分成两组数据，其实就是用堆来控制两边数据数量，像依次输入1,5,6,66,2,7
 * 流程如下（max指代maxHeap，min同理）：
 * max：1，min：
 * max：1、5，min：；max：1，min：5
 * max：1、2，min：5
 * max：1、2、66，min:5；max：1、2，min:5、66
 * max：1、2、2，min：5、66
 * max：1、2、2、7，min：5、66；1、2、2，min：5、7、66
 * 从中可知调整后max.size和min.size之差只有0和1两种，中位数也容易求出
 */
public class FindMedianInDataStream {
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();// 默认是最小堆
	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	});

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr = {1,5,2,66,2,7};
		// for (int i : arr) {
		// maxHeap.add(i);
		// minHeap.add(i);
		// }
		// System.out.println(maxHeap.peek());
		// System.out.println(minHeap.peek());
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			System.out.println(addNum(in.nextInt()));
		}
	}

	public static double addNum(int num) {
		maxHeap.add(num);
		int tmp = maxHeap.size() - minHeap.size();
		if (tmp > 1) {
			minHeap.add(maxHeap.poll());
		}
		if (tmp == 1) {
			if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
				// 交换，确保maxHeap中所有元素都小于minHeap中元素
				// 前提是两个堆都有数据
				maxHeap.add(minHeap.poll());// 此时maxHeap的堆顶不变
				minHeap.add(maxHeap.poll());
			}
		}
		// 不可能小于1
		return findMedian();
	}

	public static double findMedian() {
		if (maxHeap.size() == minHeap.size())
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		if (maxHeap.size() - minHeap.size() == 1)
			return maxHeap.peek();
		return 0;
	}
}
