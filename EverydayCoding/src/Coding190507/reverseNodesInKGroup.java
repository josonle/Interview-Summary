package Coding190507;

/**
 * @author josonlee
 *         Topic25：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *         给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。 k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k
 *         的整数倍，那么将最后剩余节点保持原有顺序。 要求： 只能使用常数的额外空间，不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 */
public class reverseNodesInKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode cur = head;
		for(int i=2;i<=8;i++) {
			ListNode tmp = new ListNode(i);
			cur.next = tmp;
			cur = tmp;
		}
		ListNode newHead = new reverseNodesInKGroup().reverseKGroup(head, 8);
		while(newHead!=null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}
	/**
	 * 我思路是用count标志每k个节点内翻转链表，会用一个flag标志指示上一段链表最后一个点
	 * 剩余不足k时，先翻转后判断，成立的话把不足部分再翻一次
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null) return head;
		ListNode newHead = new ListNode(-1),flag = newHead;
		newHead.next = head;
		ListNode cur = head;
		int count = 1;
		while(cur!=null&&cur.next!=null) {
			ListNode pre = cur.next;
			cur.next = pre.next;//pre不为null所以这里没问题
			pre.next = head;
			head = pre;
			flag.next = head;
			count++;
			if(count==k) {
				flag = cur;
				cur = cur.next;
				head = cur;
				count  = 1;
//				System.out.println("flagnext:"+flag.next.val);
			}
		}
		if(count>0) {//小于k个节点再翻转回去
			ListNode p = flag.next,h = p;
//			System.out.println(flag.val+"-:"+flag.next.val);
//			System.out.println(cur.val);
			while(p!=null&&p.next!=null) {
				ListNode pre = p.next;
				p.next = pre.next;//pre不为null所以这里没问题
				pre.next = h;
				h = pre;
				flag.next = h;
			}
		}
		return newHead.next;
	}
}
