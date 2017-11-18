package problems;

/**
 * 
 * @author dharmik
 * 
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its
 * upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 */

public class RangeSumQueryImmutable2d {
	static int[][] dp;
	//since we will be calling range sum many times we will create an array to give dynamic solution
	//initialize dp array in such a way that dp[r][c] is sum of dp[0][0] to dp[r][c]
	public RangeSumQueryImmutable2d(int[][] a) {
		dp = new int[a.length+1][a[0].length+1];
		for(int i = 0; i < a.length;  i++) {
			for(int j = 0; j < a[0].length; j++) {
				//dp[i][j] has already been counted in dp[i+1][j] & dp[i][j+1]. so exclude it one time.
				dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1] + a[i][j] - dp[i][j];
			}
		}
		
	}
	
	public static int sumRange(int r1, int c1, int r2, int c2) {
		//since dp[r2][c2] is sum from dp[0][0] to that point we will need to deduct rectangle above it i.e dp[r1][c2+1]	
		//and one beside it i.e dp[r2+1][c1].
		//since dp[r1][c1] was included twice in above two ractangle we will add it once.
		return dp[r2+1][c2+1] - dp[r1][c2+1] - dp[r2+1][c1] + dp[r1][c1];
	}
	
	public static void main(String[] args) {
		//System.out.println("Jay Swaminarayan!");
		
		int[][] a = new int[][]{
				new int[]{3,0,1,4,2},
				new int[]{5,6,3,2,1},
				new int[]{1,2,0,1,5},
				new int[]{4,1,0,1,7},
				new int[]{1,0,3,0,5}
			};
			
		RangeSumQueryImmutable2d r = new RangeSumQueryImmutable2d(a);
		System.out.println(r.sumRange(1, 2, 2, 4));
	}

}
