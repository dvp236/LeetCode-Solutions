package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/is-subsequence/
public class IsSubsequence {
	
	
	//s = "ace", t = "abcde" - true
	//s = "aec", t = "abcde" - false
	public static boolean isSubsequence(String s, String t) {
		int tindex  = 0;
		int sindex = 0;
		while (sindex < s.length()) {
			if (tindex == t.length()) return false;
			
			if (s.charAt(sindex) == t.charAt(tindex)) sindex++;
			tindex++;
		}
		return true;
	}
	
	//what if there are multiple such s strings, and t is same very long string
	public static boolean isSubsequence2(String s, String t) {
		//the approach here is to put all the indices of chars in the map
		//loop over string s and comparing index of appearance of chars in t 
		
		List<Integer>[] map = new List[256];
		for (int i= 0 ; i < t.length(); i++) {
			if (map[t.charAt(i)] == null) map[t.charAt(i)] = new ArrayList<>();
			map[t.charAt(i)].add(i);
		}
		
		int prev = 0;
		
		for (int i=0; i < s.length(); i++) {
			if (map[s.charAt(i)] == null) return false;
			int j = Collections.binarySearch(map[s.charAt(i)], prev);
			if (j < 0) j = -j-1;
			if (j == map[s.charAt(i)].size()) return false;
			prev = map[s.charAt(i)].get(j)+1;
		}
		return true;
	}
	

	public static void main(String[] args) {
		System.out.println("Swaminarayan!");
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(new Integer[]{1,3,4,9}));
		
		System.out.println(Collections.binarySearch(a, 11));
		System.out.println(isSubsequence("ace", "abcde"));
		
		System.out.println(isSubsequence2("cde", "abcde"));
		
	}

}
 