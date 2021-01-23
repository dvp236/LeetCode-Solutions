package problems;


import java.util.*;

//https://leetcode.com/discuss/interview-question/374846/Twitter-or-OA-2019-or-University-Career-Fair/338400
public class UniversityCareerFair {

    private static int maxEvents(int[] arrival, int[] duration) {
        int[][] events = new int[arrival.length][2];
        for(int i=0;i<arrival.length;i++) {
            events[i] = new int[] {arrival[i], arrival[i] + duration[i]};
        }
        Arrays.sort(events, (a, b)->(a[1] - b[1]));
        Queue<int[]> minHeap = new PriorityQueue<>((a, b)->a[1] - b[1]);
        int[] first = events[0];
        for(int i=1;i<events.length;i++) {
            int[] cur = events[i];
            if(cur[0] < first[1])
                minHeap.offer(cur);
            else {
                first[1] = events[i][1];
            }
        }
        return arrival.length - minHeap.size();
    }

    public static int maxEvents1(int[] arrival, int[] duration) {

        List<Interval> intervals = new ArrayList<>();

        for (int i =0; i < arrival.length; i++) {
            intervals.add(new Interval(arrival[i], arrival[i]+duration[i]));
        }

        intervals.sort((a,b) -> {
            return a.end - b.end;
        });

        int result = 1;
        int curr = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (curr <= intervals.get(i).start) {
                result++;
                curr = intervals.get(i).end;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = new int[] {1,2,3};
        int[] arrival = new int[] {1,3,3,5,7};
        int[] duration = new int[] {2,1,2,2,2}; //4

        int[] ar1 =  new int[] {1,2,3,5,6,7};
        int[] du1 = new int[] {4,1,1,5,1,1}; //4

        int[] aa = new int[]{1,1,1,1,4};
        int[] dd = new int[]{10,3,6,4,2}; //2
        System.out.println(maxEvents1(arrival, duration));
        System.out.println("hello");
        System.out.println(maxEvents1(ar1,du1));
        System.out.println(maxEvents1(aa,dd));
    }
}
