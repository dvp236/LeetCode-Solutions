package problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * @author dharmik
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.
 *
 */
//https://leetcode.com/problems/meeting-rooms-ii/


public class MeetingRooms2 {
	
	public static int minMeetingRoomRequired2(Interval[] intervals) {
		PriorityQueue<Interval> pq = new PriorityQueue<>((i1,i2)->i1.end -i2.end);
		Arrays.sort(intervals,(i1,i2)->i1.start-i2.start);
		pq.add(intervals[0]);
		for (int i=1; i<intervals.length; i++) {
			Interval last = pq.peek();
			if (last.end <= intervals[i].start) {
				pq.poll();
			}
			pq.add(intervals[i]);
		}
		return pq.size();
		
	}
	
	public static int minMeetingRoomRequired(Interval[] intervals) {
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i=0; i < intervals.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		
		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms=0;int sp=0; int ep=0;
		//track start and end pointers.. 
		while(sp < starts.length) {
			if (starts[sp] >= ends[ep]) {
				rooms-=1;
				ep++;
			} 
			rooms++;
			sp++;
		}
		return rooms;
	}
//	public static int minMeetingRoomRequired(Interval[] intervals) {
//		Arrays.sort(intervals, (i1,i2)->i1.start - i2.start);
//		int count = 1;
//		for (int i=0; i<intervals.length-1; i++) {
//			if (isOverlap(intervals[i], intervals[i+1])) count++;
//		}
//		return count;
//			
//	}
//	
//	private static boolean isOverlap(Interval i1, Interval i2) {
//		return (i1.end > i2.start);
//	}
	public static void main(String[] args) {
		System.out.println("bhumi");
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
		Interval[] intvs2 = new Interval[]
				{
						new Interval(5,8),
						new Interval(6,8)
				};
		
		System.out.println(minMeetingRoomRequired(intvs2));
		System.out.println(minMeetingRoomRequired2(intvs2));
	}

}
