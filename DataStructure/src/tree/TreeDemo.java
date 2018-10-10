package tree;

public class TreeDemo {

	public static void main(String args[]) throws Exception {
		TreeNode root = new TreeNode("7");
		Tree tree = new Tree(root);
		tree.add("4");
		tree.add("12");
		tree.add("2");
		tree.add("3");
		tree.add("9");
		tree.add("15");
		tree.InorderTraversal(tree.getRoot());
	}
}
