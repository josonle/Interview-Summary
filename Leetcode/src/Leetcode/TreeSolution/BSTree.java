package Leetcode.TreeSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author josonlee
 * @category Binary Search Tree 二叉搜索树
 * @since 19-03-22
 */
public class BSTree<T extends Comparable<T>> {
	// 定义节点类
	public class TNode<T extends Comparable<T>> {
		T val;
		TNode<T> left, right, parent;// 定义左右子节点、父节点

		public TNode(T val, TNode<T> left, TNode<T> right, TNode<T> parent) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.parent = parent;
			HashMap<TNode<T>, Boolean> m = new HashMap();
		}
	}

	private TNode<T> root;// 定义根节点
	
	public TNode<T> getRootNode() {
		return root;
	}

	public void breadthTravel() {
		TNode<T> tmpNode = root;
		LinkedList<TNode<T>> queue = new LinkedList<BSTree<T>.TNode<T>>();
		queue.offer(tmpNode);
		while(!queue.isEmpty()) {
			TNode<T> curNode = queue.poll();
			System.out.print(curNode.val+"-");
			if(curNode.left!=null)
				queue.offer(curNode.left);
			if(curNode.right!=null)
				queue.offer(curNode.right);
		}
	}
	
	/**
	 * 深度遍历
	 * 递归遍历，前中后（parent节点是前、中，还是最后访问）
	 * @param node
	 */
	public void preOrder(TNode<T> node) {
		if (node != null) {
			System.out.print(node.val+"-");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	public void inOrder(TNode<T> node) {
		if(node!=null) {
			inOrder(node.left);
			System.out.print(node.val+"-");
			inOrder(node.right);
		}
	}
	public void postOrder(TNode<T> node) {
		if(node!=null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.val+"-");
		}
	}
	
	/**
	 * 非递归遍历，前中后
	 * @param node
	 */
	public void noRecurPreOrder(TNode<T> node) {
		//通过栈FIFO性质，先弹栈访问node，再将node.right、node.left先后压栈
		Stack<TNode<T>> treeStack = new Stack<BSTree<T>.TNode<T>>();
		if(node==null)
			return;
		treeStack.push(node);
		while(!treeStack.isEmpty()) {
			TNode<T> tmpNode = treeStack.pop();//弹出尾访问
			System.out.print(tmpNode.val+"-");
			if(tmpNode.right!=null)
				treeStack.push(tmpNode.right);//压右
			if(tmpNode.left!=null)
				treeStack.push(tmpNode.left);//压左
		}
	}
	
	public void noRecurInOrder(TNode<T> node) {
		Stack<TNode<T>> treeStack = new Stack<BSTree<T>.TNode<T>>();
		TNode<T> tmpNode = node;
		while(tmpNode!=null||!treeStack.isEmpty()) {
			while(tmpNode!=null) {//只要有左子节点，就遍历压栈左节点
				treeStack.push(tmpNode);
				tmpNode = tmpNode.left;
			}
			//当前路径左节点都已入栈，弹出最后那个并访问
			tmpNode = treeStack.pop();
			System.out.print(tmpNode.val+" ");
			//指向当前节点右子节点，继续重复压栈左节点
			//无右子节点的话，弹栈，回退到上一个压入的父节点
			tmpNode = tmpNode.right;
		}
	}
	
	public void convertToLinkedlist(TNode<T> node) {
		if(node==null)
			return ;
		TNode<T> head= new TNode(-1, null, null, null);
		TNode<T> pre = head;
		Stack<TNode<T>> treeStack = new Stack<BSTree<T>.TNode<T>>();
		TNode<T> tmpNode = node;
		while(tmpNode!=null||!treeStack.isEmpty()) {
			while(tmpNode!=null) {
				treeStack.push(tmpNode);
				tmpNode = tmpNode.left;
			}
			tmpNode = treeStack.pop();
			pre.right = tmpNode;
			tmpNode.left = pre;
			tmpNode = tmpNode.right;
			pre = pre.right;
		}
		//双向打印，看是否是双链表
		head = head.right;
		while(head!=null) {
			System.out.println(head.val);
			head = head.right;
		}
		while(pre!=null) {
			System.out.println(pre.val);
			pre = pre.left;
		}
	}
	public void noRecurPostOrder(TNode<T> node) {
		
	}
	/**
	 * 二叉搜索树查找
	 * @param key
	 * @return TNode
	 */
	public TNode<T> search(T key) {
		if(root==null)
			return null;
		TNode<T> tmpNode = root;
		while(tmpNode!=null) {
			int cmp = key.compareTo(tmpNode.val);
			if (cmp>0) {//key比当前节点值大
				tmpNode = tmpNode.right;
			}else if (cmp==0) {
				return tmpNode;
			}else {
				tmpNode = tmpNode.left;
			}
		}
		return tmpNode;
	}
	/**
	 * 
	 * @param flag，true->查找最大值，相反查找最小值
	 * @return val
	 */
	public T findMaxMinVal(boolean flag) {
		TNode<T> tmpNode = root;
		if (tmpNode==null) {
			return null;
		}
		if (flag) {
			//最大值只可能在右子节点出现
			while(tmpNode.right!=null)
				tmpNode = tmpNode.right;
			return tmpNode.val;
		}else {
			//同理，只查找左节点
			while(tmpNode.left!=null)
				tmpNode = tmpNode.left;
			return tmpNode.val;
		}
	}
	
	public boolean insert(T key) {
		TNode<T> tmpNode = new TNode<T>(key, null, null, null);
		TNode<T> curNode = root;
		TNode<T> flagNode = root ;
		int cmp = 0;
		while(curNode!=null) {
			cmp = key.compareTo(curNode.val);
			if (cmp>0) {
				flagNode = curNode;
				curNode = curNode.right;
			}else if (cmp<0) {
				flagNode = curNode;
				curNode = curNode.left;
			}else {
				System.out.println("Key有重复值，返回false退出");
				return false;
			}
		}
		if(root==null)
			root = tmpNode;
		if(cmp>0) {//tmpNode比flag大，插右
			flagNode.right = tmpNode;
			tmpNode.parent = flagNode;
		}
		if(cmp<0){
			flagNode.left = tmpNode;
			tmpNode.parent = flagNode;
		}
		return true;
	}
	
	/**
	 * 删除val为key的节点，返回boolean
	 * @param key
	 * @return val
	 */
	public boolean remove(T key) {
		TNode<T> tmNode = search(key);
		if (tmNode==null) {
			System.out.println("BST 不含有该节点");
			return false;
		}
		if (tmNode.left==null&&tmNode.right==null) {//刚好是叶节点
			TNode<T> pNode = tmNode.parent;
			if (key.compareTo(pNode.val)>0) {//判断是删除左还是右叶子节点
				pNode.right=null;
			}else {
				pNode.left=null;
			}
			return true;
		}
		TNode<T> curNode;
		//根节点也包含在这里面
		if (tmNode.left==null) {//左子树为空，找寻右子树的最小节点
			curNode = tmNode.right;
			while(curNode.left!=null)
				curNode = curNode.left;
			//交换值，删除左叶子节点
			tmNode.val = curNode.val;
			if(curNode==tmNode.right) {//最大值刚好是tmNode.left
				tmNode.right = curNode.right;
				return true;
			}
			if(curNode.right!=null) {//保证cur.right节点不会被删
				curNode.parent.left = curNode.right;
				curNode.right.parent = curNode.parent;
			}else {
				curNode.parent.left = null;
			}
		}else {//左子树非空，找寻左子树的最大值替换
			curNode = tmNode.left;
			while(curNode.right!=null)
				curNode = curNode.right;
			//交换值，删除右叶子节点
			tmNode.val = curNode.val;
			if(curNode==tmNode.left) {//最大值刚好是tmNode.left
				tmNode.left = curNode.left;
				return true;
			}
			if(curNode.left!=null) {//保证cur.left节点不会被删
				curNode.parent.right = curNode.left;
				curNode.left.parent = curNode.parent;
			}else {
				curNode.parent.right = null;
			}
		}
		return true;
	}
	 /**
	  * S型打印二叉树
	  * 两个栈，stack[0]保存奇数层，stack[1]保存偶数层
	  */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void printSBST() {
		if(root==null)
			return;

		Stack<TNode<T>> st1 = new Stack<BSTree<T>.TNode<T>>();//保存奇数层元素
		Stack<TNode<T>> st2 = new Stack<BSTree<T>.TNode<T>>();//保存偶数层元素
		Stack[] stacks = {st1,st2};
		int cur = 0, next = 1;
		
		stacks[cur].push(root);
		while(!stacks[0].isEmpty()||!stacks[1].isEmpty()) {
			TNode<T> tmpNode = (TNode<T>)stacks[cur].pop();
			System.out.print(tmpNode.val+"-");
			if(cur==0) {//奇数层，先压右再压左
				if(tmpNode.right!=null)
					stacks[next].push(tmpNode.right);
				if(tmpNode.left!=null)
					stacks[next].push(tmpNode.left);
			}else {
				if(tmpNode.left!=null)
					stacks[next].push(tmpNode.left);
				if(tmpNode.right!=null)
					stacks[next].push(tmpNode.right);
			}
			if(stacks[cur].isEmpty()) {//一层节点遍历完了，比如cur=0完了，切换到cur=1
				cur = 1-cur;
				next = 1-next;
			}
		}
	}
	
	/**
	 * 打印出二叉树中结点值的和为输入整数target的所有路径(从根节点开始)
	 * @param root
	 * @param target，强制为int
	 * @return ArrayList<ArrayList<Integer>>
	 */
	public ArrayList<ArrayList<Integer>> FindPath(TNode root,int target) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList();
        if(root==null||target<(int)root.val)
            return arr;
        find(arr,new ArrayList<Integer>(),root,target);
        return arr;
    }
	public void find(ArrayList<ArrayList<Integer>> arr,ArrayList<Integer> path,TNode node,int target){
        
		path.add((int)node.val);
        if(node.left==null&&node.right==null){//遍历到叶子
            if(target==(int)node.val)
                arr.add(path);
            return;
        }
        ArrayList<Integer> path2 = new ArrayList();
        path2.addAll(path);
        if(node.left!=null)//判断左，target变成了减掉当前节点值后的target
            find(arr,path,node.left,target-(int)node.val);
        if(node.right!=null)//判断右
            find(arr,path2,node.right,target-(int)node.val);
    }
	public static void main(String[] args) {
//		int[] arr = {4,2,6,5,7,3,1};
//		BSTree<Integer> bsTree = new BSTree<Integer>();
//		for (int i : arr) {
//			bsTree.insert(i);
//		}
//		bsTree.breadthTravel();//4-2-6-1-3-5-7-
//		System.out.println("\n前序遍历...");//4-2-1-3-6-5-7-
//		bsTree.preOrder(bsTree.getRootNode());
//		System.out.println("\n非递归前序遍历...");
//		bsTree.noRecurPreOrder(bsTree.getRootNode());
//		System.out.println("\n中序遍历...");
//		bsTree.inOrder(bsTree.getRootNode());
//		System.out.println("\n非递归中序遍历...");
//		bsTree.noRecurInOrder(bsTree.getRootNode());
//		System.out.println("\n递归后序遍历...");
//		bsTree.postOrder(bsTree.getRootNode());
//		if (bsTree.remove(4)) {
//			System.out.println("5 删除OK");
//			bsTree.breadthTravel();
//		}
		int[] arr1 = {2,8,6,4,9,7,3,10,0,1};
		BSTree<Integer> bstTest = new BSTree<Integer>();
		for (int i : arr1) {
			bstTest.insert(i);
		}
//		System.out.println("\n层次遍历");
//		bstTest.breadthTravel();//2-8-6-9-5-7-10-3-
//		System.out.println("\nS型打印");
//		bstTest.printSBST();//2-8-9-6-5-7-10-3-
//		if (bstTest.remove(9)) {
//			System.out.println("\n删除 OK");
//			bstTest.breadthTravel();
//			System.out.println("\n前序遍历...");//4-2-1-3-6-5-7-
//			bstTest.preOrder(bstTest.getRootNode());
//		}
//		bstTest.insert(9);
//		System.out.println("\n********");
//		System.out.println(bstTest.search(10).left.val);
//		System.out.println("Max val is "+bstTest.findMaxMinVal(true));
//		bstTest.convertToLinkedlist(bstTest.getRootNode());
		ArrayList<ArrayList<Integer>> arr2 = bstTest.FindPath(bstTest.getRootNode(), 23);
		System.out.println(arr2.size());
		System.out.println(arr2.get(0).size());
		System.out.println(arr2.get(1).size());
		System.out.println("******");
		for(int val:arr2.get(0)) {
			System.out.print(val+"-");
		}
	}
}
