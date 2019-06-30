package treeStructure;

public class TreeNode {
	private String value;
	private int count = 1;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(String value) {
		this.value = value;
		right = null;
		left = null;
	}
	
	public void increaseCount() {
		count++;
	}
	
	public void printNode() {
		System.out.println("Value: " + value + "| Count: " + count);
	}
	
	public void setValue(String value) {
		this.value = value;
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
	
	public String getValue() {
		return value;
	}
}
