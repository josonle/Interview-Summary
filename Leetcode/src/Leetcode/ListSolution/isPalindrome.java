package Leetcode.ListSolution;

/**
 * @author josonlee
 * @title 判断回文链表与否，1-2-2-1是回文链表
 * 要求用 O(n) 时间复杂度和 O(1) 空间复杂度
 * 
 * 快慢指针找中点，然后翻转后一段比较
 */
public class isPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(SinglyListNode head) {
        if(head==null||head.next==null)
            return true;
        
        SinglyListNode fast = head,slow = head;
        while(fast!=null&&fast.next!=null){// 找到中点slow
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast==null){// 偶
            slow = reverseList(slow);
        }else{// 奇
            slow = reverseList(slow.next);
        }
        while(slow!=null){
            if(head.val!=slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    
    public SinglyListNode reverseList(SinglyListNode head){
        if(head==null||head.next==null)
            return head;
        SinglyListNode p = head.next,q = head;
        while(p!=null){
            SinglyListNode flag = p.next;
            q.next = flag;
            p.next = head;
            head = p;
            p = flag;
        }
        return head;
    }
}
