package problems;

import java.util.HashMap;

public class ConstructBinTreeFromInorderPreorder {
	
	public static TreeNode constructTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(0,0,inorder.length-1,preorder,inorder, map);
	}

	private static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, HashMap<Integer, Integer> map){
		if (preStart > preorder.length-1 || inStart > inEnd) return null;
		
		int val = preorder[preStart];
		TreeNode node = new TreeNode(val);
		
		int inIndex = map.get(val);
		
		node.left = helper(preStart+1, inStart, inIndex-1, preorder, inorder, map);
		node.right = helper(preStart+inIndex-inStart+1, inIndex+1,inEnd, preorder, inorder, map);
		
		return node;
											
	}

}
