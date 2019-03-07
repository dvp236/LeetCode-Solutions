package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author dharmik
 * 
 * 
 * Input: 
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.
 *
 */
public class KillProcess {

	public static ArrayList<Integer> killProcess2(ArrayList<Integer> pid, ArrayList<Integer> ppid, int kill) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		
		for(int i=0; i<ppid.size(); i++) {
			ArrayList<Integer> list = map.getOrDefault(ppid.get(i), new ArrayList<Integer>());
			list.add(pid.get(i));
			map.put(ppid.get(i), list);
		}
		//print map
//		for (Integer key: map.keySet()) {
//			ArrayList<Integer> list = map.get(key);
//			System.out.print(key+"-");
//			for (int i: list) {
//				System.out.print(i+" ");
//			}
//			System.out.println();
//		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(kill);
		ArrayList<Integer> result = new ArrayList<>();
		while(!q.isEmpty()) {
			int k = q.poll();
			if (map.containsKey(k)) {
				q.addAll(map.get(k));
			}
			//
			result.add(k);
		}
		
		return result;
		
		
	}
	
	//timecomplexity = O(n^n)
	public static ArrayList<Integer> killProcess(ArrayList<Integer> pid, ArrayList<Integer> ppid, int kill) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		result.add(kill);
		for (int i=0; i<ppid.size(); i++) {
			if (ppid.get(i)==kill) {
				result.addAll(killProcess(pid,ppid,pid.get(i)));
			}
		}
		return result;	
	}
	
	
	public static void main(String[] args) {
		System.out.println("Jsn");
		ArrayList<Integer> pid = new ArrayList<>(Arrays.asList(1,3,10,5));
		ArrayList<Integer> ppid = new ArrayList<>(Arrays.asList(3,0,5,3));
		ArrayList<Integer> result = killProcess(pid, ppid, 3);
		
		for(int i: result) {
			System.out.print(i+" ");
		}
		System.out.println();
		ArrayList<Integer> result1 =killProcess2(pid, ppid, 3);
		for(int i: result1) {
			System.out.print(i+" ");
		}


	}

}
