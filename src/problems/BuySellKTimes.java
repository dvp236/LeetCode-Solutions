package problems;

import java.util.ArrayList;
import java.util.List;

public class BuySellKTimes {

    //idea is find all eligible transactions
    //then remove the transactions one by one until we are at k.
    public static int getProfit(int[] a, int k) {

        List<int[]> transactions = new ArrayList<>();
        int start = 0; int end = 0;
        for (int i = 1; i < a.length; i++) {
            //keep updating end until we reach peak
            if (a[i] >= a[i-1]) {
                end = i;
            } else {
                if (end > start) {
                    transactions.add(new int[]{a[start], a[end]});
                }
                start = i;
            }
        }

        if (end> start){
            transactions.add(new int[]{a[start], a[end]});
        }

        while (transactions.size() > k) {

            int min_profit  = Integer.MAX_VALUE;
            int minIdx = 0;

            for (int i =0; i < transactions.size(); i++) {
                int[] t = transactions.get(i);
                int profit = t[1] - t[0];
                if (profit < min_profit) minIdx = i;
                min_profit = Math.min(min_profit, profit);

            }

            int min_merge = Integer.MAX_VALUE;
            int merg_idx = 0;

            for (int i = 1; i < transactions.size(); i++) {
                int[] t = transactions.get(i);
                int merge = transactions.get(i-1)[1] - t[0];
                if (merge < min_merge) merg_idx = i;
                min_merge = Math.min(min_merge, merge);
            }

            if (min_profit <= min_merge) {
                transactions.remove(minIdx);
            } else {
                transactions.get(merg_idx - 1)[1] = transactions.get(merg_idx)[1];
                transactions.remove(merg_idx);
            }
        }
        int profit = 0 ;
        for (int[] t : transactions) {
            profit+= t[1] - t[0];
        }

        return profit;
    }

    public static int getProfitPrac(int[] a, int k) {
        List<int[]> ts = new ArrayList<>();
        int start = 0; int end = 0;
        for (int i =1; i < a.length; i++) {
            if (a[i] > a[i-1]) {
                end = i;
            } else {
                if (end > start) {
                    ts.add(new int[] {a[start], a[end]});
                }
                start = i;
            }
        }
        if (end > start) {
            ts.add(new int[] {a[start], a[end]});
        }

        while (ts.size() > k) {
            int min_profit = Integer.MAX_VALUE;
            int minIdx = 0;

            for (int i = 0; i < ts.size(); i++ ) {
                int[] t = ts.get(i);
                int profit = t[1] - t[0];
                if (profit < min_profit) {
                    min_profit = profit;
                    minIdx = i;
                }
            }

            int min_merg = Integer.MAX_VALUE;
            int mergIdx = 0;
           //
            //
            // for (int i = 0; )
        }

        // complete later
        return 0;
    }


    public static void main(String[] args) {
        System.out.println("Jsn!");
        int[] a = new int[]{2,4,1};
        int[] b = new int[] {3,2,6,5,0,3};

        System.out.println(getProfit(a, 2));
        System.out.println(getProfit(b,2));

    }
}
