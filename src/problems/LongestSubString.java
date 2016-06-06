package problems;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * @author dharmik patel
 * Implement a method to get length of longest non repeating subsequence
 * of the string.
 *
 */
public class LongestSubString {
	
	public static int getLengthOfSubstring(String s) {
        int n = s.length(), result = 0; int lo=0,hi=0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int j = 0, i = 0; j < n; ++j) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            //if it is substring get index hi, lo
            if(j-i > result){
            	hi = j+1;
            	lo = i+1;
            }
            result = Math.max(result, j - i);
            map.put(s.charAt(j), j);
        }
        System.out.println(s.substring(lo,hi));
        return result;
    }
	public static void main(String[] args){
		String st="abcdeabcdttabcdefg";
		String st2 = "pwwkew";
		System.out.println(getLengthOfSubstring(st));
		System.out.println(getLengthOfSubstring(st2));
		System.out.println(st2.substring(0,2));
	}
}
