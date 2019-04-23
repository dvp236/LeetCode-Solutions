package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/sort-characters-by-frequency/
public class SortCharactersByFrequency {
	
	//tree --> eert
	//without using queue
	public static String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		//map character to count
		for (Character ch: s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		//take a bucket
		List<Character>[] bucket = new List[s.length()+1];
		for(Character c: map.keySet()) {
			//at each bucket index put the character/s of that count
			if (bucket[map.get(c)] == null) bucket[map.get(c)] = new ArrayList<>(); 
			bucket[map.get(c)].add(c);	
		}
		StringBuilder sb = new StringBuilder();
		//now at index 3 -> we have chars of 3 count. 
		//so move from last possible index to 0
		for (int i=bucket.length-1 ; i>=0; i-- ) {
			if (bucket[i] != null) {
				for (Character c: bucket[i]) {
					for (int j=0; j<map.get(c); j++) {
						sb.append(String.valueOf(c));
					}
				}
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	//more elegant solution using PriorityQueue
	public static String frequencySort2(String s) {
		//map characters to count
		HashMap<Character, Integer> map = new HashMap<>();
		for (Character c: s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		//take a priority queue - set its priority to count of chars in descending orders
		PriorityQueue<Character> q = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
		for(Character c: map.keySet()) {
			 q.add(c);
		}
		
		//poll from queue
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			char c = q.poll();
			for (int i = 0; i<map.get(c); i++) {
				sb.append(String.valueOf(c));
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s = "ismplee";
		System.out.println(frequencySort(s));
		System.out.println(frequencySort2(s));
	}

}
