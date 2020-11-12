package problems;

import java.lang.reflect.Array;
import java.util.*;

public class LongestStringChain {

    private static boolean isPred(String pred, String s) {
        System.out.println("checking - "+pred+" "+s);
        char[] pchar = pred.toCharArray();
        char[] schar = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        //abc , defg
        for (char c: schar) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for (char c: pchar) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) -1);
            }
        }

        int sum = map.values().stream().reduce((a,b) -> a+b).get();

        return sum == 1;
    }
    private static int getPredCount(Map<String, Integer> chain, String st, Map<Integer, List<String>> helper) {
        if (!helper.containsKey(st.length() - 1)) return 0;
        int max = 0;
        for(String candi: helper.get(st.length() - 1)) {
            if (isPred(candi, st)) {
                max = Math.max(max, chain.get(candi));
            }
        }
        return max;
    }
    public static int count(String[] a) {
        Arrays.sort(a, (p,q)->p.length() - q.length());
        Map<String, Integer> chain = new HashMap<>();
        Map<Integer, List<String>> helper = new HashMap<>();
        for (String s: a) {
            if (!helper.containsKey(s.length())) helper.put(s.length(), new ArrayList<>());

            int res = getPredCount(chain, s, helper)+1;
            chain.put(s, res);
            helper.get(s.length()).add(s);

        }
        System.out.println(chain);

        int max = chain.values().stream().max(Comparator.naturalOrder()).get();
        return max;
    }


    public static int getMaxCount(String[] a) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(a, (c,b)-> c.length() - b.length());
        int max = 0;
        for (String s: a) {
            map.put(s, 1);

            for (int i =0 ; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                String prev = sb.toString();
                if (map.containsKey(prev) && map.get(s) < map.get(prev) + 1) {
                    map.put(s, map.get(prev) + 1);
                    max = Math.max(max, map.get(s));
                }
            }
        }

        return max;
    }
    public static void main(String[] args) {
        System.out.println("Jay Swaminarayan!");

        StringBuilder sb = new StringBuilder("a");
        Map<String, Integer> chain = new HashMap<>();
        chain.put(" ", 0);
        String[] a = new String[] {"a","b","ba","bca","bda","bdca"};
        System.out.println();

        //System.out.println(sb.deleteCharAt(0));
        System.out.println("---^^---");






        //7
        String[] b = new String[] {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
    //    System.out.println(count(b));

       // System.out.println(isPred("a", "ab"));

        System.out.println(getMaxCount(a));
        System.out.println(getMaxCount(b));
        String[] c = new String[]{"a", "ab", "abc"};
        System.out.println(getMaxCount(c));
    }
}
