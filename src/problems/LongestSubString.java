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
	
	public static int getLSubString(String st){
		int result = 0;
		int i=0;//this will track repeating character index
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		for(int j=0;j<st.length();j++){
			//put new char in the map with index
			if(!map.containsKey(st.charAt(j))){
				map.put(st.charAt(j),j);
			}else{//if the character is already in the map
				//calculate the length of substring 
				//i.e current index - last seen index
				i = map.get(st.charAt(j));
				result = Math.max(result, j-i);
				//update its index
				map.put(st.charAt(j),j);
				
			}
		}
		return result;
	}
	public static int lengthOfLongestSubstring(String s) {
        if(s==null)
	            return 0;
		char[] arr = s.toCharArray();
		int pre = 0;
	 
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	 
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				pre = Math.max(pre, map.size());
				i = map.get(arr[i]);
				map.clear();
			}
		}
	 
		return Math.max(pre, map.size());
	}
	
	public static int lengthOfLongestSubstringL(String s) {
        int n = s.length(), ans = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; ++j) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
	public static String uniqueCharSubstring(String str) {
        String result = "";
        int len = str.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] c = str.toCharArray();
        int right = 0, max = 0;
        for (int left = 0; left < len; left++) {
            while (right < len) {
                if (map.containsKey(c[right])) { 
                    left = Math.max(left, map.get(c[right]) + 1);
                }
                map.put(c[right], right);
                if (right - left > max) { 
                    max = right - left;
                    result = str.substring(left, right + 1);
                }
                right++;
            }
        }
        return result;
   }
 
	public static void main(String[] args){
		String st="abcdeabcdttdbbj";
		String st2 = "pwwkew";
		
		//System.out.println(lengthOfLongestSubstring(st));
		System.out.println(getLSubString(st));
		//System.out.println(lengthOfLongestSubstringL(st));
		//System.out.println(uniqueCharSubstring(st2));
		
	}
}
