package problems;

//bloomberg
public class SliceOfArray {

	public static boolean checkIfSubset(int[] a, int[] b) {
		int bIndex = 0;
		int aIndex = 0;
		while (aIndex < a.length && bIndex < b.length){
			if( a[aIndex] != b[bIndex]){
				if (bIndex == 0) aIndex++;
				bIndex = 0;
			}
			else {
				aIndex++;
				bIndex++;
			}
		}
		if (bIndex != b.length) return false;
		return true;
	}
	public static void main(String[] args) {
		int[] a = new int[]{7,1,2,5,6,5,6,7};
		int[] b = new int[]{5,6,7};
		System.out.println(checkIfSubset(a, b));
	}

}
