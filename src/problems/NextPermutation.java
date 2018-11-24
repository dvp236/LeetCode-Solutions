package problems;

import java.util.Arrays;

/**
 * 
 * @author dharmik
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 -> 1,3,2
 * 3,2,1 -> 1,2,3
 * 1,1,5 -> 1,5,1
 * 
 * 
 */
public class NextPermutation {

	//take 2 pass. First find the value to replace 
	//find just bigger value for replacement
	//reverse remaining elements 
	public static int[] nextPermutation(int[] a){
		int k=a.length-2,j;
		
		while(k>=0 && a[k]>=a[k+1]) k--;
		System.out.println("k"+k);

		if(k>=0){
			j=a.length-1;
			while(j>=0 && a[j] <= a[k]) j--;
			System.out.println("j"+j);
			swap(a,k,j);
		}
		
		reverse(a, k+1, a.length-1);
		return a;
	}
	
	
	public static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void reverse(int[] a, int i, int j){
		while(i<j){
			swap(a,i,j);
			i++;
			j--;
		}
	}
	public static void main(String[] args) {
		//System.out.println("gajab");
		int[] a = new int[]{1,2,3};
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(nextPermutation(a)));
	}

}
