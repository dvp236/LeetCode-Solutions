package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieNode {
	char val;
	TrieNode[] children;
	boolean isWord;
	
	public TrieNode(char val) {
		this.val = val;
		children = new TrieNode[26];
	}
	
}

public class TrieOptimized {
	
	TrieNode root;
	
	public TrieOptimized() {
		root  = new TrieNode('#'); //if not # then consider something like space - ' ' 
	}
	
	public void insert(String st) {
		TrieNode curr = root;
		//abc
		for (int i = 0; i < st.length(); i++) {
			char  c = st.charAt(i);
			if (curr.children[c -  'a'] == null) {
				curr.children[c - 'a'] = new TrieNode(c);
			} 
			curr = curr.children[c - 'a'];
		}
		curr.isWord = true;
	}
	
	public boolean search(String st) {
		TrieNode curr = root;
		for (int i = 0; i < st.length(); i++) {
			char c = st.charAt(i);
			if (curr.children[c - 'a'] == null) return false;
			curr = curr.children[c - 'a'];
		}
		return curr.isWord;
	}
	
	public boolean startsWith(String st) {
		TrieNode curr = root;
		for (int i = 0; i < st.length(); i++) {
			char c = st.charAt(i);
			if (curr.children[c - 'a'] == null) return false;
			curr = curr.children[c - 'a'];
		}
		return true;
	}
	
	public List<String> getKWordsStartsWith(String prefix, int k) {
		List<String> res = new ArrayList<String>();
		if (!startsWith(prefix)) return null;
		
		TrieNode curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			curr = curr.children[c-'a'];
		}
		wordfinder(prefix, curr, res, k);
		return res;
	}
	
	private void wordfinder(String prefix, TrieNode curr, List<String> res, int k) {
		if (curr.isWord ) res.add(prefix);
		for (int i = 0; i < 26 && res.size() < k; i++) {
			if (curr.children[i] != null ) {
				wordfinder(prefix + curr.children[i].val, curr.children[i], res, k);
			}
		}
	}
	public static void main(String[] args) {
		TrieOptimized trie = new TrieOptimized();
		trie.insert("apple");
		trie.insert("banana");
		trie.insert("appstore");
		trie.insert("apna");
		trie.insert("appl");
		trie.insert("apps");
		trie.insert("ap");
		trie.insert("basket");
		
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("apps"));
		System.out.println(trie.search("appstore"));
		
		System.out.println("-----------");
		
		System.out.println(trie.startsWith("ban"));
		System.out.println(trie.startsWith("apl"));
		System.out.println(trie.startsWith("appst"));
		
		List<String> suggest = trie.getKWordsStartsWith("app", 5);
		System.out.println(Arrays.toString(suggest.toArray()));
		
		char  t = 'a'+2;
		System.out.println(t);
	}
}
