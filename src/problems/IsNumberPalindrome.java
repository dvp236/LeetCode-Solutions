package problems;
/**
 * 
 * @author dharmik patel
 * Check if number is palindrome or not
 */
public class IsNumberPalindrome {
	
	//we can reverse the number and check if matches with original one.
	public static boolean isPalindrome(int num){
		int reverse = 0;
		int n = num;
		while(n>0){
			reverse = reverse*10 + n%10;
			n = n/10;
		}
		return reverse == num;
	}
	
	public static void main(String[] args) {
		int n = 34543;
		System.out.println(isPalindrome(n));
		
	}

}
