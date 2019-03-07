package problems;

import java.util.Arrays;

/**
 * 
 * @author dharmik
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * determine if a person could attend all meetings.
 *
 */
//https://leetcode.com/problems/meeting-rooms/
class Interval {
	int start;
	int end;	
	public Interval() {
		this.start = 0;
		this.end = 0;
	}
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class MeetingRooms {
	
	//bruteforce 
	// complexity: O(n^2)
	public static boolean canAttendAll(Interval[] intervals) {
		for (int i = 0; i < intervals.length; i++) {
			for (int j=i+1; j < intervals.length; j++)
				if (isOverlap(intervals[i], intervals[j])) return false;
		}
		return true;
	}
	//[0,30], [15,20], [5,10]
	private static boolean isOverlap(Interval i1, Interval i2) {
		return ((i1.start >= i2.start && i1.start < i2.end)
		         || (i2.start >= i1.start && i2.start < i1.end));
	}
	
	//complexity- O(nlogn)
	public static boolean canAttendAll2(Interval[] intervals) {
		Arrays.sort(intervals, (i1,i2)->i1.start - i2.start);
		
		for (int i = 0; i < intervals.length - 1 ; i++) {
			if (intervals[i].end > intervals[i+1].start) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Interval[] intvs = new Interval[]
				{
						new Interval(0,30),
						new Interval(5,10),
						new Interval(15, 20)
				};
		Interval[] intvs1 = new Interval[]
				{
						new Interval(7,10),
						new Interval(2,4)
				};
		System.out.println(canAttendAll(intvs));
		System.out.println(canAttendAll(intvs1));
		System.out.println(canAttendAll2(intvs));
		System.out.println(canAttendAll2(intvs1));
	}

}
