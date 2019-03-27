package 剑指Offer.Link;

/**
 * @author josonlee
 * @title 删除有序链表中重复节点，像0-1-1-1-1-2，返回0-2
 */
public class DeleteDuplication {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = new ListNode(1);
		ListNode n1 = new ListNode(1);
		node.next = n1;
		ListNode node2 = new ListNode(1);
		n1.next = node2;
		ListNode n3 = new ListNode(1);
		node2.next = n3;
		n3.next = null;
		ListNode result = deleteDuplication(node);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public static ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null)
			return pHead;
		ListNode first = new ListNode(-1);
		first.next = pHead;
		ListNode cur = pHead;
		ListNode pre = first;
		while (cur != null && cur.next != null) {
			ListNode tmp = cur.next;
			if (cur.val == tmp.val) {
				while (tmp.next != null && tmp.val == cur.val) {// 判断重复
					tmp = tmp.next;
				}
				if(tmp.next==null&&tmp.val==cur.val) {
					pre.next = null;
					break;
				}
				pre.next = tmp;
				cur = pre.next;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return first.next;
	}
}
