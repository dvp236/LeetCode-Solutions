package problems;

import java.util.Stack;

public class ValidStackSequence {

    //very simple and intuitive approach
    public static boolean isValidSeq(int[] input, int[] output) {
        int j = 0;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            st.push(input[i]);
            while (!st.isEmpty() && st.peek() == output[j]) {
                st.pop();
                j++;
            }
        }

        return st.isEmpty();
    }

    //210 - 120
    //Here one action at a time
    //track it with two pointers
    public static boolean isValidSeq1(int[] input, int[] output) {
        int ip = 0, op = 0;
        Stack<Integer> st = new Stack<>();

        while(op < output.length && ip < input.length) {

            if (output[op] == input[ip]) {
                op++;
                ip++;
            } else {
                if (!st.isEmpty() && st.peek() == output[op]){
                    st.pop();
                    op++;
                } else {
                    st.push(input[ip]);
                    ip++;
                }
            }
        }
        while(!st.isEmpty()) {
            if (op == output.length) return false;
            if (st.pop() != output[op]) return false;
            op++;
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println("Jsn");

        int[] input = new int[] {8,2,1,4,7,9,0,3,5,6};
        int[] output =  new int[] {1,2,7,3,6,4,0,9,5,8};
        //[8,2,1,4,7,9,0,3,5,6]
        //[1,2,7,3,6,4,0,9,5,8]
        int[] ip2 = new int[]{1,2,3,4,5,6,7};
        int[] op2 = new int[]{4,5,7,6,3,2,1};
        System.out.println(isValidSeq(ip2, op2));
        System.out.println("-----------");
        System.out.println(isValidSeq1(ip2,op2));
    }
}
