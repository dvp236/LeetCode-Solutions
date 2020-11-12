package problems;


import java.util.LinkedList;
import java.util.Queue;

public class RegularExpressionMatching {

    //aabbc - a*b*.

    private static boolean helper(Queue<Character> sq, Queue<Character> pq) {

        char prevS = '#';
        //ab  .*c
        while (!sq.isEmpty() && !pq.isEmpty()) {
            char pchar = pq.poll();
            if (sq.peek() == pchar) {
                sq.poll();
                prevS = pchar;
            } else {
                if (pchar == '.') {
                    sq.poll();
                    if (!sq.isEmpty())
                        prevS = sq.peek();
                } else if (pchar == '*') {
                    while(!sq.isEmpty() && sq.peek() == prevS){
                        sq.poll();
                    }
                } else {
                    if(!pq.isEmpty() && pq.peek()=='*') {
                        pq.poll();
                        continue;
                    }
                    return false;
                }
            }

        }

        return sq.isEmpty() && pq.isEmpty();
    }

    public static boolean match(String s, String p) {
        //p process
        char prev = s.charAt(0);
        for (int i =1; i < p.length() - 1; i++) {
            if (p.charAt(i) == '*') {
                if (prev == p.charAt(i+1)) {

                }
            }
        }
        Queue<Character> sq = new LinkedList<>();
        Queue<Character> pq = new LinkedList<>();
        for (char c:s.toCharArray()) sq.add(c);
        for (char c:p.toCharArray()) pq.add(c);
        return helper(sq, pq);
    }

    public static boolean isMatch1(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() > 1 && p.charAt(1) == '*') {  // second char is '*'

            //0 occurence of char
            if (isMatch1(s, p.substring(2))) {
                return true;
            }
            //for one or more occrence
            if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch1(s.substring(1), p);
            }
        } else {                                     // second char is not '*'
            if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch1(s.substring(1), p.substring(1));
            }
        }
        return false;
    }

    public static boolean matchfinal(String s, String p) {
        int sid = 0; int pid = 0; int starid = -1;int stmp = -1;

        while (sid < s.length()) {
            if (pid < p.length() && (p.charAt(pid) == '.' ||s.charAt(sid) == p.charAt(pid))) {
                sid++;
                pid++;
            }
            else if (pid < p.length() && p.charAt(pid) == '*') {
                starid = pid;
                stmp = sid;
                pid++;
            }else if (starid == -1) return false;
             else {
                pid = stmp;
                sid =stmp+1;
                stmp = sid;
            }
        }

        for (int i = pid ; i < p.length(); i++) {
            if (p.charAt(pid) != '*') return false;
        }

        return true;
    }

    public static boolean matchfinal1(String s, String p) {
        int sid  = 0; int pid = 0; int starid = -1; int stmp = -1;

        while (sid < s.length()) {

            if (pid < p.length() && (s.charAt(sid) == p.charAt(pid) || p.charAt(pid) == '.')) {
                sid++;
                pid++;
            } else if (pid < p.length() && p.charAt(pid) == '*') {
                starid = pid;
                stmp = sid;
                pid++;
            } else if (starid == -1) return false;
            else {
                pid = starid + 1;
                sid = stmp + 1;
                stmp = sid;
            }

        }

        for (int i = pid; i < p.length(); i++) {
            if (p.charAt(i) != '*') return false;
        }

        return true;
    }

    public static boolean rDp(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0]= true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i] = true;
            }
        }

        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0 ; j < p.length(); j++) {
                if (s.charAt(i)==p.charAt(j) || p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = dp[i+1][j-1] || dp[i+1][j] || dp[i][j+1];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
    public static void main(String[] args) {
        System.out.println("Jsn!");
//"mississippi"
//"mis*is*ip*."
        System.out.println(isMatch1("mississippi", "mis*is*ip*."));
        System.out.println(isMatch1("aab", "c*a*b*"));
        System.out.println(isMatch1("abc", ".*"));
        System.out.println(match("aabbbc","a.b*c"));
        System.out.println(isMatch1("ab", ".*c"));
        System.out.println(isMatch1("a", "a*aa"));

        System.out.println("--------");
        System.out.println(matchfinal1("aabbbc", "a.b*cc"));
        System.out.println(matchfinal1("mississippi", "mis*is*ip*."));

        System.out.println("----------");

        System.out.println(rDp("aabbbc", "a.b*cc"));
        System.out.println(rDp("mississippi", "mis*is*ip*."));
        System.out.println(rDp("ab", ".*"));
    }
}
