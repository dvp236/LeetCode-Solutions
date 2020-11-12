package problems;

import java.util.*;

public class RandomPickWithBlacklist {

    Map<Integer,Integer> map;
    int whitelistLength;
    Random r;
    public RandomPickWithBlacklist(int n, int[] blacklist) {
        this.map = new HashMap<>();
        this.whitelistLength = n-blacklist.length;
        r = new Random();

        Set<Integer> lastB = new HashSet<>();
        for (int i = whitelistLength; i < n; i++) lastB.add(i);

        for (int b: blacklist) lastB.remove(b);
        Iterator<Integer> iter = lastB.iterator();

        for (int b: blacklist) {
            if (b < whitelistLength) {
                map.put(b, iter.next());
            }
        }
    }

    public int pick() {
        int idx = r.nextInt(this.whitelistLength);
        return map.getOrDefault(idx, idx);
    }

    public static void main(String[] args) {
        System.out.println("Jay Swaminarayan!!");
        RandomPickWithBlacklist ob = new RandomPickWithBlacklist(10, new int[]{2,4,3,8});
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            int pick = ob.pick();
            map.put(pick, map.getOrDefault(pick, 0)+1);
        }

        for (int k: map.keySet()) {
            System.out.println("index -"+k+"  count - "+map.get(k));
        }
    }
}
