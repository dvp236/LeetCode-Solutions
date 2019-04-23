package problems;

public class BuySellStock {
	
	public static int maxProfit(int[] prices) {
		int profit = 0;
		int min = prices[0];
		int max = prices[0];
		
		for (int i = 0 ; i < prices.length; i++ ) {
			
			if (prices[i] < min) {
				min = prices[i];
				max = prices[i];
			}
			if (prices[i] > max) {
				max = prices[i];
				profit = Math.max(profit, max -min);
			}
		}
		
		
        return profit;
    }
	
//	public static int buysell2(int[] a) {
//		int profit = 0;
//		int min = a[0];
//		int max = a[0];
//		
//		for (int i = 0; i < a.length; i++) {
//			
//		}
//		
//	}
	public static void main(String[] args) {
		System.out.println("BuySell Leetcode");
		int[] prices = new int[]{3,4,7,2,5,9,1,7};
		System.out.println(maxProfit(prices));
//		System.out.println(buysell2(prices));
	}
	
}
