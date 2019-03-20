package Leetcode.ListSolution;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyListNode h1 = new SinglyListNode(5), cur = h1;
		cur.next = new SinglyListNode(9);
		cur = cur.next;
		cur.next = new SinglyListNode(3);
		SinglyListNode h2 = new SinglyListNode(5);
		cur = h2;
		cur.next = new SinglyListNode(6);
		cur = cur.next;
		cur.next = new SinglyListNode(6);
		SinglyListNode result = new AddTwoNumbers().addTwoNumber(h1, h2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public SinglyListNode addTwoNumber(SinglyListNode l1, SinglyListNode l2) {
        SinglyListNode p = l1, q = l2;
        SinglyListNode h = new SinglyListNode(0);
        SinglyListNode cur = h;
        int flag = 0;//进位
        while(p!=null||q!=null){//就不把链更长的分出来讨论
            int pVal = p==null?0:p.val;
            int qVal = q==null?0:q.val;
            int tmp = pVal+qVal+flag;
            flag = tmp>=10 ? 1 : 0;
            cur.val = tmp%10;
            System.out.println(flag+","+tmp+","+cur.val);
            p = p==null? null : p.next;
            q = q==null? null : q.next;
            if(p!=null||q!=null){
                cur.next = new SinglyListNode(0);
                cur = cur.next;
            }
        }
        if(flag==1){
            cur.next = new SinglyListNode(1);
        }
        return h;
    }
}
