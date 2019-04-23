package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author dharmik
 * https://leetcode.com/problems/group-anagrams/
 *
 */
public class GroupAnagrams {
	
	
	//takes O(nklogk) - n total words , k max string length
	//optimization - instead of sorted string as key- we can use sum of char's ascii value as key
	// that way we can get the key on o(k) time. 
	public static List<List<String>> groupAnagrams(String[] words) {
		Map<String, List<String>> map = new HashMap<>();
		
		for (String word: words) {
			char[] wordChars = word.toCharArray();
			Arrays.sort(wordChars);
			String sortedWord = new String(wordChars);
			
			if (!map.containsKey(sortedWord)) map.put(sortedWord, new ArrayList<String>());
			
			map.get(sortedWord).add(word);
			
		}
		for (List<String> group: map.values())
			System.out.println(group);
		return new ArrayList(map.values());
	}
	
	
private static boolean isAnagram(String s1, String s2) {
	    
	    if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return false;
	   
	    if (s1.length() != s2.length()) return false;
	    
	    HashMap<Character, Integer> map = new HashMap<>();
	    for (int i = 0; i < s1.length(); i++) {
	      map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i),0) +1);
	      map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i),0) - 1);
	    }
	    
	    for (char key: map.keySet()){
	      if (map.get(key) != 0) return false;
	    }
	    
	    return true;
	    
	    
	  }
	  
	  public static void groupBy(String[] words) {
	    List<List<String>> answer = new ArrayList<>();
	    List<List<String>> result = new ArrayList<>();
	    
	    HashSet<String> processed = new HashSet<String>();
	    List<String> nonGrams = new ArrayList<String>();
	    
	    for (int i = 0; i < words.length; i++) {
	      String si = words[i];
	      if (processed.contains(si)) continue;
	      List<String> anagrams = new ArrayList<String>();
	      anagrams.add(si);
	      for (int j = i+1; j < words.length; j++) {
	        String sj = words[j];
	        if (!processed.contains(sj)) {
	          if (isAnagram(si,sj)) {
	            anagrams.add(sj);
	            processed.add(sj);
	            processed.add(si);
	          }
	        }
	      }
	      if(anagrams.size() == 1) {
	        nonGrams.add(si);
	      } else {
	        result.add(anagrams);
	      }
	    }
	    
	    
	    //answer.add(result);
	    //answer.add(nonGrams);
	    
	    for (List<String> anag : result) {
	      System.out.println(anag);
	    }
	    System.out.println("nongrams - ");
	     System.out.println(nonGrams);

	  }
	
	public static void main(String[] args) {
		String[] words = new String[]{"art", "desserts", "elbow", "state", "dusty", "rat", "tart", "cat", "below", "taste", "stressed", "tar"};
	    
	    groupAnagrams(words);
	}

}
