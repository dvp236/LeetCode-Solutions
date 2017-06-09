package problems;
/**
 * 
 * @author dharmik
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * Example: Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 *
 */
public class RangeSumQueryImmutable {
	
	int[] dp;
	
	public RangeSumQueryImmutable(int[]  nums) {
        dp = new int[nums.length+1];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
        	dp[i+1] = dp[i] + nums[i];
        }
    }
 
    public int sumRange(int i, int j) {
    	// i+1, j+1 is to dp as i,j is to nums
    	// so we return sum to j+1 - i (since i+1 need to be included in sum)
    	return dp[j+1] - dp[i];  
    }
    
    public static void main(String[] args) {
    	int[] nums = {0,1,2,3,4,5,6};
    	RangeSumQueryImmutable ob = new RangeSumQueryImmutable(nums);
    	
    	System.out.println(ob.sumRange(2, 4));
    }

}
