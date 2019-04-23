package problems;

import java.util.ArrayList;
import java.util.Arrays;

public class GenerateParenthesis {

	public static String[] generateParenthesis(int num) {
		ArrayList<String> result = new ArrayList<>();
		genHelper(result,"",0,0,num);
		String[] s = new String[result.size()];
		return result.toArray(s);
	}
	private static void genHelper(ArrayList<String> result, String paren, int open, int close, int max) {
		if (paren.length() == 2*max) result.add(paren);
		else {
			if (open < max) genHelper(result, paren+"(", open+1, close, max);
			if (close < open) genHelper(result, paren+")", open, close+1, max);
		}
	}
	public static void main(String[] args) {
		System.out.println("all okay");
		System.out.println(Arrays.toString(generateParenthesis(3)));
	}

}
