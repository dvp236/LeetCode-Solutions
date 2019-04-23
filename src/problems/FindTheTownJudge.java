package problems;

import java.util.HashMap;
import java.util.HashSet;
//https://leetcode.com/problems/find-the-town-judge/
public class FindTheTownJudge {
	
	//O(N)
	//Another solution can be made with using only arrays instead of map.
	public static int findJudge(int n, int[][] trust) {
		HashMap<Integer, Integer> freq = new HashMap<>();
		HashSet<Integer> compromised = new HashSet<>();
		for (int i = 0; i < trust.length; i++) {
			freq.put(trust[i][1], freq.getOrDefault(trust[i][1], 0)+1);
			
			if (freq.containsKey(trust[i][0])) {
				compromised.add(trust[i][0]);
			}
		}
		
		for (int k:freq.keySet()) {
			if (freq.get(k) == n-1 && !compromised.contains(k)) return k;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println("jsn");
		int[][] trust = new int[][]{
			{1,3},{1,4},{2,3},{2,4},{4,3}
		};
		
		System.out.println(findJudge(4, trust));
		
	}

}
