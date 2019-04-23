package problems;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedList {
	//We will use min heap to do this 
	//O(nlogk) -- n total elements and k lists.
	public static ListNode merge(ArrayList<ListNode> heads) {
		ListNode newHead = null;
		PriorityQueue<ListNode> q = new PriorityQueue<>((l1,l2)->l1.val - l2.val);
		
		//insert first node of all list to q
		for(ListNode node: heads) {
			q.add(node);
		}
		
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (!q.isEmpty()) {
			tail.next = q.poll();
			tail = tail.next;
			if (tail.next !=  null) q.add(tail.next);	
		}
		
		return dummy.next;
	}
	public static void printList(ListNode head) {
		ListNode curr = head;
		
		while (curr != null) {
			System.out.print(curr.val+"->");
			curr = curr.next;
		} 
		System.out.println("Null");
	}
	
	public static void main(String[] args) {
		ListNode h1 = new ListNode(1);
		h1.next = new ListNode(2);
		h1.next.next = new ListNode(3);
		
		ListNode h2 = new ListNode(1);
		h2.next = new ListNode(2);
		h2.next.next = new ListNode(3);
		
		ListNode h3 = new ListNode(2);
		h3.next = new ListNode(4);
		h3.next.next = new ListNode(5);
		printList(h1);
		ArrayList<ListNode> heads = new ArrayList<>();
		heads.add(h1); heads.add(h2); heads.add(h3);
		ListNode m = merge(heads);
		
		printList(m);
	}
	
}
