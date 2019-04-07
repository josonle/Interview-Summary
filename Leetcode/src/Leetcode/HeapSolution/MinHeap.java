package Leetcode.HeapSolution;

import java.util.Arrays;

/**
 * 最小堆性质
 * 1. 是完全二叉树
 * 2. 节点值比子节点值小
 * @author josonlee
 *
 */
public class MinHeap {
	//数组可以有两种方式表示堆中节点下标
	//数组下标从0开始，父节点i，左右子节点下标为2*i+1,2*i+2。反过来子节点k，父节点(k-1)/2
	//数组下标从1开始，父节点i，左右为2*i，2*i+1。反过来子节点k，父节点k/2
	//这里选第一种
	private int[] element;
	private int size;// 当前堆数据数量，不允许扩容
	private static final int DEFAULT_SIZE = 16;// 默认最小堆容量16

	public MinHeap() {
		element = new int[DEFAULT_SIZE];
		size = 0;
	}

	public MinHeap(int size) {
		element = new int[size];
		this.size = 0;
	}

	public int getMin() {
		if (size > 0)
			return element[0];
		else
			throw new IllegalStateException("堆当前为空");
	}

	public void add(int data) {
		if (size < element.length) {
			// 下标为0，但size为1，所以size最后++
			element[size] = data;
			shiftUP(size);// 上浮
			size++;
		} else {// 堆已满，最小堆比较是否比堆顶大，大则插入
			if (data <= getMin()) {
				return;
			} else {
				element[0] = data;
				shiftDown(0);// 下沉
			}
		}
	}

	/**
	 * poll堆顶元素
	 * @return 堆顶元素
	 */
	public int poll() {
		if (size == 0)
			throw new IllegalStateException("当前堆为空");
		int tmp = element[0];
		element[0] = element[size - 1];
		shiftDown(0);
		return tmp;
	}
	/**
	 * 上浮操作，和父节点比较，小的话就交换
	 * @param index
	 */
	public void shiftUP(int index) {
		int i = index;
		int pIndex = (i - 1) / 2;
		while (pIndex >= 0 && element[i] < element[pIndex]) {
			swap(i, pIndex);
			i = pIndex;
			pIndex = (i - 1) / 2;
		}
	}
	/**
	 * 下沉操作，比子节点小的话，首先要分清是否有右子节点，其次是左右子节点谁更小，然后交换
	 * @param index
	 */
	public void shiftDown(int index) {
		int i = index;
		while (2 * i + 1 < size) {// 完全二叉树有柚子树就一定有左子树
			// 判断左节点和右节点谁更小
			int maxIndex = 2 * i + 2 < size && element[2 * i + 2] < element[2 * i + 1] ? 2 * i + 2 : 2 * i + 1;
			if (element[i] > element[maxIndex]) {
				swap(i, maxIndex);
				i = maxIndex;
			} else
				break;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void swap(int i, int j) {
		int tmp = element[i];
		element[i] = element[j];
		element[j] = tmp;
	}
	
	public void print() {
		System.out.println(Arrays.toString(element));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap minHeap = new MinHeap(10);
		minHeap.add(15);
		minHeap.add(17);
		minHeap.add(19);
		minHeap.add(13);
		minHeap.add(22);
		minHeap.add(28);
		minHeap.add(16);
		minHeap.add(33);
		minHeap.add(14);
		minHeap.add(0);
		System.out.println(minHeap.getMin());
		minHeap.print();
		minHeap.add(-1);
		minHeap.print();
		minHeap.add(25);
		System.out.println(minHeap.getMin());
		minHeap.print();
	}

}
