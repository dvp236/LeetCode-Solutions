package problems;


import sun.awt.image.ImageWatched;

import java.util.*;

public class CourseSchedule {

    //[[0,1]] -> to take course 0 you must finish course 1.
    public static boolean canTakeCourse(int n, int[][] prereq) {

        int[] indegree = new int[n];

        for (int[] p : prereq) {
            indegree[p[0]]++;
        }
        int[] topological = new int[n];

        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++)  {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int count = q.size();
        int idx = 0;
        while (!q.isEmpty()) {
            int parent = q.poll();
            topological[idx++] = parent;
            for (int i = 0 ; i< prereq.length; i++) {
                int[] pair = prereq[i];
                //pair[1] is parent
                if (pair[1] == parent) {
                    //reduce child's indegree
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0) {
                        count++;
                        q.add(pair[0]);
                    }
                }
            }
        }

        return count == n;
    }

    //[0,1] -> to take 0 you have to finish 1
    public static boolean canTakke1(int n, int[][] preq) {
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();


        for (int[] pair : preq) {
            indegree[pair[0]]++;
            if (!graph.containsKey(pair[1])) graph.put(pair[1], new ArrayList<>());
            graph.get(pair[1]).add(pair[0]);
        }

        Deque<Integer> q = new LinkedList<>();

        for (int i = 0 ; i < indegree.length; i++) {
            if ( indegree[i] == 0) {
                q.add(i);
            }
        }
        int count = q.size();

        while (!q.isEmpty()) {
            int p  = q.poll();

            if (graph.containsKey(p)) {
                for (int c : graph.get(p)) {
                    indegree[c]--;
                    if (indegree[c] == 0) {
                        q.add(c);
                        count++;
                    }
                }
            }

        }

        return count == n;
    }

    public static void main(String[] args) {
        System.out.println("Hello");

        int[][] preq = new int[][]{
                new int[] {0,1},
                new int[] {1,2},
                new int[] {2,3},
        };

        System.out.println(canTakeCourse(4,preq));

        System.out.println(canTakke1(4, preq));
    }
}
