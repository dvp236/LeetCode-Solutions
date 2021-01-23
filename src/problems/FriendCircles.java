package problems;

import java.lang.reflect.Array;
import java.util.*;

public class FriendCircles {

    //case of connected components ->
    private static void dfs(int[][] M, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (!visited[j] && M[i][j] == 1)
                dfs(M,visited,j);
        }

    }
    public static int countCircle(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0 ; i  < M.length; i++) {
            for (int j= 0; j < M[0].length; j++) {
                if (!visited[i]) {
                    dfs(M, visited, i);
                    count++;
                }
            }
        }
//        for (boolean[] a : visited) System.out.println(Arrays.toString(a));
        return count;
    }

    private static void union(int[] parents, int i, int j) {
        int iroot = findRoot(parents, i);
        int jroot = findRoot(parents, j);
        if (iroot != jroot)
            parents[iroot] = jroot;
    }

    private static int findRoot(int[] parents, int a) {
        while (a != parents[a]) {
            parents[a] = parents[parents[a]];
            a = parents[a];
        }
        return a;
    }

    public static int countCircleUnionFind(int[][] M) {
        int[] parents = new int[M.length];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    union(parents, i, j);
                }
            }
        }

        int count = 0 ;
        for (int i = 0; i < parents.length; i++) {
            if (i == parents[i]) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println("Jay Swaminarayan!");
        //[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]  //answer 1
        int[][] b = new int[][] {
                new int[]{1,0,0,1},
                new int[]{0,1,1,0},
                new int[]{0,1,1,1},
                new int[]{1,0,1,1}
        };  // 1 4  // 2 3
        int[][] a = new int[][] {
                new int[] {1,1,0},
                new int[] {1,1,0},
                new int[] {0,0,1}
        };


        System.out.println(countCircle(a));
        System.out.println(countCircle(b));

        System.out.println(countCircleUnionFind(a));
        System.out.println(countCircleUnionFind(b));

    }
}
