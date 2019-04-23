package problems;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeDeserializeBinTree {

	public static String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serializeHelper(root,sb);
		return sb.toString();
	}
	
	private static void serializeHelper(TreeNode node, StringBuilder sb) {
		if(node == null) {
			sb.append("null,");
		}else {
			sb.append(node.value+",");
			serializeHelper(node.left, sb);
			serializeHelper(node.right, sb);
		}
	}
	
	public static TreeNode deserialize(String st) {
		String[] s = st.split(",");
		Deque<String> node = new LinkedList<>();
		node.addAll(Arrays.asList(st.split(",")));
		return deserializeHelper(node);
	}
	
	public static TreeNode deserializeHelper(Deque<String> q) {
		String val = q.remove();
		if(val.equals("null")) {
			return null;
		}
			TreeNode node = new TreeNode(Integer.parseInt(val));
			node.left = deserializeHelper(q);
			node.right = deserializeHelper(q);
		return node;
	}
	public static void main(String[] args) {
		System.out.println("jsn");
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		String st = serialize(root);
		System.out.println(st);
		
		TreeNode froot = deserialize(st);
		System.out.println(serialize(froot));
		
		String st1 = serialize(froot);
		TreeNode kroot = deserialize(st1);
		System.out.println(serialize(kroot));
				
	}
}
 