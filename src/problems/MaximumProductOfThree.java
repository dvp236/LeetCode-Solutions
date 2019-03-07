package problems;

/**
 * 
 * @author dharmik
 * 
 * Given an integer array, 
 * find three numbers whose product is maximum and output the maximum product.
 *
 */

public class MaximumProductOfThree {

	//Op1 -  bruteforce
	//op2- sort array then return
	// Math.max(ar[0] * ar[1]*ar[lenght -1], ar[lenght -1]*ar[lenght -2]*ar[lenght -3])
	
	//op-3 simple scan of array to findout min1 min2 and max1max2max3
	//return max multiplication
	public static int getMax3Product(int[] a) {
		if (a.length < 3) return -1;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		
		for (int i=0; i<a.length; i++) {
			if (a[i] > max3) {
				max1 = max2;
				max2 = max3;
				max3 = a[i];
			} else if(a[i] > max2) {
				max1 = max2;
				max2 = a[i];
			} else if(a[i] > max1) {
				max1 = a[i];
			}
			
			if (a[i] < min1) {
				min2 = min1;
				min1 = a[i];
			} else if(a[i] < min2) {
				min2 = a[i];
			}
			
		}
		
		return Math.max(min1*min2*max3, max1*max2*max3);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{-10,10,1,2,3,4,10};
		System.out.println(getMax3Product(a));
	}

}
