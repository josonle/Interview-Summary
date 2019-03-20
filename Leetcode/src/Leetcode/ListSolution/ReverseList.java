package Leetcode.ListSolution;

/**
 * @author josonlee
 * @title 翻转链表
 */
public class ReverseList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyListNode h1 = new SinglyListNode(5), cur = h1;
		cur.next = new SinglyListNode(9);
		cur = cur.next;
		cur.next = new SinglyListNode(3);
		SinglyListNode result = reverse(h1);
		System.out.println(h1.val);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public static SinglyListNode reverse(SinglyListNode head){
        if(head==null||head.next==null)
            return head;
        SinglyListNode p = head, q = head.next;
        SinglyListNode r = q;
        // p.next = null;
        while(q.next!=null){
            r = r.next;
            q.next = p;
            p = q;
            q = r;
        }
        q.next = p;
        head.next = null;
        return q;
    }
}
