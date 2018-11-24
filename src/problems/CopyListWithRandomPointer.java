package problems;

class Node{
	int data;
	Node next;
	Node random;
	
	public Node(int data) {
		this.data = data;
		next = null;
		random = null;
	}
}
public class CopyListWithRandomPointer {
	//
	public static Node getCopy(Node head) {
		Node curr = head;
		
		while (curr!= null) {
			Node cnode = new Node(curr.data);
			Node temp = curr.next;
			curr.next = cnode;
			cnode.next = temp;
			curr = temp;
		}
		//nextOrderPrint(head);
		curr = head;
		while(curr != null) {
			Node cnode = curr.next;
			if (curr.random != null)
				cnode.random = curr.random.next;
			curr = cnode.next;
		}
		curr = head;
		Node chead = null;
		while(curr != null) {
			Node cnode = curr.next;
			if (chead == null) chead = cnode;
			// 1- 1 -2 -2 - 3 -3 -4 -4 -null
			curr.next = cnode.next;
			if (cnode.next != null)
				cnode.next = curr.next.next;
			
			
			curr=curr.next;
		}
		
		return chead;
	}
	public static Node getDeepCopy(Node head) {
		Node chead = new Node(head.data);
		return chead;
	}
	
	public static void nextOrderPrint(Node head) {
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data+"->");
			curr = curr.next;
		}
		System.out.println("Null");
	}
	public static void randomOrderPrint(Node head) {
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data+"->");
			curr = curr.random;
		}
		System.out.println("Null");
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		
		head.next = two; two.next = three; three.next = four;
		head.random = two; two.random = four; four.random = three;
		
		nextOrderPrint(head);
		randomOrderPrint(head);
		
		Node chead = getCopy(head);
		nextOrderPrint(chead);
		randomOrderPrint(chead);
		
		
		
	}

}
