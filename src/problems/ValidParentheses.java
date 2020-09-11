package problems;

import java.util.*;

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






























	public static boolean valid(String s) {
		String openBrackets = "({[";
		Map<Character, Character> map = new HashMap<>();
		map.put('}','{');
		map.put(')', '(');
		map.put(']','[');

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (openBrackets.indexOf(c) > -1) {
				stack.push(c);
			}else {
				char last = stack.empty() ? '#' : stack.pop();
				if (last != map.get(c)) return false;
			}
		}

		return stack.empty();
	}


	//https://www.geeksforgeeks.org/minimum-swaps-bracket-balancing/
	//[]][][ --> 2
	//[]][[] --> 1
	public static int minSwapToBalanceBrackets(String brackets) {
		int balance = 0;
		char open = '[';
		char close = ']';
		int result = 0;

		for (int i = 0; i < brackets.length(); i++) {
			char curr = brackets.charAt(i);

			if (curr == open) balance++;
			else balance--;

			if (balance < 0) {
				result++;
			}
 		}

		return result;
	}

	//https://www.geeksforgeeks.org/minimum-swaps-bracket-balancing/
	public static int minSwapToBalance2(String s) {
		char[] ca = s.toCharArray();
		int result = 0;
		List<Integer> openPos = new ArrayList<>();
		char open = '[', close = ']';

		for (int i =0; i < s.length(); i++) {
			if (s.charAt(i) == open) openPos.add(i);
		}
		int balance = 0;
		Iterator<Integer> iter = openPos.iterator();
		//]][[[] ->
		for (int i = 0 ; i < s.length(); i++) {
			char curr = ca[i];
			if (curr == open) {
				if (iter.hasNext()) {
					iter.next();
				}
				balance++;
			} else {
				balance--;
			}

			if (balance < 0) {
				if (iter.hasNext()) {
					int nextopen = iter.next();
					result += nextopen - i;
					ca[i] = '[';
					ca[nextopen] = ']';
					balance = 1;
				}
			}
		}

		System.out.println(Arrays.toString(ca));
		return result;
	}

	//[]][][ -->2
	public static int balprac(String st) {
		int result = 0;
		int balance = 0;
		for (int i = 0; i < st.length(); i++) {
			char c = st.charAt(i);
			if(c == '[') balance++;
			else balance--;

			if (balance < 0) result++;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println("Jsn!!");
		String s = "{{{(){}}}}";
		System.out.println(isValidParentheses(s));

		System.out.println(valid(s));

		System.out.println("--------");
		String b1 = "[]][]["; //2
		String b2 = "[][][]";//0
		String b3 = "[[[]]]][[[]]"; //0
		String b4 = "]][[[]"; //1
		System.out.println(minSwapToBalanceBrackets(b4)); //]][[[] --> []][[] -->[][][]
		System.out.println("bl3 -"+ minSwapToBalance2(b4));
		System.out.println("bal prac - "+balprac(b4));
		s.hashCode();
		//]][[[]
		//][][[]
		//[]][[]
		//[][][]

		//1,5,7,8,9;
		String c = "hello";
		c = c.substring(0,1) + 'c' +c.substring(2, c.length());
		System.out.println(c);
	}

}
