package problems;

import java.util.ArrayList;

public class LongestSubString {
	public static void main(String[] args){
		ArrayList<Character> res = new ArrayList<Character>();
		String st = "abcabcbb";
		for(int i=0;i<st.length();i++){
			if(res.contains(st.charAt(i))){
				res.clear();
			}else{
				res.add(st.charAt(i));
			}
		}
	}
}
