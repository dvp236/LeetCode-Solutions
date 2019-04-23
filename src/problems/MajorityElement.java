package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//https://leetcode.com/problems/majority-element/
public class MajorityElement {

	
	//Some obvious methods are counting each element's occurence.
	//creating a hashmap of frequency .
	//or sorting array and then get element at n/2 index. which will be majority element.
	//but this approach is most efficient as space O(1) and time is O(N)
	//Boyer-Moore Voting Algorithm
	public static int majorityElement(int[] a) {
		Integer num = a[0];
		int count = 0;
		
		for (int i = 0; i < a.length; i++) {
			if (num == a[i]) count++;
			else if (count == 0) num = a[i];
			else count--;
			
		}
		
		count = 0 ;
		for (int i = 0; i < a.length; i++) {
			if (num == a[i]) count++;
		}
		if (count > a.length/2) return num;
		return -1;
	}
	
	//return elements that appear more than n/3 times
	public static List<Integer> majorityElement2(int[] nums) {
		if (nums == null || nums.length == 0)
			return new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
			else if (count1 == 0) {
				number1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				number2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
		}
		if (count1 > len / 3)
			result.add(number1);
		if (count2 > len / 3)
			result.add(number2);
		return result;
	}
	
	//here we maintain a k counts map
	public static List<Integer> majorityElementGeneralized(int[] a, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int num: a) {
			map.put(num, map.getOrDefault(num, 0)+1);
			if (map.size() == k) {
				Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
				while (it.hasNext()) {
					Entry<Integer, Integer> entry = it.next();
					if (entry.getValue() == 1) it.remove();
					else entry.setValue(entry.getValue()-1);
				}
			}
		}
		
		//now map will have atmost k entries
		//we check validity of each candidate
		List<Integer> result = new ArrayList<>();
		for (int key: map.keySet()) {
			int count = 0;
			for (int num : a) {
				if (num == key) count++;
			}
			if (count > a.length/k) result.add(key);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1,1,1,1,1,2,3,3,3,3,3,3,3,3,3,3};
		System.out.println(majorityElement(a));
	}
}
