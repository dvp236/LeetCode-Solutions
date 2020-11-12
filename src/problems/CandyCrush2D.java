package problems;

import java.util.Arrays;

public class CandyCrush2D {

    private static void crushColumn(int r, int c, int k, int[][] board) {
        while (r >= 0) {
            if (r - k < 0) {
                board[r][c] = 0;
            } else {
                board[r][c] = board[r-k][c];
            }
            r--;
        }
    }

    private static void crushRow(int r, int c, int k, int[][] board) {
        for (int i = c; i > c - k; i--) {
            crushColumn(r, i, 1, board);
        }
    }
    public static void crush(int[][] board) {
        boolean crushed = false;
        for (int j =0 ; j < board[0].length; j++) {
            for (int i = 0; i < board.length; i++) {
                int v = board[i][j];
                int cnt = 1;
                while (v != 0 && i + 1 < board.length && v == board[i+1][j]) {
                    i++;
                    cnt++;
                }
                if (cnt >= 3) {
                    while(cnt > 0) board[i + 1 - cnt--][j] = -v;
                    crushed = true;
                }
            }
        }

        for (int i= 0; i < board.length; i++) {
            for (int j =0 ; j < board[0].length; j++) {
                int v = Math.abs(board[i][j]);
                int cnt = 1;
                while (v != 0 && j + 1 < board[0].length && v == Math.abs(board[i][j+1])) {
                    j++;
                    cnt++;
                }

                if (cnt >= 3) {
                    while (cnt > 0) {
                        if (board[i][j+1 -cnt] > 0)
                            board[i][j+1 - cnt] = -v;
                        cnt--;
                    }
                    crushed = true;
                }
            }
        }
//        System.out.println("=================");
//        for (int[] a : board) {
//            System.out.println(Arrays.toString(a));
//        }
//        System.out.println("=================");
        //0 1 2 --> 1 2 3
        for (int j = 0; j < board[0].length; j++) {
            int ar = board.length - 1;

            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][j] > 0) {
                    board[ar--][j] = board[i][j];
                }
            }

            while(ar >=0 ) {
                board[ar--][j] = 0;
            }
        }



        if(crushed) {
            crush(board);
        }

    }

    public static void main(String[] args) {
        System.out.println("Jay Swaminarayan!");
        int[][] board = new int[][] {
                new int[] {1,2,3,4,5,6},
                new int[] {1,1,1,4,5,6},
                new int[] {1,2,3,3,5,5},
                new int[] {6,7,7,9,9,2},
                new int[] {8,8,8,8,8,8}
        };
        for (int[] a : board) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("----");
        crush(board);
        for (int[] a : board) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("------------------");
        System.out.println(Arrays.deepToString(board));
    }
}
