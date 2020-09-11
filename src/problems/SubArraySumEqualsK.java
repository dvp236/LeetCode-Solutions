package problems;


import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
 */
public class SubArraySumEqualsK {

    //Time complexity - O(n^2)
    public static int contSubarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }

        }

        return count;
    }

    //Time complexity = O(n)
    public static int countSubarraySum1(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //this is for exact sum. when sum is 7 and k is 7, the count will be 1.
        map.put(0, 1);

        //the idea here is to store each sum in a map
        //eveytime we subtract k from sum and see if that is present in map
        //if that value is present in a map that would mean we can reach to k one more time
        //like below
        //sum -k = x
        //k = sum - x
        //thus now count will be count + number of times we can get x -> i.e map.get(x)

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //7 1 7 1 7 1
            if (map.containsKey(sum - k)) {
                System.out.println("sum -k "+ (sum-k));
                count+= map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        System.out.println(map.toString());
        return count;
    }

    //as well as implement pick elements problem from bloomberg
    //pick elements from list that sums to k
    public static void main(String[] args) {
        int[] a = new int[]{1,1,1};
        int[] b = new int[]{28,54,7,-70,22,65,-6};
        //100\
        int[] c = new int[] {0,0,0,0};

        int[] d = new int[] {7,1,7,1,7,1};

        System.out.println(contSubarraySum(b, 100 ));
        System.out.println(countSubarraySum1(d, 8));
    }
}
