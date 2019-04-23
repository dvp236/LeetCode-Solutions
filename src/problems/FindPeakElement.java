package problems;
/**
 * 
 * @author dharmik
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 *
 */
public class FindPeakElement {
	public static int findPeakElement(int[] a) {
		return helper(a, 0, a.length-1 );
	}
	
	//we will tweak binary search.
	//move close to highest element with every search
	public static int helper(int[] a, int lo, int hi) {
		while (lo < hi) {
			int mid = (lo+hi)/2;
			if (a[mid] < a[mid+1])
				lo = mid+1;
			else 
				hi = mid;
		}
		return hi;	
		
	}

	public static void main(String[] args) {
		int[] a = new int[]{5,6,7,8,9,10,4,2,1,2,3,4,5,4,3,2,1,0,3,4,5,6};
		int[] b = new int[]{1,2,3,1};
		//does not work for this //actually this is valid case as 8 is also a peak element.
		System.out.println(findPeakElement(b));
	}

}