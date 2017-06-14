package problems;

import java.util.Arrays;

/**
 * 
 * @author dharmik
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 *
 * Note:
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 * Input points have no order.
 */
public class ValidSquare {
	
	public static int dist(int[] p1, int[] p2) {
		return (p1[0] - p2[0]) * (p1[0] - p2[0])  + (p1[1] - p2[1]) * (p1[1] - p2[1]);
		
	}
	public static boolean isValidSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[][] p = new int[][]{p1,p2,p3,p4};
		//sort array based on x index and y index
		Arrays.sort(p, (l1,l2) -> l1[0] == l2[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
		
		//be careful in comparing
		//0-1, 2-3, 1-3, 0-2, 1-3 // 1 * 2 , 0 * 3
		return dist(p[0], p[1]) != 0 && dist(p[0], p[1]) == dist(p[1], p[3]) && dist(p[1], p[3]) == dist(p[3], p[2]) && dist(p[3], p[2]) == dist(p[2], p[0])   && dist(p[0],p[3])==dist(p[1],p[2]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean ans = isValidSquare(new int[]{0,0} , new int[]{1,1}, new int[]{0,1}, new int[]{1,0});
		System.out.println(ans);

	}

}
