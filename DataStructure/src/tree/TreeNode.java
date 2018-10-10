package tree;

public class TreeNode {
	private String data;
	private TreeNode left;
	private TreeNode right;

	public String getData() {
		return data;
	}

	public void setData(String data) {
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

	public TreeNode(String data, TreeNode left, TreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public TreeNode(String data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}
