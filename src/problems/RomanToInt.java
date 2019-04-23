package problems;

public class RomanToInt {

	public static int getVal(char c) {
		switch(c) {
			case 'I': 
				return 1;
			case 'V':
				return 5;
			case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X' :
                return 10;
		}
		return 0;
	}
	
	public static int getRomanToInt(String roman) {
		int result = 0 ;
		for (int i = 0; i < roman.length() - 1; i++) {
			int cur = getVal(roman.charAt(i));
			int next = getVal(roman.charAt(i+1));
			
			if (cur < next) result -= cur;
			else 			result += cur;
		}
		
		return result + getVal(roman.charAt(roman.length()-1));
			
	}
	
	public static void main(String[] args) {
		System.out.println(getRomanToInt("VI"));
		System.out.println(getRomanToInt("XVII"));
		System.out.println(getRomanToInt("IX"));

	}

}
