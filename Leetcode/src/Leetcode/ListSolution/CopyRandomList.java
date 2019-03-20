package Leetcode.ListSolution;

import java.util.HashMap;

/**
 * @author josonlee
 * @title 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。 
 * 
 */
public class CopyRandomList {
	
	class Node {
	    public int val;
	    public Node next;
	    public Node random;
	    public Node() {}
	    public Node(int _val,Node _next,Node _random) {
	        val = _val;
	        next = _next;
	        random = _random;
	    }
	}
	public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        HashMap<Node,Node> map = new HashMap();
        Node p = new Node(head.val,null,null);
        Node h = p;
        while(head.next!=null){
            p.next = new Node(head.next.val,null,null);
            map.put(head,p);
            p = p.next;
            head = head.next;
        }
        map.put(head,p);
        for(Node n:map.keySet()){//复制随机指针
            map.get(n).random = map.get(n.random);//n.random要么指向某个节点，要么指向空。前者在p中有对应，后者返回null
        }
        return h;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
