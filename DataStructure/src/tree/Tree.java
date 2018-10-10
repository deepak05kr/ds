package tree;

import java.util.Queue;

import queue.Q_using_LinkedList;

public class Tree {
	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public Tree(TreeNode root) {
		super();
		this.root = root;
	}

	public void InorderTraversal(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		System.out.println(treeNode.getData());
		InorderTraversal(treeNode.getLeft());
		InorderTraversal(treeNode.getRight());
	}

	public void PreOrderTraversal(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}

		PreOrderTraversal(treeNode.getLeft());
		System.out.println(treeNode.getData());
		PreOrderTraversal(treeNode.getRight());
	}

	public void PostOrderTraversal(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		PreOrderTraversal(treeNode.getLeft());
		PreOrderTraversal(treeNode.getRight());
		System.out.println(treeNode.getData());
	}

	public void add(String data) throws Exception {
		TreeNode newNode = new TreeNode(data);
		if (this.root == null) {
			this.setRoot(newNode);
		} else {
			Q_using_LinkedList<TreeNode> queue = new Q_using_LinkedList<>();
			queue.enqueue(root);
			while (!queue.isEmpty()) {
				TreeNode dequeuedNode = queue.dequeue();
				if (dequeuedNode.getLeft() != null) {
					queue.enqueue(dequeuedNode.getLeft());
				} else {
					dequeuedNode.setLeft(newNode);
					break;
				}
				if (dequeuedNode.getRight() != null) {
					queue.enqueue(dequeuedNode.getRight());
				} else {
					dequeuedNode.setRight(newNode);
				}
			}
		}
	}
}
