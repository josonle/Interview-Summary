package cmb.Coding;


import java.util.Stack;

public class Test04 {
    public static void main(String[] args) {
        SingleList list = new SingleList();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
    }

    public static void result(SinglyListNode node) {
        Stack<Integer> stack = new Stack<>();
        while (node.next != null) {
            stack.add(node.val);
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
