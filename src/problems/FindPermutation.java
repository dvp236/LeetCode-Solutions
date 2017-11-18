package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * @author dharmik
 * By now, you are given a secret signature consisting of character 'D' and 'I'. 
 * 'D' represents a decreasing relationship between two numbers, 'I' represents an increasing relationship 
 * between two numbers. And our secret signature was constructed by a special integer array, which contains 
 * uniquely all the different number from 1 to n (n is the length of the secret signature plus 1). 
 * For example, the secret signature "DI" can be constructed by array [2,1,3] or [3,1,2], but won't be 
 * constructed by array [3,2,4] or [2,1,3,4], which are both illegal constructing special string that can't 
 * represent the "DI" secret signature.
 * 
 * On the other hand, now your job is to find the lexicographically smallest permutation of [1, 2, ... n] 
 * could refer to the given secret signature in the input.
 *
 */

public class FindPermutation {
	
	//I = [1,2]
	//DI = [2,1,3]
	public static int[] findPermutation(String s) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<Integer> st = new Stack<>();
		
		//push into stack when discover D
		//pop and insert to array when discover I
		for (int i = 1; i <= s.length(); i++) {
			char c = s.charAt(i-1);
			if( c == 'I'){
				st.push(i);
				while(!st.empty())
					list.add(st.pop());
				
			}else
				st.push(i);
			
			
		}
		st.push(s.length()+1);
		
		while(!st.isEmpty()) {
			list.add(st.pop());
		}
			
		return list.stream().mapToInt(i -> i).toArray();
	}
	public static void main(String[] args) {
		System.out.println("jsn");
		
		System.out.println(Arrays.toString(findPermutation("DI")));
		
	}

}
