package Leetcode.TreeSolution;

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
	
	public static void main(String[] args) {
		int[] arr = {4,2,6,5,7,3,1};
		BSTree<Integer> bsTree = new BSTree<Integer>();
		for (int i : arr) {
			bsTree.insert(i);
		}
		bsTree.breadthTravel();//4-2-6-1-3-5-7-
		System.out.println("\n前序遍历...");//4-2-1-3-6-5-7-
		bsTree.preOrder(bsTree.getRootNode());
		System.out.println("\n非递归前序遍历...");
		bsTree.noRecurPreOrder(bsTree.getRootNode());
		System.out.println("\n中序遍历...");
		bsTree.inOrder(bsTree.getRootNode());
		System.out.println("\n非递归中序遍历...");
		bsTree.noRecurInOrder(bsTree.getRootNode());
		System.out.println("\n递归后序遍历...");
		bsTree.postOrder(bsTree.getRootNode());
		if (bsTree.remove(4)) {
			System.out.println("5 删除OK");
			bsTree.breadthTravel();
		}
		int[] arr1 = {2,8,6,5,9,7,3,10};
		BSTree<Integer> bstTest = new BSTree<Integer>();
		for (int i : arr1) {
			bstTest.insert(i);
		}
		bstTest.breadthTravel();//2-8-6-9-5-7-3-
		System.out.println("\n");
		if (bstTest.remove(9)) {
			System.out.println("删除 OK");
			bstTest.breadthTravel();
			System.out.println("\n前序遍历...");//4-2-1-3-6-5-7-
			bstTest.preOrder(bstTest.getRootNode());
		}
		bstTest.insert(9);
		System.out.println("\n********");
		System.out.println(bstTest.search(10).left.val);
		System.out.println("Max val is "+bstTest.findMaxMinVal(true));
	}
}
