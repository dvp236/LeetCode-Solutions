package problems;

import java.util.Arrays;

public class MoveZeros {
	public static int[] moveZeros(int[] a) {
		int pos = 0;
		for (int i=0; i < a.length; i++) {
			if (a[i] != 0) {
				a[pos++] = a[i];
			}
		}
		while(pos < a.length) a[pos++] = 0;
		return a;
	}
	public static void main(String[] args) {
		System.out.println("Jsn!");
		int[] a = new int[]{0,3,2,0,0,1,2,0,55};
		System.out.println(Arrays.toString(moveZeros(a)));
	}

}
