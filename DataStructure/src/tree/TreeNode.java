package tree;

public class TreeNode<T> {
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode(T data, TreeNode left, TreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public TreeNode() {
		super();
	}

	public TreeNode(T data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public void printTreeNode() {
		System.out.println("data = " + this.data + " ");
		if (this.getLeft() != null) {
			System.out.println("left = " + this.getLeft().getData());
		} else {
			System.out.println("left = " + this.getLeft());
		}
		if (this.getRight() != null) {
			System.out.println("right = " + this.getRight().getData());
		} else {
			System.out.println("right = " + this.getRight());
		}
	}
}
