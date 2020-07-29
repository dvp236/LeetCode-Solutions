package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.Vector;

public class CandyCrush1D {

	//only works for exactly 3 same candies
	private static String crushCandy(String input) {
        Vector<Character> characters = new Vector<>();
        for (char c: input.toCharArray()) {
            characters.add(c);
            if (characters.size() > 2) {
                int size = characters.size();
                char firstChar = characters.get(size - 1);
                char secondChar = characters.get(size - 2);
                char thirdChar = characters.get(size - 3);
                if (firstChar == secondChar && secondChar == thirdChar) {
                    characters.remove(size - 1);
                    characters.remove(size - 2);
                    characters.remove(size - 3);
                }
            }
        }
        return characters.toString();
    }
	
	public static String crushOnepass(String candy) {
		Stack<Character> stack = new Stack<>();
		HashMap<Character, Integer> map = new HashMap<>();
		HashMap<Character, Integer> imap = new HashMap<>();
		String s = candy;
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0; i<s.length(); i++) {
			int cnt = 1;
			int start = i;
			while( i < s.length() -1 && s.charAt(i)==s.charAt(i+1)){
				cnt++;
				i++;
			}
			//AABBBAC
			if (cnt>=3) {
				s = s.substring(0,start) +getTempString(cnt) +s.substring(i+1,s.length());
			}
			else {
				
				if(stack.isEmpty()) {
					stack.push(s.charAt(i));
					map.put(s.charAt(i),cnt);
					if(!imap.containsKey(s.charAt(i))) imap.put(s.charAt(i), start);
					System.out.println("in else - "+stack.size());
				} else {
					char last = stack.pop();
					System.out.println("last -"+last+" char i "+s.charAt(i)+" "+(last==s.charAt(i)));
					if (last == s.charAt(i)) {
						int t = cnt + map.get(s.charAt(i));
						System.out.println("t"+t);
						if (t >= 3) {
							System.out.println("s  bef -"+s);
							
							s = s.substring(0,i-cnt+1) +getTempString(cnt) +s.substring(i+1,s.length());
							System.out.println("s aft - "+s);
							int tempstart = imap.get(s.charAt(i));
						//	s = gS(s, i, map.get(s.charAt(i)));
							
						}
					}else{
						map.put(s.charAt(i), cnt);
						stack.push(s.charAt(i));
					}
				}
				
			}
		}
		
		return s;
		
	}
	//aa###ac
	
	private static String getTempString(int n) {
		String s = "";
		for(int i=0; i<n; i++) s+="#";
		
		return s;
	}
	//multiple pass of String
	public static String crush(String candy) {
		String s = candy;
		
		//until both the string becomes equal and no candy crushed
		while(s.length() != pass(s).length()) {
//			System.out.println("pass- "+pass(s));
			s = pass(s);
		}
		
		return s;
		
	}
	private static String pass(String s) {
		for (int i=0; i<s.length(); i++) {
			int cnt = 1;
			while (i < s.length()-1 && s.charAt(i) == s.charAt(i+1)) {
				cnt++;
				i++;
			}
			if (cnt >= 3) {
				s = s.substring(0,i-cnt+1) + s.substring(i+1,s.length());
				i = i - cnt;
			}
		}
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println("okay");
		
		System.out.println(crush("AABBBACDDDFDFFFF"));
//		System.out.println(crushOnepass("AABBBACDDDFDFFFF"));
		System.out.println(crushCandy("AABBBACCCCD"));
		System.out.println(crush("CAABBBACCCCD"));
	}

}
