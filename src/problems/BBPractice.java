package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BBPractice {
	int ans = 1;
	
	public int getDiameter(TreeNode node) {
		ans = 0;
		diameterdfs(node);
		return ans;
	}
	private int diameterdfs(TreeNode node) {
		if (node == null) return 0;
		int l = diameterdfs(node.left);
		int r = diameterdfs(node.right);
		ans = Math.max(ans,l +r);
		return Math.max(l,r) + 1;
	}
//	 public static int diameterOfBinaryTree(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//       int dia = depth(root.left) + depth(root.right);
//       int ldia = diameterOfBinaryTree(root.left);
//       int rdia = diameterOfBinaryTree(root.right);
//       return Math.max(dia,Math.max(ldia,rdia));
//        
//    }
//    public static int depth(TreeNode root){
//        if(root == null){
//            return 0;
//        }
//        return 1+Math.max(depth(root.left), depth(root.right));
//    }
	public static int[] nextGreater1(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length]; 
		HashMap<Integer, Integer> mapNext = new HashMap<>();
		Stack<Integer> st = new Stack<>();
		
		for (int i=0; i < nums2.length; i++) {
			if (!st.isEmpty() && st.peek() < nums2[i]) {
				while(!st.isEmpty()) {
					mapNext.put(st.pop(), nums2[i]);
				}
				st.push(nums2[i]);
			}
			st.push(nums2[i]);
		}
		while(!st.isEmpty()) mapNext.put(st.pop(), -1);
		
		for (int i=0; i< nums1.length; i++) {
			result[i] = mapNext.getOrDefault(nums1[i],-1);
		}
		
		return result;
	}
	public static void nextGreater3(int n) {
		char[] nums = String.valueOf(n).toCharArray();
		int i = nums.length-2;
		while (i>=0 && nums[i]>=nums[i+1]) i--;
		if (i < 0) System.out.println("not possible");
		int right = nums.length-1;
		
		while(right >= 0 && nums[right] <= nums[i]) right--;
		swap(nums,i,right);
		reverse(nums, i+1);
		System.out.println(new String(nums));
	}
	private static void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i]= a[j];
		a[j] = temp;
	}
	
	private static void reverse(char[] a, int i) {
		 int j = a.length - 1;
	        while (i < j) {
	            swap(a, i, j);
	            i++;
	            j--;
	        }
	}
	public static boolean search2D(int[][] a, int num) {
		int i = a.length - 1;
		int j = 0;
		
		while (i >= 0 && j < a[0].length) {
			if (a[i][j] == num) return true;
			if (a[i][j] > num) i--;
			else j++;
		}
		
		return false;
	}

	public static int brickWall(List<List<Integer>> wall) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (List<Integer> row: wall) {
			int sum = 0;
			for (int i = 0; i < row.size()-1; i++) {
				sum += row.get(i);
				map.put(sum, map.getOrDefault(sum, 0)+1);
			}
		}
		int res = Integer.MAX_VALUE;
		for (int v : map.keySet()) {
			res = Math.min(res, wall.size() - map.get(v));
		}
		return res;
	}
	
	public static int islandPerimeter(int[][] a) {
		int ans = 0;
		for (int i=0; i < a.length; i++) {
			for (int j=0; j<a[0].length; j++) {
				if (a[i][j] == 1) {
					ans+=getperimeter(a, i, j);
				}
			}
		}
		return ans;
	}
	private static int getperimeter(int[][] a, int i, int j) {
		int ans = 0;
		if (i == 0 || i == a.length -1) ans+=1;
		if (j == 0 || j == a[0].length -1) ans+=1;
		if (j-1 >= 0 && a[i][j-1] == 0) ans+=1;
		if (i-1 >= 0 && a[i-1][j] == 0) ans+=1;
		if (j+1 < a[0].length && a[i][j+1] == 0) ans+=1;
		if (i+1 < a.length && a[i+1][j] == 0) ans+=1;
		return ans;
	}
	public int islandPerimeter1(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
	public static String[] generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		genPHelper(result,"",0,0,n);
		String[] s = new String[result.size()];
				s = result.toArray(s);
		return s;
	}
	private static void genPHelper(ArrayList<String> result, String parenthesis, int open, int close, int max) {
		if (parenthesis.length() == 2*max) result.add(parenthesis);
		else {
			if (open < max) 
				genPHelper(result, parenthesis+"(",open+1,close, max);
			if (close < open)
				genPHelper(result, parenthesis+")", open, close+1, max);
		}
	}
	public static int[] moveZeros(int[] a) {
		int pos = 0;
		for (int i=0; i<a.length; i++) {
			if (a[i]!=0) a[pos++] = a[i];
		}
		while(pos < a.length) {
			a[pos++] = 0;
		}
		return a;
	}
	
	public static int maxSubArray(int[] a, int lo, int hi) {
		if (lo == hi ) return a[lo];
		
		int mid = lo + (hi-lo)/2;
		int left = maxSubArray(a, lo, mid);
		int right = maxSubArray(a, mid+1, hi);
		
		return Math.max(Math.max(left,right), maxMerge(a,lo,mid,hi));
	}
	
	private static int maxMerge(int[] a, int lo, int mid, int hi) {
		int max_left_sum = Integer.MIN_VALUE;
		int sum = 0;
		int max_right_sum = Integer.MIN_VALUE; 
		
		for(int i=mid; i >=lo; i--) {
			sum += a[i]; 
			if (sum > max_left_sum) max_left_sum = sum ;
		}
		sum = 0;
		for (int i=mid+1; i<=hi; i++) {
			sum += a[i];
			if (sum> max_right_sum) max_right_sum = sum;
		}
		return max_left_sum+max_right_sum;
	
	}

	public static void main(String[] args) {
		int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		//System.out.println(maxSubArray(a, 0, a.length-1));
		//System.out.println(Arrays.toString(moveZeros(a)));
		//System.out.println(Arrays.toString(generateParenthesis(3)));
		
//		int[][] mat = new int[][]{
//			new int[]{1,4,7,11,15},
//			new int[]{2,5,8,12,19},
//			new int[]{3,6,9,16,22},
//			new int[]{10,13,14,17,24},
//			new int[]{18,21,23,26,30}
//		};
//		int[][] island = new int[][]{
//			new int[]{0,1,0,0},
//			new int[]{1,1,1,0},
//			new int[]{0,1,0,0},
//			new int[]{1,1,0,0}
//		};
//		
//		for(int i=0; i<mat.length; i++) {
//			System.out.println(Arrays.toString(mat[i]));
//		}
//		
//		System.out.println(search2D(mat,4));
//		System.out.println(islandPerimeter(island));
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(6);
		root.left.right.right.right = new TreeNode(7);
		
		System.out.println(new BBPractice().getDiameter(root));
		
		int[] nums1 = new int[]{2,4};
		int[] nums2 = new int[]{1,2,3,4};
		
		System.out.println(Arrays.toString(nextGreater1(nums1, nums2)));
		nextGreater3(230241);
	//	System.out.println(diameterOfBinaryTree(root));
		
	}

}
