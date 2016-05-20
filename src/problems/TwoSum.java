package problems;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	
	public static void main(String[] args){
		int a[] = {2,11,7,5};
		int target = 9;
		//output = [0,2]
		System.out.println(Arrays.toString(getPair(a,target)));
		System.out.println(Arrays.toString(getPair(a,target)));
	}
	
	//using hashmap
	//Time & Space = O(n)
	//most efficient
	public static int[] getPair2(int[] a, int target){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<a.length; i++){
			int val = target - a[i];
			if(map.containsKey(val)){
				return new int[] {i, map.get(val)};
			}
			map.put(a[i], i);
		}
		
		throw new IllegalArgumentException("No pairs found ");
	}
	
	/*
	 * A second approach efficient than bruteforce could give us O(nlog(n)) performance 
	 * without using hashmap. This approach involves sorting array using quick sort in nlogn 
	 * and for each element performing binary search to search target - a[i] element
	 * this will overall cost us 2nlogn which is nlogn in general.
	 */
	
	//bruteforce approach 
	//Time complexity O(n^2)
	public static int[] getPair(int[] a, int target){
		
		for(int i=0;i<a.length;i++){
			int val = a[i];
			//necessary to start j from 0
			for(int j=0;j<a.length;j++){
				if(i!=j){
					//pair found 
					if(a[j] == target-val){
						return new int[]{i,j};
					}
				}
			}
		}
		
		throw new IllegalArgumentException("No pairs found");
	}
	
}
