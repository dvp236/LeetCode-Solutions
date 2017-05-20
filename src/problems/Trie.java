package problems;

import java.util.ArrayList;

public class Trie {
	public class Node {
		boolean isLeaf;
		char key;
		char value;
		ArrayList<Node> children;
		
		public Node(char key) {
			this.key = key;
			children = new ArrayList<Node>();
		}
		
		public char getKey() { 
			return key;
		}
		
		public boolean hasChild(char key) {
			for(Node child: children){
				if(key == child.getKey())
					return true;
			}
			return false;
		}
		
		public Node getChild(char key) {
			
			for(Node child : children) {
				if( key == child.getKey() )
					return child;
			}
			
			return null;
		}
		
		public void setLeaf(){
			this.isLeaf = true;
		}
		
		public boolean getLeaf(){
			return isLeaf;
		}
		public void addChild(Node node) {
			if(!children.contains(node)) 
				children.add(node);
		}
	}
	
	
	Node root = new Node('#');
	
	public void insert(String a) {
	// a b c d
		Node node = root;
		for(int i = 0; i < a.length() ; i++) {
			if(!node.hasChild(a.charAt(i))){
				Node newnode = new Node(a.charAt(i));
				if( i == a.length()-1 ) newnode.setLeaf();
				node.addChild(newnode);
				node = newnode;
			}else{
				node = node.getChild(a.charAt(i));
			}
		}
	}
	
	
	public boolean search(String a) {
		Node node = root;
		for(int i=0; i < a.length() ;i++) {
			if(!node.hasChild(a.charAt(i))) return false;
			node = node.getChild(a.charAt(i));
			System.out.println(i);
		}
		
		System.out.println(node.getKey());
		return node.getLeaf();
		
	}

}
