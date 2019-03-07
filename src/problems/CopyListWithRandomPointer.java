package problems;

/**
 * 
 * @author dharmik
 * Here the idea is to make a duplicate node of each node.
 * and just point the original to duplicate.
 * thus for ex = 1->2->3->null
 * will be 1->1->2->2->3->3->4->4->null
 * now separate two list updating correct next and random
 * and then return copy.
 *
 */
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
		
		//create duplicate nodes for each and put it next to original
		while (curr!= null) {
			Node cnode = new Node(curr.data);
			Node temp = curr.next;
			curr.next = cnode;
			cnode.next = temp;
			curr = temp;
		}

		//now update randoms of duplicate nodes.
		curr = head;
		while(curr != null) {
			Node copynode = curr.next;
			if (curr.random != null){
				copynode.random = curr.random.next;
			}
			curr = copynode.next;
		}
		curr = head;
		Node chead = null;
		//separate both lists
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
