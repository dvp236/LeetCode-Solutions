package problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @author dharmik
 * 
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. 
 * If two words have the same frequency, then the word with the 
 * lower alphabetical order comes first.
 *
 */
public class TopKFrequentWords {
	
	public static List<String> getTopKFrequent(String[] words, int k) {
		HashMap<String, Integer> map = new HashMap<>();
		for (String word: words) {
			int count = 1;
			if(map.containsKey(word)) {
				count = map.get(word);
				count++;
			}
			map.put(word, count);
		}
		//have to take minheap here
		PriorityQueue<String> heap = new PriorityQueue<>(
				(w1,w2) -> map.get(w1) == map.get(w2) ? w2.compareTo(w1) : map.get(w1) - map.get(w2)
				);
		
		for (String key: map.keySet()) {
			heap.offer(key);
			if (heap.size() > k) heap.poll();
		}
		
		List<String> result = new ArrayList<String>();
		
		while(!heap.isEmpty()) {
			result.add(heap.poll());
		}
		Collections.reverse(result);
		return result;
	}

	public static void main(String[] args) {
		System.out.println("Jsn!");
		
		String[] words = new String[]{"a","c","c","b","a","b"};
		List<String> res = getTopKFrequent(words, 2);
		for (String word: res) {
			System.out.println(word);
		}
	}

}
