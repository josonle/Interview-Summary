package Coding190507;

/**
 * @author josonlee
 * Topic24：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class swapNodesInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode cur = head;
		for(int i=2;i<2;i++) {
			ListNode tmp = new ListNode(i);
			cur.next = tmp;
			cur = tmp;
		}
//		while(head!=null) {
//			System.out.println(head.val);
//			head = head.next;
//		}
		ListNode newHead = new swapNodesInPairs().solution(head);
		while(newHead!=null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}
	//第一个想到的就这个，但题中写了不能只是交换节点的值
	public ListNode swapPairs(ListNode head) {
        if(head==null) return head;
        ListNode cur = head;
        while(cur!=null&&cur.next!=null){
            ListNode next = cur.next;
            int tmp = next.val;
            next.val = cur.val;
            cur.val = tmp;
            cur = next.next;
        }
        return head;
    }
	
	public ListNode solution(ListNode head) {
		if(head==null) return head;
		ListNode cur = head;
		ListNode newHead = new ListNode(-1),flag = newHead;//作哨兵
		newHead.next = head;
		while(cur!=null&&cur.next!=null) {
			ListNode pre = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			flag.next = pre;
			flag = cur;
			cur = cur.next;
		}
		return newHead.next;
	}
}
