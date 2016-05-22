package problems;

public class AddTwoNumbers {
	public static ListNode addTwo(ListNode l1, ListNode l2){
		ListNode head=null;
		ListNode curr=head;
		int carry = 0;
		while(l1!=null || l2!=null || carry !=0){
			int data=carry, vl1 = 0, vl2 = 0;
			if(l1 != null) vl1 = l1.val;
			if(l2 != null) vl2 = l2.val;
			data  += vl1+vl2;
			carry = data/10;
			data = data % 10;
			ListNode newNode = new ListNode(data);
			if(head != null){
				curr.next = newNode;
				curr = curr.next;
			}
			else{
				head = newNode;
				curr = newNode;
			}
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
		}
		return head;
	}

}
