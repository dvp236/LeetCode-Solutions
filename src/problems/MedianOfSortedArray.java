package problems;

import java.util.Arrays;

public class MedianOfSortedArray {


    //O(log(m+n))
    public static double median(int[] a, int[] b) {
        int m = a.length, n = b.length;
        // 0 1 2 3 4
        int l = (m + n+1) / 2 ;
        int r = (m+n+2) / 2 ;

        return (getKth(a, 0, b, 0, l) + getKth(a, 0, b, 0, r))/(double) 2;
    }

    private static int getKth(int[] a, int aStart, int[] b, int bStart, int k) {
        if (aStart >= a.length) {
            return b[bStart + k - 1];
        }
        if (bStart >= b.length) {
            return a[aStart +k -1];
        }

        if (k == 1) {
            return Math.min(a[aStart], b[bStart]);
        }

        int amid = Integer.MAX_VALUE; int bmid = Integer.MAX_VALUE;
        if (aStart + k/2 -1 < a.length) amid = a[aStart + k/2 -1];
        if (bStart + k/2 -1 < b.length) bmid = b[bStart + k/2 -1];

        if (amid < bmid) {
            return getKth(a, aStart+ k/2, b, bStart, k - k/2);
        } else {
            return getKth(a, aStart, b , bStart +k/2, k-k/2);
        }
    }


    //works when length of a and b are same O(log(m+n))
    public static double findmed(int[] a, int[] b) {
        return findmed(a, 0, a.length-1, b, 0, b.length-1);
    }

    public static double findmed(int[] a, int al, int ah, int[] b, int bl, int bh) {
        if (ah-al == 1 && bh - bl ==1)
            return (Math.max(a[al], b[bl]) + Math.min(a[ah], b[bh]))/(double)2;

        double m1 = medAscArray(a,al,ah);
        double m2 = medAscArray(b,bl,bh);
        if (m1 == m2) return m2;
        else if(m1 > m2) {
            return findmed(a, al, (al+ah)/2,b,(bl+bh)/2,bh);

        }else{
            return findmed(a, (al+ah)/2,ah ,b,bl,(bl+bh)/2);
        }
    }
    public static double medAscArray(int[] a, int lo, int hi) {
        int n = (hi+lo)/2;
        if(n % 2 ==  0) {
            return a[n];
        }

        return (a[n] + a[n + 1]) / (double) 2;
    }


    //O(N) complexity -- not ideal
    public static double getMedian(int[] a,  int[] b) {
        int[] big = a.length > b.length ? a : b;
        int[] small = Arrays.equals(big,a) ? b:a;

        int bn = big.length; int sn = small.length;
        int n = bn + sn;

        int k = n/2;
        if (n%2 == 0) k--;

        //0 1 2 3 4 5
        int i = 0; int j =0;
        int c =0;

        while (c < k) {
            if (i == bn) {
                j++;
            } else if ( j == sn) {
                i++;
            } else if (big[i] < small[j]) {
                i++;
            } else {
                j++;
            }
            c++;
        }


        double med = j == sn ? big[i++] : (big[i] < small[j] ? big[i++] : small[j++]);
        if (n%2 ==0) {
            med += j == sn ? big[i] : (Math.min(big[i], small[j]));
            med = med / (double) 2;
        }

        return med;
    }
    public static void main(String[] args) {
        System.out.println("Jay Swaminarayan!!");

        int[] a = new int[] {1,2,3};
        int[] b = new int[] {4,5,6};
        System.out.println(getMedian(a,b));

//        System.out.println(findmed(a,b));
        System.out.println(median(a,b));


    }

    //0 1 2
    //3 4 5
    //0 1 2 3 4 5
    // 3 + 4
    //
}
