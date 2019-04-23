package problems;

import java.util.Arrays;

/**
 * 
 * @author dharmik
 * 
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 * 
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 * 
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 *
 */
//https://leetcode.com/problems/distinct-subsequences/

public class DistinctSubsequences {

	public static int count(String s, String t) {
		int[][] dp = new int[t.length()+1][s.length()+1];
		
		for (int i = 0; i < dp[0].length; i++) dp[0][i] = 1;
		
		for (int i = 1; i <= t.length(); i++) {
			for (int j = 1; j <= s.length(); j++) { //optimization start j = i
				if (s.charAt(j-1) == t.charAt(i-1)) {
					dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
				} else {
					dp[i][j] = dp[i][j-1];
				}
			}
		}
		for(int[] a : dp){
			System.out.println(Arrays.toString(a));
		}
		return dp[t.length()][s.length()];
	}
	public static void main(String[] args) {
		System.out.println(count("abcde","ace"));
	}

}
