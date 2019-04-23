package problems;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void permutation(int[] a) {
		List<List<Integer>> result = new ArrayList<>();
		
		backtrack(result, new ArrayList<Integer>(), a);
		
		for (List<Integer> list: result) {
			System.out.println(list);
		}
	}
	//dont need a start index -> as we want all the elements in the sublist
	private static void backtrack(List<List<Integer>> result, List<Integer> sublist, int[] a) {
		if (sublist.size() == a.length) 
			result.add(new ArrayList<>(sublist));
		
		else {
			for (int i = 0; i < a.length; i++) {
				
				if (sublist.contains(a[i])) continue;
				
				sublist.add(a[i]);
				backtrack(result, sublist, a );
				sublist.remove(sublist.size() - 1);
			}
		}
		
	}
	
	public static void permutationDup(){}
	public static void main(String[] args) {
		System.out.println("permutation");
		permutation(new int[]{1,2,3});
	}

}
