package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class RandomPickWithWeight {

    int[] weights;
    int[] prefixSum;
    int N;
    Random rand;

    public RandomPickWithWeight(int[] weights) {
        this.rand = new Random();
        this.N = weights.length;
        this.weights = weights;
        this.prefixSum = new int[weights.length];
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            this.prefixSum[i] = sum;
        }
    }
    // 1,2,5
    // 1 3 8
    public int pick() {
        int randSum = rand.nextInt(prefixSum[N - 1]) + 1;
        return binsrch(prefixSum, randSum);
    }

    //    // 1 3 8 15 20 25 30//17
    private static int binsrch(int[] prefixSum, int randSum) {
        int lo = 0; int hi = prefixSum.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (prefixSum[mid] == randSum) {
                return mid;
            }
            if (mid - 1>=0 && prefixSum[mid -1] < randSum && randSum < prefixSum[mid] ) {
                return mid;
            }

            if (prefixSum[mid] > randSum) {
                hi = mid -1;
            }
            else {
                lo = mid+1;
            }
        }

        return hi;
    }

    public static void main(String[] args) {
        RandomPickWithWeight pick = new RandomPickWithWeight(new int[]{1,1,4,9,5,10,2});
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <1000; i++) {
            int idx  = pick.pick();
            map.put(idx, map.getOrDefault(idx,0)+1);
        }

        for (Integer k : map.keySet()) {
            System.out.println("idx - "+k+"  count - "+map.get(k));
        }
//        System.out.println(binsrch(new int[]{1,2,6,15,20,30}, 1));
//        System.out.println(binsrch(new int[]{1,2,6,15,20,30}, 2));
//        System.out.println(binsrch(new int[]{1,2,6,15,20,30}, 3));
//        System.out.println(binsrch(new int[]{1,2,6,15,20,30}, 7));
//        System.out.println(binsrch(new int[]{1,2,6,15,20,30}, 17));
//        System.out.println(binsrch(new int[]{1,2,6,15,20,30}, 30));



    }

}
