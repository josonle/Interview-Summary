package 剑指Offer.Stack;

import java.util.Arrays;
import java.util.Stack;

public class StackSolution {
	private Stack<Integer> stack = new Stack<Integer>();//保存最小值，每次最小则压栈
	private Integer[]  element = new Integer[4];
	private int min = Integer.MAX_VALUE;
	private int size = 0;
	
	public void push(int node) {
        if(node<min) {
        	min = node;
        	stack.push(node);//存最小值
        }
        ensureCapacity(size+1);
        element[size++] = node;
    }
    
	public void ensureCapacity(int len) {
		int size = element.length;
		if(len>size) {
			int newLen = size+(size>>1);
			element= Arrays.copyOf(element, newLen);
		}
	}
    public void pop() {
        Integer tmp = element[size-1];
        if(tmp.equals((Integer)stack.peek())){//要删除的是最小值
        	stack.pop();
        	if(stack.isEmpty()) {
        		min = Integer.MIN_VALUE;
        	}else {
				min = stack.peek();
			}
        }
        element[size-1] = (Integer) null;
        size--;
    }
    
    public Integer top() {
    	if(isEmpty())
    		return (Integer) null;
        return element[size-1];
    }
    
    public boolean isEmpty() {
		return size==0;
	}
    public int min() {
    	return min;
    }
    
    public static void main(String[] args) {
		StackSolution stack = new StackSolution();
		stack.push(10);
		stack.push(7);
		stack.push(8);
		stack.push(3);
		stack.push(5);
		stack.push(1);
		stack.push(2);
//		System.out.println(stack.top());
//		System.out.println(stack.min());
//		stack.pop();
//		System.out.println(stack.top());
//		System.out.println(stack.min());
//		
//		ArrayList<LinkedList<Character>> arr = new ArrayList();
//		LinkedList<Character> c1 = new LinkedList<Character>();
//		c1.add('a');
//		c1.add('d');
//		LinkedList<Character> c2 = new LinkedList<Character>();
//		c1.add('b');
//		c1.add('a');
//		arr.add(c1);
//		arr.add(c2);
//		System.out.print(arr.get(0).getFirst());
	}
}
