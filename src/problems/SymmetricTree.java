package problems;

public class SymmetricTree {
	
	public static boolean isSym(TreeNode root) {
		return isSymHelper(root.left , root.right);
	}
	
	private static boolean isSymHelper(TreeNode left, TreeNode right) {
		//if both null then they are symmetric
		if(left == null && right == null) return true;
		//if either is null then its not symmetric
		if(left == null || right == null) return false;
		
		//finally check value and recursive call
		return left.value.equals(right.value) 
				&& isSymHelper(left.left , right.right) 
				&& isSymHelper(left.right, right.left);
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(5);
		root.left = new TreeNode<Integer>(2);
		root.right = new TreeNode<Integer>(2);
		
		root.left.left = new TreeNode<Integer>(3);
		root.right.right = new TreeNode<Integer>(3);
		System.out.println(isSym(root));
	}

}
