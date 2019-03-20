package Leetcode.ListSolution;

//Definition for doubly-linked list listNode.
class DoublyListNode {
	int val;
	DoublyListNode next, prev;

	DoublyListNode(int x) {
		val = x;
	}
}

class DoubleList {
	private DoublyListNode head;
	private DoublyListNode tail;
	private int size;

	public DoubleList() {
		head = null;
		tail = null;
	}

	// 获取链表长度
	public int getLength() {
		return size;
	}

	// 是否含有元素
	public boolean isEmpty() {
		return size == 0;
	}

	// 清空链表
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	// 头插入
	public void addAtHead(int element) {
		DoublyListNode node = new DoublyListNode(element);
		if (head == null) {
			head = node;
			tail = head;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		size++;
	}

	// 尾插入
	public void addAtTail(int element) {
		DoublyListNode node = new DoublyListNode(element);
		if (head == null) {
			head = node;
			tail = head;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		size++;
	}
	
	//打印
	public void print() {
		DoublyListNode cur = head;
		while(cur!=null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
}

//Definition for singly-linked listNode.
class SinglyListNode {
	int val;
	SinglyListNode next;

	SinglyListNode(int x) {
		val = x;
	}
}

class SingleList<T> {
	private SinglyListNode head; // 头结点
	private SinglyListNode tail; // 尾结点
	private int size; // 链表长度

	public SingleList() {
		head = null;
		tail = null;
	}

	// 获取链表长度
	public int getLength() {
		return size;
	}

	// 是否含有元素
	public boolean isEmpty() {
		return size == 0;
	}

	// 清空链表
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	// 头插入
	public void addAtHead(int element) {
		SinglyListNode node = new SinglyListNode(element);
		// 如果是空链表，尾指针指向头指针
		if (head == null) {
			head = node;
			tail = head;
		} else {
			node.next = head;
			head = node;// 头指针前移
		}
		size++;
	}

	// 尾插入
	public void addAtTail(int element) {
		// 如果空
		if (head == null) {
			head = new SinglyListNode(element);
			tail = head;
		} else {
			SinglyListNode node = new SinglyListNode(element);
			tail.next = node;
			tail = node; // 尾节点后移
		}
		size++;
	}
	
	//打印
		public void print() {
			SinglyListNode cur = head;
			while(cur!=null) {
				System.out.println(cur.val);
				cur = cur.next;
			}
		}
}