package Leetcode.ListSolution;

/**
 * @author josonlee
 * @title 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数
 * 
输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
 */
public class RotateRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyListNode h1 = new SinglyListNode(1), cur = h1;
		cur.next = new SinglyListNode(2);
		cur = cur.next;
		cur.next = new SinglyListNode(3);
		cur = cur.next;
		cur.next = new SinglyListNode(4);
		cur = cur.next;
		cur.next = new SinglyListNode(5);
		cur = new RotateRight().rotateRight(h1, 3);
		while(cur!=null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}

	public SinglyListNode rotateRight(SinglyListNode head, int k) {
        if(head==null||head.next==null)
            return head;
        int len = 0;
        SinglyListNode h = head,p = head;
        while(h!=null){
            len++;
            h = h.next;
        }
        int n = k%len;
        if(n==0)//实际没有移动
            return head;
        while(len-n>1){
            p = p.next;
            len--;
        }
        SinglyListNode tmp = p.next;//列表分段
        p.next = null;
        //有一点注意了，后面那段没有翻转，先开始纸上画的翻转了，无语没看清题
        SinglyListNode anotherHead =tmp;
        while(tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = head;
        return anotherHead;
    }
}
