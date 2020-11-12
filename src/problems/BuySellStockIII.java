package problems;


//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class BuySellStockIII {

    //Return max profit in one transaction
    public static int buysell1(int[] a) {
        int min = a[0];
        int profit = 0;
        for (int i = 0 ; i < a.length; i++) {
            min = Math.min(min, a[i]);
            profit = Math.max(profit, a[i] - min);
        }

        return profit;
    }

    //You can do multiple transaction
    //return max profit
    public static int buysell2(int[] a) {
        int profit = 0;

        //calculate profit at each step..
        //if positive profit then add to profit...
        for (int i = 1; i < a.length; i++) {
            if (a[i-1] < a[i]) {
                profit += (a[i] - a[i-1]);
            }
        }

        return profit;
    }

    //Atmost 2 transaction
    // 2 or less //2 5 8 1 4 2 11
    public static int buysell3(int[] a) {
        int t1min = Integer.MAX_VALUE;
        int t1Profit = 0;
        int t2min = Integer.MAX_VALUE;
        int totalProfit = 0;

        for (int i = 0; i < a.length; i++) {
            t1min = Math.min(t1min, a[i]); //2 - - 1
            t1Profit = Math.max(t1Profit, a[i] - t1min); //0 3 6 - 3 10

            //now calculate t2min such that it takes t1 profit into account. This way you have
            //max t1 profit contributing to lowest t2min -> which will produce Max totalProfit
            //with 2 transaction atmost. //kinda like extending profit
            t2min = Math.min(t2min, a[i] - t1Profit);//2 2 - -5
            totalProfit = Math.max(totalProfit, a[i] - t2min);//0 3 6 6 9 16
        }

        return totalProfit;

    }


    public static int buySell(int[] a) {
        return 0;
    }
    public static void main(String[] args) {
        System.out.println("Jay Swaminarayan!!");

        int[]  a= new int[] {7,1,5,3,6,4};
        int[] b = new int[] {7,6,4,3,1};
        System.out.println(buysell1(a));
        System.out.println(buysell1(b));

        System.out.println("------");
        int[] c = new int[]{1,2,3,4,5};
        System.out.println(buysell2(a)); // 7
        System.out.println(buysell2(c));
        System.out.println(buysell2(b));


        System.out.println("----------");
        int[] d = new int[] {1,8,3,3,5,0,0,9,1,4};
        System.out.println(buysell3(d));
        System.out.println(buysell3(c));
        System.out.println(buysell3(new int[]{2,5,8,1,4,2, 11}));
    }
}
