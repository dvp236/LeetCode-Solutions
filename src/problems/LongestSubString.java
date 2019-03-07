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
	//pwwketaw
	public static void test (String s) {
		int n = s.length() -1, index, lo, hi, max=0; 
		HashMap<Character, Integer> map = new HashMap<Character, Integer> ();
		for (int i = 0 ; i <= n; i++) {
			if (map.containsKey(s.charAt(i))) {
				index = map.get(s.charAt(i));
				max = Math.max(max, index);
			}
			
		}
	}
	
	public static int getLengthOfSubstring(String s) {
        int n = s.length(), result = 0; int lo=0,hi=0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //Goal is to maintain the window of substring
        //between i and j 
        //[i,j] is the substring 
        for (int j = 0, i = 0; j < n; ++j) {
            if (map.containsKey(s.charAt(j))) {
            	//we have to take max of i and map index
            	//because the window only moves forward.
                i = Math.max(map.get(s.charAt(j)), i);
            	
            }
            //get hi and lo to have substring
            if(j-i+1 > result){
            	hi = j+1;
            	lo = i;
            }
            //calculate substring length at each iteration 
            result = Math.max(result, j - i+1);
            map.put(s.charAt(j), j+1);
        }
	//If you want to have substring
        System.out.println(s.substring(lo,hi));
        return result;
    }
	
	public static void main(String[] args){
		String st="abcdeabcdtt";
		String st2 = "pwwkewta";
		System.out.println(getLengthOfSubstring(st2));
		System.out.println(getLengthOfSubstring("abbcda"));
	}
}
