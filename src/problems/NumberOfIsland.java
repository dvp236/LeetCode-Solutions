package problems;

import java.util.Arrays;

public class NumberOfIsland {
	
	
	//If we are asked not to used the visited array then we can modify existing grid array .
	// we can set grid[i][j] to 0 or 2 everytime we visit.
	public static int findCompsVisited(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (!visited[i][j]) {
				
					if (grid[i][j] == 1) {
						dfs(grid,visited, i,j);
						count++;
					} else {
						visited[i][j] = true;
					}
				}
				
			}
		}
		
		return count;
		
	}
	
	private static void dfs(int[][] grid, boolean[][] visited, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j]) return;

		visited[i][j] = true;
	
		if (grid[i][j] == 0) {
			return;
		}
		
		//now we know grid[i][j] == 1
		//we can add 4 more directions if we want to include diagonals as well
		int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
		
		for (int[] dir: directions) {
			dfs (grid, visited, i+dir[0], j+dir[1]);
		}

	}
	
	//without using visited
	public static int findCompsOpt(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					dfsOpt(grid,i,j);
					count++;
				} 
			}
		}
		
		return count;
		
	}
	
	private static void dfsOpt(int[][] grid, int i, int j) {

		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j]!=1) return;
		
		grid[i][j] = 2;
		int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
		
		for(int[] dir : directions) {
			dfsOpt(grid, i+dir[0], j+dir[1]);
		}
		
	}

	

	public static void main(String[] args) {
		int grid[][] = new int[][] {
			{1,1,0,0,1},
			{1,1,0,0,1},
			{0,0,1,0,0},
			{0,0,0,1,1}
		};
		
		for (int[] a: grid) System.out.println(Arrays.toString(a));
		System.out.println(findCompsVisited(grid));
		
		System.out.println(findCompsOpt(grid));
	}

}
