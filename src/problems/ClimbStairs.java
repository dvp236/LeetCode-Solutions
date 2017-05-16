package problems;
/**
 * 
 * @author dharmik
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 */
public class ClimbStairs {
	//this is classic problem. It can be solved using fibonacci series.
	//since total number of steps at i, dp[i] = dp[i-1] + dp[i-2]
	public static int climbStairs(int n) {
		if( n<=1 ) return n;
		
		int[] result = new int[n+1];
		result[1] = 1;
		result[2] = 2;
		// 1 2 3 5 8
		for( int i = 3; i <= n ; i++) {
			result[i] = result[i-1] + result[i-2];
		}
		
		return result[n];
	}
	
	public static void main(String[] args) {
		System.out.println(climbStairs(5));
	}
}
