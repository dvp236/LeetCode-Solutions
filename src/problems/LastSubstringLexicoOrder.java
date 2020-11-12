package problems;


//1163. Last Substring in Lexicographical Order

public class LastSubstringLexicoOrder {

    //leetcode --> tcode
    //cacacb --> cb
    public static String lastSubString(String s) {
        int j = s.length() - 1;
        for (int i = s.length() - 2; i >=0 ; i--) {
            if (s.charAt(i) > s.charAt(j)) {
                j = i;
            } else if (s.charAt(i) == s.charAt(j)) {
                int p = i+1; int q=j+1;
                while (q != s.length() && s.charAt(p) == s.charAt(q)) {
                    p++;q++;
                }
                if (q == s.length()){
                    j = i;
                } else {
                    if (s.charAt(p) > s.charAt(q)){
                        j = i;
                    }
                }
            }
        }

        return s.substring(j,s.length());

    }

    //Better approach - O(N)
    public static String lastSub(String s) {
        int j = 1; int k = 0;
        int i = 0;
        //cacacb

        while(j+k < s.length()) {
            if (s.charAt(i+k) == s.charAt(j+k)) {
                k++;
                continue;
            } else if (s.charAt(i+k) > s.charAt(j+k)) {
                j = j+k+1;
            } else {

                // i= Math.max(i+k+1, j); no idea why math.max here yet. replacing with below.
                i = j;
                j=i+1;
            }
            k = 0;
        }


        return s.substring(i);
    }


    public static void main(String[] args) {
        System.out.println("Jsn!!");
        System.out.println(lastSubString("leetcode"));
        System.out.println(lastSubString("abab"));
        System.out.println(lastSubString("cacacb"));
        System.out.println(lastSubString("aaaa"));
        System.out.println("---------");
        System.out.println(lastSub("leetcode"));
        System.out.println(lastSub("abab"));
        System.out.println(lastSub("cacacb"));
        System.out.println(lastSub("aaaa"));

    }
}
