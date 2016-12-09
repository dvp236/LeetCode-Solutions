package problems;
/**
 * 
 * @author dharmik
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 */
public class LongestCommonPrefix {
	
	
	//Vertical Scanning of strings
	//Complexity: O(S) where s is all characters in array of strings 
	public static String longestCommonPrefixOne(String[] strs){
		String result = "";
		
		outerloop:
		for(int i=0;i<strs[0].length();i++){
			//loop over char
			char c =' ';
			for(int j=0; j<strs.length;j++){
				if(strs[j].length() <= i) break outerloop;
				char curr = strs[0].charAt(i);
				c = strs[j].charAt(i);
				
				if(c != curr ) break outerloop;
				
				
			}
			result +=c;
			
		}
		
		return result;
	}
	public static String longestCommonPrefix(String[] strs){
		if(strs == null || strs.length == 0) return "";
		if(strs.length ==1) return strs[0];
		return longestCommonPrefixDAC(strs,0,strs.length-1);
	}
	//Divide and conquer approach
	public static String longestCommonPrefixDAC(String[] strs,int start,int end){
		if(start==end) return strs[start];
		else{
			int mid = (start+end)/2;
			String common1 = longestCommonPrefixDAC(strs,start,mid);
			String common2 = longestCommonPrefixDAC(strs,mid+1,end);
			return lcpHelper(common1,common2);
			
		}
	}
	
	//helper method to get lcp of two string
	private static String lcpHelper(String s1,String s2){
		int min=s1.length() <= s2.length() ? s1.length() : s2.length();
		for(int i=0; i<min; i++){
			if(s1.charAt(i)!=s2.charAt(i))
				return s1.substring(0, i);
			
		}
		return s1.substring(0,min);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = new String[]{"abclm","abcd","abcdef","ab","abcd"};
		System.out.println(longestCommonPrefixOne(strs));
		
		System.out.println(longestCommonPrefix(strs));
	}

}
