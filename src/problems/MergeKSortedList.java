package problems;

import java.util.ArrayList;

public class MergeKSortedList {
	public static ListNode merge(ArrayList<ListNode> heads) {
		ListNode newHead = null;
		return newHead;
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
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next =new ListNode(3);
		
		printList(head);
	}
	
}
