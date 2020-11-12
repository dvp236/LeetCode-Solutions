package problems;

import sun.misc.Queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {
    //Input: s = "3[a]2[bc]"
    //Output: "aaabcbc"
    public static String helper(Deque<Character> q) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(!q.isEmpty()) {
            char curr = q.poll();
            if (Character.isDigit(curr)) {
                num = num*10 + curr - '0';
                continue;
            }

            if (curr == '[') {
                String sub = helper(q);
                for (int i = 0; i < num; i++) {
                    sb.append(sub);
                }
                num = 0;
            } else if (curr == ']') {
                return sb.toString();
            } else {
                sb.append(curr);
            }

        }

        return sb.toString();
    }

    //Input: s = "3[a]2[bc]"
    //Output: "aaabcbc"
    public static String decodeString(String s) {
        Deque<Character> q = new LinkedList<Character>();
        for (char c : s.toCharArray()) q.add(c);
        return helper(q);

    }
    public static void main(String[] args) {
        System.out.println("Jay Swaminarayan!");
        System.out.println(decodeString("3[a2[c]]"));
    }
}
