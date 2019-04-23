package problems;


//https://leetcode.com/problems/count-primes/
public class CountPrimes {

	public static int countPrimes(int n) {
		boolean[] isPrime = new boolean[n];
		
		for (int i = 2; i < n; i++) isPrime[i] = true;
		
		//the goal here is to mark off anything thats not prime
		//we start from 2 and mark all the multiples of 2 false
		for (int i = 2; i*i < n; i++) {
			if (!isPrime[i]) continue;
			//we can start at i*i 
			for (int j = i*i; j < n; j+=i) {
				isPrime[j] = false;
			}
		}
		
		int count = 0;
		
		for (int i = 2;  i < n; i++) {
			if (isPrime[i]) count++;
		}
		return count;
	} 
	
	public static boolean isPrime(int n) {
		for (int i = 2; i*i <= n; i++) {
			if (n % i == 0) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPrimes(100));
		
		System.out.println(isPrime(4));
		System.out.println(isPrime(7));
		System.out.println(isPrime(9));
		System.out.println(isPrime(13));
	}

}
