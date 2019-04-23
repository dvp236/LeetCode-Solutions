package problems;

import static org.junit.Assert.*;

import org.junit.Test;

public class Sqrt {
	
	public static int sqrt(int x) {
		if (x <= 0) return 0;
		int left = 0; int right = x;
		int ans  = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid <= x/mid) {
				left = mid + 1;
				ans = mid;
			}
			else right = mid-1;
		}
		
		return ans;
	}
	
	@Test
	public void test() {
		Sqrt ob = new Sqrt();
		assertEquals(4, ob.sqrt(16));
	}
	
	@Test
	public void test1() {
		Sqrt ob = new Sqrt();
		assertEquals(0, ob.sqrt(0));
	}
	
	@Test
	public void test2() {
		Sqrt ob = new Sqrt();
		assertEquals(3, ob.sqrt(10));
	}

}
