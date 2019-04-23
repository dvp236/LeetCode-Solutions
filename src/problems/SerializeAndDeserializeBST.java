package problems;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/serialize-and-deserialize-bst/discuss/93177/what's-the-difference-between-this-and-297

//https://leetcode.com/problems/serialize-and-deserialize-bst/discuss/177617/the-General-Solution-for-Serialize-and-Deserialize-BST-and-Serialize-and-Deserialize-BT
public class SerializeAndDeserializeBST {
	
	public static String serializeBST(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serializeHelper(root,sb);
		return sb.toString();
	}
	
	//We dont need null in the string.. as we know the property of BST and that will help us deserialize.
	private static void serializeHelper(TreeNode node, StringBuilder sb) {
		if (node != null) {
			sb.append(node.value+",");
			serializeHelper(node.left, sb);
			serializeHelper(node.right, sb);
		}
	}
	
	public static TreeNode deserializeBST(String st) {
		//deserializeHelper()
		Deque<String> q = new LinkedList<>();
		q.addAll(Arrays.asList(st.split(",")));
		return deserializeHelper(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static TreeNode deserializeHelper(Deque<String> q, int min, int max) {
		if (q.isEmpty()) return null;
		int val = Integer.parseInt(q.peek());
		
		if (val < min || val > max) return null;
		q.poll();
		
		TreeNode node = new TreeNode(val);
		node.left = deserializeHelper(q, min, val);
		node.right = deserializeHelper(q, val, max);
		
		return node;
		
	}
	
	
	public static void printpre(TreeNode node) {
		if (node == null) return;
		
		System.out.print(node.value+" ");
		printpre(node.left);
		printpre(node.right);
		
	}
	public static void main(String[] args) {
		System.out.println("jsn");
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(8);
		
		printpre(root);
		String st = serializeBST(root);
		System.out.println();
		System.out.println(st);
		
		TreeNode root1 = deserializeBST(st);
		System.out.println(serializeBST(root1));
	}

}
