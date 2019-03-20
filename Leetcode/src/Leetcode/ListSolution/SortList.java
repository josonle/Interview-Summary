package Leetcode.ListSolution;

class ListNode {
	ListNode next;
	int val;
	public ListNode(int x) {
		// TODO Auto-generated constructor stub
		val = x;
	}
}

/**
 * @author josonlee
 * @title 链表排序，要求时间复杂度O(nlogn)，常数级空间复杂度
 * 
 * 归并排序，如何找到中点，其余同数组一样
 */
public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(4);
		head.next = new ListNode(3);
		head = new SortList().sortList(head);
		while(head!=null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public ListNode sortList(ListNode head) {
		return head == null ? null : mergeSort(head);
	}

	private ListNode mergeSort(ListNode head) {
		if (head.next == null) {
			return head;
		}
		ListNode slow = head, fast = head;
		ListNode tmp = slow;
		while(fast!=null&&fast.next!=null){//找到中点，分段排序
			tmp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
		
//		不能是下面这样的，想想两个节点的情况，tmp永远指向第二个节点
//        ListNode tmp = slow.next;
//        slow.next = null;
		tmp.next = null;
		ListNode l = mergeSort(head);
		ListNode r = mergeSort(slow);
		return merge(l, r);
	}

	ListNode merge(ListNode l, ListNode r) {
		ListNode dummyHead = new ListNode(0);
		ListNode cur = dummyHead;
		while (l != null && r != null) {
			if (l.val <= r.val) {
				cur.next = l;
				cur = cur.next;
				l = l.next;
			} else {
				cur.next = r;
				cur = cur.next;
				r = r.next;
			}
		}
		if (l != null) {
			cur.next = l;
		}
		if (r != null) {
			cur.next = r;
		}
		return dummyHead.next;
	}
}
