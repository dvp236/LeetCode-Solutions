package problems;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


//Leetcode 384
public class ShuffleAnArray {

    private int[] nums;
    //index -> num
    private final Map<Integer, Integer> omap;
    private final Random rand;

    public ShuffleAnArray(int[] nums) {
        this.nums = new int[nums.length];
        rand = new Random();
        this.omap = new HashMap<>();
        this.nums = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            omap.put(i, nums[i]);
        }
    }

    public int[] reset() {
        for (int key : omap.keySet()) {
            nums[key] = omap.get(key);
        }

        return nums;
    }

    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            int random = rand.nextInt(nums.length - i);
            int j = i + random;
            swap(nums, i, j);
        }
        return nums;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        ShuffleAnArray ob = new ShuffleAnArray(a);
        System.out.println(Arrays.toString(ob.shuffle()));
        System.out.println(Arrays.toString(ob.shuffle()));
        System.out.println(Arrays.toString(ob.shuffle()));
        System.out.println(Arrays.toString(ob.shuffle()));
        System.out.println(Arrays.toString(ob.shuffle()));
        System.out.println(Arrays.toString(ob.shuffle()));
        System.out.println(Arrays.toString(ob.shuffle()));
        System.out.println(Arrays.toString(ob.shuffle()));
        System.out.println(Arrays.toString(ob.shuffle()));
        System.out.println(Arrays.toString(ob.shuffle()));
        System.out.println(Arrays.toString(ob.shuffle()));
        System.out.println(Arrays.toString(ob.shuffle()));
        System.out.println(Arrays.toString(ob.shuffle()));
        System.out.println(Arrays.toString(ob.reset()));
        System.out.println(Arrays.toString(ob.shuffle()));
    }

}
