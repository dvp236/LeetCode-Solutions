package problems;

public class Leaderboard {


    /**
     * 1 . Use Map for playerid to score
     *  -then for topK
     *     1 -> sort map.values() -O(NlogN)
     *     2 -> use priorityQueue add only k items in it -> O(NlogK)
     *
     *
     * 2. Use Map for playerID to score
     *  - use TreeMap for score, times
     *
     *   addScore will be logN
     *   topK will be k.logN
     *   reset will be logN
     */

    class Player {
        int id;
        int score;
    }
//    Map<P>
    public Leaderboard() {

    }

    public void addScore(int playerId, int score) {

    }

    public int top(int K) {
        return 0;
    }

    public void reset(int playerId) {

    }
    
}
