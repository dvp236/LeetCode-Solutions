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
		
		int left_max = 0; int right_max = 0;
		int left = 0 ; int right = a.length-1;
		int ans =0;
		while(left < right) {
			if(a[left] < a[right]){
				if(a[left] > left_max) {
					left_max = a[left];
				}
				else{
					ans+=left_max - a[left] ;
				}
				left++;
			}else{
				if(a[right]>right_max)
					right_max = a[right];
				else
					ans+=right_max-a[right];
				right--;
			}
			
			
		}
		return ans;
		
		
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(a));
	}

}
