package problems;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/last-stone-weight/
public class LastStoneWeight {

    //O(nlogn) solution. Easy to understand. first attempt.
    public static int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int a : stones) {
            q.add(a);
        }

        while (q.size() != 1) {
            int bigger = q.poll();
            int big = q.poll();

            int smash = bigger - big;
            //minor imporvement -> when smash = 0, dont add to queue. change while condition.
            q.add(smash);
        }

        return q.poll();
    }

    //implement bucket sort solution.
    //O(n) but this performs well if we have more stones
    public static int lastStoneWieght2(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];

        int max = 0;
        for (int i = 0; i < stones.length; i++) {
            max = Math.max(max, stones[i]);
        }

        int[] bucket = new int[max+1];
        //2, 7, 4, 1, 8, 1
        for (int i = 0 ; i < stones.length; i++) {
            bucket[stones[i]]++;
        }
        System.out.println("bucket"+Arrays.toString(bucket));
        int i = max;
        while(i > 0) {
            int smash = bucket[i] % 2;
            if (smash != 0) {
                int j = i - 1;
                while ( j > 0 && bucket[j] == 0 ) j--;

                if (j == 0) return i;
                bucket[j]--;
                bucket[i-j]++;
            }
            i--;
        }
        return 0;
    }

    //O(n^2lonn). only good for small input. i.e really small input
    public static int lastStoneWeightWrost(int[] stones) {
        Arrays.sort(stones);

        for (int i = stones.length - 1; i > 0; i--) {
            stones[i-1] = stones[i] - stones[i-1];
            Arrays.sort(stones);
        }

        return stones[0];
    }

    public static void main(String[] args) {
        System.out.println("Jay Swaminarayan!");
        int[] a = new int[]{2, 7, 4, 1, 8, 1};
//        System.out.println(lastStoneWeight(a));
//        System.out.println(lastStoneWeightWrost(a));
        System.out.println(lastStoneWieght2(a));
    }

}
