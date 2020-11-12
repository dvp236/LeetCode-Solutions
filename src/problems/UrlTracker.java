package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class UrlTracker {
	
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	public void visit(String url) {
		map.put(url, map.getOrDefault(url, 0)+1);
	}
	
	public ArrayList<String> getTop3() {
		PriorityQueue<String> q = new PriorityQueue<>((u1,u2)->map.get(u1) - map.get(u2));
		for(String url: map.keySet()) {
			q.offer(url);
			if (q.size() > 3) {
				q.poll();
			}
		}
		ArrayList<String> result = new ArrayList<String>();
		while(!q.isEmpty()) result.add(q.poll());
		
		Collections.reverse(result);
		
		return result;
		
	}
	

	public static void main(String[] args) {
		UrlTracker u = new UrlTracker();
		u.visit("google.com");
		u.visit("google.com");
		u.visit("google.com");
		u.visit("google.com");
		u.visit("google.com");
		u.visit("google.com");
		u.visit("fb.com");
		u.visit("fb.com");
		u.visit("fb.com");
		u.visit("fb.com");
		u.visit("fb.com");
		u.visit("fb.com");
		u.visit("fb.com");
		u.visit("fb.com");
		u.visit("fb.com");
		u.visit("amzn.com");
		u.visit("amzn.com");
		u.visit("amzn.com");
		u.visit("amzn.com");
		u.visit("amzn.com");
		u.visit("amzn.com");
		u.visit("amzn.com");
		u.visit("amzn.com");
		u.visit("amzn.com");
		u.visit("amzn.com");
		u.visit("amzn.com");
		u.visit("amzn.com");
		u.visit("smthing");
		u.visit("tech.com");
		u.visit("tech.com");
		for(String url: u.getTop3()) {
			System.out.println(url);
		}
	}

}
