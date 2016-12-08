package problems;
/**
 * 
 * @author dharmik
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 */
public class LongestCommonPrefix {
	
	public static String longestCommonPrefix(String[] strs){
		String result = "";
		
		outerloop:
		for(int i=0;true ;i++){
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = new String[]{"abclm","abcd","abcdef"};
		System.out.println(longestCommonPrefix(strs));
	}

}
