package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class WordBreak {
	//
	public static void wordbreakRec(String st, String[] words) {
		HashSet<String> dict = new HashSet<>();
		for (String word : words) dict.add(word);
		
		ArrayList<String> maker  = new ArrayList<String>();
		wordBreakHelper(st, dict, maker);
		Collections.reverse(maker);
		System.out.print(st+"=");
		for (String word : maker) System.out.print(word+" ");
	}
	
	private static boolean wordBreakHelper(String st, HashSet<String> dict, ArrayList<String> maker) {
		if (st.length() == 0) return true;
		
		for (int i = 1; i <= st.length(); i++) {
			String s = st.substring(0, i);
			if (dict.contains(s) && wordBreakHelper(st.substring(i, st.length()), dict,maker)){
				maker.add(s);
				return true;
			}
		}
		
		return false;
	}
	public static boolean wordBreakDP(String s, String[] words) {
		HashSet<String> dict = new HashSet<>();
		for (String word : words) dict.add(word);
		boolean dp[] = new boolean[s.length()+1];
		dp[0] = true;
		for (int i = 0; i <=  s.length(); i++) {
			for (int j=0; j<i; j++) {
				if(dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[s.length()];
	}
	
	public static void main(String[] args) {
		System.out.println("jsn");
		String[] words = new String[]{"pine","apple","pan"};
		wordbreakRec("pineapplepine", words);
		
		System.out.println(wordBreakDP("pineapplepine", words));
		
		String[] words1 = new String[] {"rockstar","rock","star","rocks","tar","stars","high","way","super"};
		//wordbreakRec("superhighway",words1);
		
	}

}
