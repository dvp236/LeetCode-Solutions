package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * @author dharmik
 * 
 * Given a string, find the first non-repeating character in it 
 * and return it's index. If it doesn't exist, return -1.
 *
 */
public class FirstUniqueCharacterInAString {
	//using char array 
	public int firstUnqCharIndex1(String s) {
		int[] freq = new int[26];
		int[] indexmap = new int[26];
		
		for (int i=0; i < s.length(); i++) {
			freq[s.charAt(i) - 'a'] = freq[s.charAt(i)-'a']+1;
			indexmap[s.charAt(i)-'a'] = i;
		}
		

		int min=Integer.MAX_VALUE;
		for (int i=0; i<26; i++) {
			if (freq[i] == 1){
				min = Math.min(min, indexmap[i]);
			}
		}
		
		
		return min==Integer.MAX_VALUE ? -1 : min;
		
		
	}
	
	
	//using inbuilt java function
	public int firstUnqCharIndex(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
				return i;
			}
		}
		
		return -1;
	}
	
	@Test
	public void TestOne() {
		FirstUniqueCharacterInAString ob = new FirstUniqueCharacterInAString();
		String sample = "leetcodelove";
		assertEquals(3,ob.firstUnqCharIndex(sample));
		assertEquals(3, ob.firstUnqCharIndex1(sample));
	}
	
	@Test
	public void TestTwo() {
		FirstUniqueCharacterInAString ob = new FirstUniqueCharacterInAString();
		String sample = "leetcode";
		assertEquals(0,ob.firstUnqCharIndex(sample));
		assertEquals(0,ob.firstUnqCharIndex1(sample));
	}
	
	@Test
	public void TestThree() {
		FirstUniqueCharacterInAString ob = new FirstUniqueCharacterInAString();
		String sample = "mmddiia";
		assertEquals(sample.length()-1,ob.firstUnqCharIndex1(sample));
	}
}
