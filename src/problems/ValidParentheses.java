package problems;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
	 //time complexity O(n)
	public static boolean validParenthesis2(String s) {
	    int open = 0; int close = 0; int star = 0;
	    for (int i=0; i<s.length(); i++) {
	      if (s.charAt(i) == '(') open++;
	      else if (s.charAt(i) == ')') {
	        if (close > star + open) return false;
	        close++;
	      } else if (s.charAt(i) == '*') star++;
	    }
	    if (star+open<close) return false;

	    for(int i=s.length()-1; i>=0; i-- ) {
	      if (s.charAt(i) == ')') close++;
	      else if (s.charAt(i) == '(') {
	        if (open>close+star) return false;
	        open++;
	      } 
	      else if (s.charAt(i) == '*') star++;
	    }
	    if (star+close<open) return false;
	    return true;
	}
	  
	public static boolean isValidParentheses(String s) {
		String openP = "{[(";
		HashMap<Character,Character> map = new HashMap<>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')','(');
		Stack<Character> st = new Stack<>();
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(openP.indexOf(c) > -1) {
				st.push(c);
			} else {
				char last = st.isEmpty() ? '#' : st.pop();
				if (last != map.get(c)) return false;
			}
		}
		if(!st.isEmpty()) return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Jsn!!");
		String s = "{{{(){}}}}";
		System.out.println(isValidParentheses(s));
	}

}
