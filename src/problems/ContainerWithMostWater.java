package problems;

/**
 * 
 * @author dharmik patel
 * 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 */
public class ContainerWithMostWater {
	
	//Bruteforce 
	//time complexity: O(n^2)
	public static int maxArea1(int[] heights){
		int area = 0;
		for(int i=0; i<heights.length;i++){
			for(int j=i+1; j< heights.length;j++){
				area = Math.max(area, Math.abs(Math.min(heights[i], heights[j])*(j-i)));
			}
		}
		return area;
		
	}
	
	//go from both the side evaluating area
	//to maximize area, move from the side where height is smaller
	//thus trying to keep are maximum between the lines
	//Time compelxity : O(n)
	public static int maxArea(int[] heights){
		int area = 0;
		
		for(int i=0, j=heights.length-1 ; i<j ;){
			area = Math.max(area, Math.abs(Math.min(heights[i], heights[j])*(j-i)));
			//move from the smaller side, keep max height 
			if(heights[i] > heights[j]) j--;
			else i++;
		}
		
		return area;
	}
	public static void main(String[] args) {
		

	}

}
