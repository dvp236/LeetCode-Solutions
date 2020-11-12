package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//ABEDCDBA 
//ABC

public class MinimumWindowSubstring {
	
	//bruteforce - o(n2)  -- -works for unique chars in t 
	public static void bruteforce(String s, String t) {
		String res = s;
		
		for (int i = 0; i < s.length(); i++) {
			HashSet<Character> hs = new HashSet<Character>();
			String substr = "";
			for (int j = i; j < s.length(); j++) {
				if (t.indexOf(s.charAt(j))> -1) hs.add(s.charAt(j));
				substr += s.charAt(j);
				if (hs.size() == t.length()) {
					if (substr.length() < res.length()) res = substr;
					break;
				}
			}
		}
		System.out.println(res);
	}
	
	//Works when all chars in String t are unique;
	public static void getMinSubString(String s, String t) {
		HashMap<Character, Integer> window = new HashMap<>();
		String res = s;
		int left = 0;
		for (int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (t.indexOf(c) != -1) window.put(c, window.getOrDefault(c, 0) +1);
			
			if (window.size() == t.length()) {
				String temp = s.substring(left, i+1);
				if (temp.length() < res.length()) res = temp;
				while (window.size() == t.length()) {
					if (window.containsKey(s.charAt(left))) {
						int v = window.get(s.charAt(left));
						if (v ==1) window.remove(s.charAt(left));
						else window.put(s.charAt(left), window.get(s.charAt(left))-1);
					}
					String temp2 = s.substring(left, i+1);
					if (temp2.length() < res.length()) res = temp2;
					left++;
					
				}
			}
			
		}
		
		System.out.println("at - "+res);
		
	}
	

	
	public static String minWindow(String s, String t) {
        int[] arr = new int[128];
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)]++;
        }
        //s- ABDCDBDA  abcc 
        int counter = t.length(), left = 0, right = 0, window = Integer.MAX_VALUE, head = -1;
        while (right < s.length()) {
            char rc = s.charAt(right++);
            if (arr[rc] > 0) {
                counter--;
            }
            arr[rc]--;

            while (counter == 0) {
                if (right - left < window) {
                    window = right - (head = left);
                }

                char lc = s.charAt(left++);
                if (arr[lc] == 0) {
                	System.out.println("counter plus for "+lc);
                    counter++;
                }
                arr[lc]++;
            }
        }
        return head == -1 ? "" : s.substring(head, head + window);
    }
	
	public static void main(String[] args) {
		//System.out.println("jsn!!");
		//bruteforce("ABEDCAFBCBSABC", "ABC");
		//getMinSubString("ABEDCAB", "ABC");
		getMinSubString("ABEDCAFFBCBSSANBCCBADC", "ABC");
		System.out.println(minWindow("ABDCDCBA", "ABC"));
	}
}
 