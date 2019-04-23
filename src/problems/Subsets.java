package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	//1 2 3
	public static void subsets(int[] a) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(a);
		backtrack(result, new ArrayList<Integer>(), a, 0);
		
		for (List<Integer> list: result) {
			System.out.println(list);
		}
	}
	
	public static void backtrack(List<List<Integer>> result, List<Integer> sublist, int[] a, int start) {
		result.add(new ArrayList<>(sublist));
		for (int i=start; i < a.length; i++) {
			//To slkip duplicarte
			if(i > start && a[i] == a[i-1]) continue;
			sublist.add(a[i]);
			backtrack(result, sublist, a, i+1);
			sublist.remove(sublist.size()-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("start");
		subsets(new int[]{1,2,2});
	
		
		
	}

}
