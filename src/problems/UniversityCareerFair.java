package problems;

import sun.security.util.ArrayUtil;

import java.util.*;

//https://leetcode.com/discuss/interview-question/374846/Twitter-or-OA-2019-or-University-Career-Fair/338400
public class UniversityCareerFair {

    public static int maxEvents(int[] arrival, int duration[]) {

        List<Interval> intervals = new ArrayList<>();

        for (int i =0; i < arrival.length; i++) {
            intervals.add(new Interval(arrival[i], arrival[i]+duration[i]));
        }

        intervals.sort((a,b) -> {
            if (a.start != b.start) {
                return a.start - b.start;
            } else {
                return a.end - b.end;
            }
        });

        // 1 3, 3 4, 3 5, 5 7 , 7 9


        //1 2 3 5 6 7
        //4 1 1 5 1 1
        // 1 5, 2 3, 3 4, 5 10, 6 7, 7 8
        int result = 1;
        for (int i = 0 ; i < arrival.length -1; i++) {
            if (intervals.get(i).end <= intervals.get(i+1).start) {
                result++;
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
        System.out.println(maxEvents(arrival, duration));
        System.out.println("hello");
        System.out.println(maxEvents(ar1,du1));
    }
}
