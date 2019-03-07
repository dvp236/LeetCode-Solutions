package problems;

//bloomberg
public class SliceOfArray {

	public static boolean checkIfSubset(int[] a, int[] b) {
		int bIndex = 0;
		int aIndex = 0;
		while (aIndex < a.length && bIndex < b.length){
			if( a[aIndex] != b[bIndex]){
				bIndex = 0;
				aIndex++;
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
		int[] a = new int[]{1,2,5,6,5,6,7};
		int[] b = new int[]{5,6,7};
		System.out.println(checkIfSubset(a, b));
	}

}
