package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoCityScheduling {

    public static int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int total = 0;
        for (int i = 0; i < costs.length; i++) {
            total += costs[i][0];
        }

        int[] refund = new int[costs.length];
        for (int i =0; i < costs.length; i++) {
            refund[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(refund);
        for (int i = 0; i < costs.length / 2; i++ ){
            total += refund[i];
        }
        return total;
    }


    //use relative difference in cost.. sort array by relative cost
    public static int ty1(int[][] costs) {
        System.out.println(Arrays.deepToString(costs));
        //here we are taking a difference of costs of going to A and B
        //the array is sorted in a such way that the first half is should be sent to A
        //and the second half should go to B.
        //since
        Arrays.sort(costs, (a,b)-> {
            return a[0] - a[1] - (b[0] - b[1]); });
        int N = costs.length / 2;
        int total = 0;
        for (int i = 0; i < costs.length; i++) {
            total += i < N ? costs[i][0] : costs[i][1];
        }
        return total;
    }

    //implement DP


    public static void main(String[] args) {
        System.out.println("Jay Swaminarayan!");

        int[][] a = new int[][]{ new int[] {10,20},
                                new int[]{30,200},
                new int[]{400,50},
                new int[]{30,20}
        };
        System.out.println(twoCitySchedCost(a));

        //[[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]  --> 1859
        //[[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]

        int[][] b = new int[][] { new int[] {259,770},
        new int[]{448,54},
        new int[]{926,667},
        new int[]{184,139},
        new int[]{840,118},
        new int[]{577,469}};

        System.out.println(twoCitySchedCost(b));

        System.out.println(ty1(a));
        System.out.println(ty1(b));
    }
}
