package problems;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/moving-average-from-data-stream/
public class MovingAverageFromDataSteram {
	private int windowSize;
	private int sum;
	private Deque<Integer> dq;
	public MovingAverageFromDataSteram(int windowSize) {
		this.windowSize = windowSize;
		this.dq = new LinkedList<>();
		this.sum = 0;
	}
	
	public double next(int val) {
		if (dq.size() < windowSize) {
			sum += val;
			dq.addLast(val);
			return (double) sum/dq.size();
		}
		sum -= dq.pollFirst();
		sum += val;
		dq.add(val);
		return (double) sum/windowSize;
	}
	
	
	public static void main(String[] args) {
		MovingAverageFromDataSteram mv = new MovingAverageFromDataSteram(3);
		System.out.println(mv.next(1));
		System.out.println(mv.next(2));

		System.out.println(mv.next(3));

		System.out.println(mv.next(4));
		System.out.println(mv.next(5));
		System.out.println(mv.next(6));
		System.out.println(mv.next(7));
		
		System.out.println(mv.next(7));
		System.out.println(mv.next(7));
		System.out.println(mv.next(7));


		
	}
	

}
