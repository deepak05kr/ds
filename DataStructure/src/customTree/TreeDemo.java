package customTree;

public class TreeDemo {
	public static void main(String args[]) throws Exception {
		Tree binaryTree = new Tree<>();
		binaryTree.add(new TreeNode<>(3));
		binaryTree.add(new TreeNode<>(1));
		binaryTree.printTree();
	}
}
