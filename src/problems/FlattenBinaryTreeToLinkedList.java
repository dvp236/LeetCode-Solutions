package problems;

public class FlattenBinaryTreeToLinkedList {
	
	public static void flattenTree(TreeNode node) {

		if (node.left != null) {
			TreeNode temp = node.right;
			node.right = node.left;
			TreeNode rightmost = null;
			TreeNode curr = node.left;
			
			while(curr.right!= null) {
				curr = curr.right;
			}
			curr.right = temp;			
		}
		if (node.right!=null)
			flattenTree(node.right);
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		flattenTree(root);
		TreeNode curr = root;
		while (curr!=null) {
			System.out.println(curr.value);
			curr = curr.right;
		}
		
	}

}
