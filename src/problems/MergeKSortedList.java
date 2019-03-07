package problems;

/**
 * 
 * @author dharmik
 * Three ways to do this:
 * 1. Use iterative method merging two list each time.
 * 2. Use Divide and conquer approach and merge
 * 3. Use MinHeap  --> Best Approach
 * 
 *
 */
public class MergeKSortedList {
	//best answer is to read from minheap
	
	public static ListNode mergeDAC(ListNode[] heads, int start, int end) {
		if(start==end) {
			return heads[start];
		}
		else{
			int mid = (start+end)/2;
			ListNode common1 = mergeDAC(heads,start,mid);
			ListNode common2 = mergeDAC(heads,mid+1,end);
			return mergeHelper(common1,common2);
			
		}
		
	}
	
	public static ListNode mergeHelper(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) return null;
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		ListNode head = new ListNode(0);
		ListNode curr = head;
		while(l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				ListNode temp = l1.next;
				curr.next = l1;
				curr = curr.next;
				l1 = temp;
			} else {
				ListNode temp = l2.next;
				curr.next = l2;
				curr = curr.next;
				l2 = temp;
			}
		}
		if (l1 == null && l2 != null) {
			while (l2 != null) {
				curr.next = l2;
				curr = curr.next;
				l2 = l2.next;
			}
		}
		if (l2 == null && l1 != null) {
			while (l1 != null) {
				curr.next = l1;
				curr = curr.next;
				l1 = l1.next;
			}
		}
		
		return head.next;
	}
	
	
	public static ListNode mergeIterative(ListNode[] heads) {
		ListNode l1 = null;
		
		for (int i = 0 ; i < heads.length; i++) {
			l1 = mergeHelper(l1, heads[i]);
		}
		return l1;
		
	}
	public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode c1 = l1, c2 = l2;
		ListNode head = null;
		ListNode curr = null;
		while (c1 != null && c2 != null) {
			ListNode nextnode;
			if (c1.val < c2.val) {
				nextnode = c1;
				c1 = c1.next;
			} else {
				nextnode = c2;
				c2 = c2.next;
			}
			if (head == null) {
				head = nextnode;
				curr = head;
			}
			else {
				curr.next = nextnode;
				curr = nextnode;
			}
			
		}
		if (c2 != null && c1 == null ) {
			while (c2 != null) {
				curr.next = c2;
				curr = curr.next;
				c2 = c2.next;
			}
		}
		if (c1 != null && c2 == null ) {
			while (c1 != null) {
				curr.next = c1;
				curr = curr.next;
				c1 = c1.next;
			}
		}
		return head;
		
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
		ListNode head = new ListNode(2);
		head.next = new ListNode(3);
	//	head.next.next =new ListNode(4);
		
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(5);
		head2.next.next =new ListNode(6);
		
		ListNode head3 = new ListNode(4);
		head3.next = new ListNode(8);
		head3.next.next =new ListNode(9);
		
		ListNode[] ls = new ListNode[] {head, head2, head3};
		
//		ListNode head4 = merge(ls);
////		
//		printList(head4);
		
		ListNode h4 = mergeDAC(ls, 0,1);
		printList(h4);
	}
	
}
