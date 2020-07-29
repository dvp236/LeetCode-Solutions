package problems;

import java.util.Arrays;

//https://www.geeksforgeeks.org/check-destination-reachable-source-two-movements-allowed/
public class DestinationReachable {
    public static boolean isReachable(int x, int y, int x1, int y1) {
        if (x == x1 && y == y1) {
            return true;
        }

        if (x > x1 || y > y1) {
            return false;
        }

        return isReachable(x,x+y, x1, y1) || isReachable(x+y, y, x1, y1);
    }

    //the idea here is simple
    //if we think the other way, The possibility to reach
    //x,y point is through x-y, y or x, y-x
    //and create a DP.
    public static boolean isReachableDP(int x, int y, int x1, int y1) {
        if (x1 < x || y1 < y) return false;
        boolean dp[][] = new boolean[x1+1][y1+1];
        dp[x][y] = true;
        for (int i = 0; i <= x1; i++) {
            for (int j = 0; j <= y1; j++) {
                if ((i-j >= 0 && dp[i-j][j]) || (j-i >= 0 && dp[i][j-i])) {
                    dp[i][j] = true;
                }
            }
        }

//        System.out.println(Arrays.toString(dp));
        return dp[x1][y1];
    }
    public static void main(String[] args) {
        System.out.println(isReachable(2,10, 26, 12));
        System.out.println(isReachableDP(2,10,26,12));
        System.out.println("---");
        System.out.println(isReachable(1,2, 4, 2));
        System.out.println(isReachableDP(1,2,4,2));
        System.out.println("----");
        System.out.println(isReachable(10,20, 1, 2));
        System.out.println(isReachableDP(10,20,1,2));
    }
}
