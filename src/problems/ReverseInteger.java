package problems;

/**
 * 
 * @author dharmik
 * Reverse Integer LeetCode
 *
 */
public class ReverseInteger {
	
	//i.e 321 -> 123
	// -123 -> -321
	public static int reverse(int n){
		if(n > Integer.MAX_VALUE || n < Integer.MIN_VALUE){
			return 0;
		}
		
		boolean isNegative = false;
		long result=0;
		
		if(n < 0){
			isNegative = true;
			n = n * (-1);
		}
		
		while(n>=1){
			result = result * 10 + n%10;
			if(result > Integer.MAX_VALUE){
				return 0;
			}
			n=n/10;
		}
		
		return isNegative ? ((int) result) * -1 : (int)result;
	}
	
	public static void main(String[] args){
		System.out.println(Integer.MAX_VALUE);
		System.out.println(reverse(1534236469));
	}
	
}
