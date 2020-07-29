package problems;

public class StockMaximizeHR {

    /**
     *
     * @param prices
     * @return maxProfit
     *
     * Here we will start from the end and try to find the local max peak.
     * As we go left we will log in the profit if the price is lower than the peak.
     * If we find another peak we will store the result in accumulator and reset the local profit.
     */
    public static int profit(int[] prices) {
        int result = 0;
        int acc = 0;
        int localmx = Integer.MIN_VALUE;
        //1,3,1,2,7,5,1,3
        //1,2 100

        for (int i = prices.length -1; i >= 0; i--) {
            if (prices[i] < localmx) {
                result += (localmx - prices[i]);

            } else {
                localmx = prices[i];
                acc += result;
                result = 0;
            }
        }

        return acc+result;
    }
    public static void main(String[] args) {
        int[] pr = new int[]{1,3,1,2,7,5,1,3}; //15
        int[] p = new int []{1,2,100};
        int[] a = new int[]{1,3,1,2};
        int[] b = new int[]{1,5,1,10,9,2,4};
        System.out.println(profit(b));
    }
}
