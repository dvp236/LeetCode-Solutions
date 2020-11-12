package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @author dharmik
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
	
	//O(nlog(k))
	public static void topK(int[] a, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<>((a1,a2)->map.get(a1)-map.get(a2));		
		for (int key : map.keySet()) {
			q.offer(key);
			if (q.size() > k) q.poll();
		}
		
		ArrayList<Integer> result = new ArrayList<>(k);
		while (!q.isEmpty()) result.add(q.poll());
		
		Collections.reverse(result);
		int[] res = result.stream().mapToInt(i->i).toArray();
		System.out.println(Arrays.toString(res));
		
	}
	
	//O(nlogn) 
	public static void topk2(int[]  a, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		list.addAll(map.keySet());
		
		Collections.sort(list,(a1,a2)->map.get(a2)-map.get(a1));
		List<Integer> res = list.subList(0,Math.min(k, map.size()));
		System.out.println(Arrays.toString(res.toArray()));
	}
	
	//the one without using Queue ans still efficient
	//O(n) - but space inefficient. o(n)
	public static void topk3(int[] a, int k) {
		HashMap<Integer, Integer> freq = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			freq.put(a[i], freq.getOrDefault(a[i], 0) + 1);
		}
		
		//a.lenght+1 necessary - what if array has only one element -then freq will be 1, so we need bucket[1] to be available
		// or what if all the array elements are same. then also we need bucket[a.length] to be available
		List<Integer>[] bucket = new List[a.length+1];
		
		for(int key: freq.keySet()) {
				if (bucket[freq.get(key)] == null) bucket[freq.get(key)] = new LinkedList<>();
				bucket[freq.get(key)].add(key);	
		}
		
		ArrayList<Integer> res = new ArrayList<>();
		for(int i = bucket.length - 1; i >= 0&&res.size() < k; i--) {
			if (bucket[i] != null) {
				//shouldnt do add all.. instead only add k-res.size()
				if(k - res.size() >= bucket[i].size()) {
					res.addAll(bucket[i]);
				} else {
					int len = k - res.size();
					res.addAll(bucket[i].subList(0,len));
				}
			}
		}
		
		System.out.println(Arrays.toString(res.toArray()));
		
		
	}
	
	public static String sortCharactersByFrequency(String st) {
		HashMap<Character, Integer> freq = new HashMap<>();
		for (int i =0; i < st.length(); i++) {
			freq.put(st.charAt(i), freq.getOrDefault(st.charAt(i), 0)+1);
		}
		
		// we can either use bucket or priorityQueue
		PriorityQueue<Character> q = new PriorityQueue<>((c1,c2)->freq.get(c2)-freq.get(c1));
		for (char key: freq.keySet()) q.add(key);
		
		String res = "";
		while(!q.isEmpty()) {
			char c = q.poll();
			int cfreq = freq.get(c);
			for (int i=0; i < cfreq; i++) res+=c;
		}
		return res;
	}
	
	public static void main(String[] args) {
//		System.out.println("Siddhi tene jai vare, je parseve nhay");
//		
//		int[] a =  new int[] {1,1,1,1,22,2,2,2,2,2,2,2,3,3,3,4,4,4,5};
		int[] a = new int[]{1,1,1,1,1,1,1,1};
		topK(a, 2);
		topk2(a,2);
		topk3(a,2);
		
		System.out.println(sortCharactersByFrequency("Aabb"));
		
	}

}
 