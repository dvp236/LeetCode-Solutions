package problems;

import java.util.Arrays;

/**
 * 
 * @author dharmik
 *
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 
 */

public class MinimumPathSum {
	
	public static int getMinPathSum(int[][] grid){
		int m = grid.length; //num of rows
		int n = grid[0].length; //nums of columns 
		
		for(int i = 1; i < n ; i++)
			grid[0][i] += grid[0][i-1];
		
		for(int i = 1; i < m ; i++)
			grid[i][0] += grid[i-1][0];
		System.out.println(Arrays.toString(grid[0]));
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);				
			}
			System.out.println(Arrays.toString(grid[i]));
		}
		
		
		return grid[m-1][n-1];
	}
	
	public static void main(String[] args) {
		int[][] a = new int[][]{
				new int[]{1,2,3,4},
				new int[]{5,6,7,8},
				new int[]{1,8,9,8},
				new int[]{1,1,1,1}				
			};
			
		System.out.println(getMinPathSum(a));
		
	}
}
