package tree;

import queue.Q_using_LinkedList;

public class Tree<T> {

	private TreeNode<T> root = null;

	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}

	public Tree(TreeNode<T> root) {
		super();
		this.root = root;
	}

	public Tree() {
		super();
	}

	public TreeNode<T> add(T data) throws Exception {
		if (this.root == null) {
			this.root = new TreeNode<>(data);
			return this.root;
		} else {
			Q_using_LinkedList<T> que = new Q_using_LinkedList<>();
			que.enqueue((T) getRoot());
			while (!que.isEmpty()) {
				TreeNode<T> currNode = (TreeNode<T>) que.dequeue();
				if (currNode.getLeft() != null) {
					que.enqueue((T) currNode.getLeft());
				} else {
					currNode.setLeft(new TreeNode<>(data));
					break;
				}
				if (currNode.getRight() != null) {
					que.enqueue((T) currNode.getRight());
				} else {
					currNode.setRight(new TreeNode<>(data));
					break;
				}
			}
		}
		this.root.printTreeNode();
		return getRoot();
	}

	public void printTree() throws Exception {
		Q_using_LinkedList que = new Q_using_LinkedList<>();
		TreeNode<T> currTreeNode = getRoot();
		while (currTreeNode != null) {
			System.out.println("  " + currTreeNode.getData());
			System.out.println("/ \\");
			if (currTreeNode.getLeft() == null) {
				System.out.println(currTreeNode.getLeft());
			} else {
				que.enqueue(currTreeNode.getLeft());
				System.out.println(currTreeNode.getLeft().getData());
			}
			if (currTreeNode.getRight() == null) {
				System.out.println(currTreeNode.getRight());
			} else {
				que.enqueue(currTreeNode.getRight());
				System.out.println(currTreeNode.getRight().getData());
			}
			currTreeNode = (TreeNode<T>) que.dequeue();
		}
	}
}
