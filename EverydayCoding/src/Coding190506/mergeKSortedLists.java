package Coding190506;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author josonlee
 *         Topic27：https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *         合并k个排序列表
 */
public class mergeKSortedLists {

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			// TODO Auto-generated constructor stub
			this.val = x;
		}
	}
	/**
	 * 堆排序，建立含n个元素的最小堆，每次取出堆顶并将堆顶的next放入堆比较下一轮
	 * @param lists
	 * @return
	 * 
	 * 时间复杂度O(klogn)，k是链表中节点总个数，n是堆的大小
	 */
	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new ListNode(0);
		ListNode tmp = head;
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}
		});
		for (ListNode node : lists) {
			if(node!=null)//要判空避免有空list的存在
				minHeap.add(node);
		}
		while(!minHeap.isEmpty()) {
			tmp.next = minHeap.poll();
			tmp = tmp.next;
			if(tmp.next!=null)
				minHeap.add(tmp.next);
		}
		return head.next;
	}
	/**
	 * 这个是在两两排序链表合并的继承上展开的，归并思想
	 * 时间复杂度O(nklogk)，k是链表个数，假设每个链表都有n个节点
	 * 合并第一次要合并k/2次，每次遍历2n个节点，第二次是合并k/4次，每次遍历4n个节点
	 * 所以合并一次要遍历kn个点，循环logk次，所以总的时间复杂度O(nklogk)
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) return null;
        int l = 0, r = lists.length - 1;
        while (l < r) {
            int mid = (l + r - 1) / 2;
            for (int i = 0; i <= mid; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[r-i]);
            }
            r = (l + r) / 2;
        }
        return lists[0];
    }
	//合并两个排序列表，时间复杂度O(n+m)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0), head = h;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                h.next = l2;
                l2 = l2.next;
            } else {
                h.next = l1;
                l1 = l1.next;
            }
            h = h.next;
        }
        if (l1 == null)
            h.next = l2;
        if (l2 == null)
            h.next = l1;
        return head.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((3/2));
	}

}
