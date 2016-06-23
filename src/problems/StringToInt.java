package problems;
public class StringToInt {
	public static int aToI(String str){
		int result = 0;
		int i = 0;
		// calculate value
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		
		return result;
	}
	public static void main(String[] args) {
		System.out.println(aToI("2334")+1);
		
	}

}
