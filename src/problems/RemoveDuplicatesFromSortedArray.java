package problems;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

	//Time Complexity: O(n)
	public static int[] removeDuplicates(int a[]){
		int i=0;

		for(int j=1;j<a.length;j++){
			if(a[i] != a[j]){
				i++;
				a[i] = a[j];
			}
		}
		Arrays.fill(a, i+1, a.length, 0);
		System.out.println("Duplicate count: "+ (a.length-1-i));
		return a;
	}
	
	//Time Complexity : O(n)
	public static int countDuplicates(int[] a){
		int count = 0;
		for(int i=1 ; i<a.length ;i++){
			if(a[i] == a[i-1])
				count ++;
			
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{1,1,1,2,2,3,3,3,4};
		System.out.println(countDuplicates(a));
		System.out.println(Arrays.toString(removeDuplicates(a)));
	
	}

}
