package treeStructure;

public class BinaryTree implements IBinaryTree{
	TreeNode root;
	
	public BinaryTree() {
		root = null;
	}
	
	public TreeNode getRootElement() {
		return root;
	}
	
	public boolean isEmpty() {
		return (root == null);
	}
	
	/*public List<String> iterateInOrder(){
		
	}*/
	
	public void insert(String value) {
		if(isEmpty() == true) {
			root = new TreeNode(value);
			return;
		}
		
		if(valueExists(root,value))
			return;
		
		TreeNode currentnode = root;
		
		while(true) {
			//Alfabetic less, inserting node left in the tree
			if(currentnode.getValue().compareToIgnoreCase(value) > 0) {
				if(currentnode.getLeft() == null) {
					currentnode.setLeft(new TreeNode(value));
					break;
				}
				else
					currentnode = currentnode.getLeft();
				}
			//Alfabetic bigger, inserting node right in the tree
			else if(currentnode.getValue().compareToIgnoreCase(value) < 0) {
				if(currentnode.getRight() == null) {
					currentnode.setRight(new TreeNode(value));
					break;
				}
				else {
					currentnode = currentnode.getRight();
				}
			}	
		}
	}
	
	private boolean valueExists(TreeNode tree, String value) {
		boolean check = false;
		if(tree != null) {
			if(value.equals(tree.getValue())) {
				tree.increaseCount();
				return true;
			}
			
			if(tree.getLeft() != null) {
				check = valueExists(tree.getLeft(), value);
			}
			
			if(check == false) {
				check = valueExists(tree.getRight(), value);
			}
		}
		return check;
	}
	
	public void printInOrder() {
		printInOrder(root);
	}
	
	public void printInOrder(TreeNode currentnode) {
		if( currentnode!= null) {
			printInOrder(currentnode.getLeft());
			currentnode.printNode();
			printInOrder(currentnode.getRight());
		}
	}
}
