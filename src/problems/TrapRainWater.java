package problems;

/**
 * 
 * @author dharmik
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 */

public class TrapRainWater {
	
	public static int trap(int[] a) {
		
		//0 1 0 2 1 0 3 2 1 2 1
		
		int left_max = 0, right_max = 0;
		int left = 0, right = a.length-1;
		int ans =0;
		//we only move ahead from smaller side.
		//so if a[right] is smaller then a[left], we move from right side and calculate water we can trap
		while(left < right) {
			
			if(a[left] < a[right]){
				
				if(a[left] > left_max) {
					left_max = a[left];
				}
				else{
					ans += left_max - a[left] ;
				}
				
				left++;
				
			}else{
				
				if(a[right]>right_max)
					right_max = a[right];
				else
					ans += right_max-a[right];
				
				right--;
			}	
			
		}
		
		return ans;
		
		
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(a));
		int[] b = new int[]{0,0,2,0,0,0,1};
		System.out.println(trap(b));
	}

}
