package problems;

public class LongestPalindromeSubstring {

	public static String getLongestPalindrome(String st){
		String result = "";
		for(int i=1;i<st.length()-1;i++){
			//get the palindrome string around index i
			//This is for odd length of palindrome
			String s1 = findPattern(st,i,i);
			if(s1.length() > result.length()) result = s1;
			//this is for even length of palindrome-->"baab"
			String s2= findPattern(st,i,i+1);
			if(s2.length() > result.length()) result = s2;
		}
		return result;
	}
	
	public static String findPattern(String st, int i, int j){
		int left  = i,right=j;
		
		while(left > -1 && right < st.length() && st.charAt(left) == st.charAt(right)){
			//pass
			left--;
			right++;
		}
		
		String found = st.substring(left+1, right);
		return found;
	}
	
	public static void main(String[] args){
		String s = "fffabcddcbafaba";
		System.out.println(getLongestPalindrome(s));
		
	}

}
