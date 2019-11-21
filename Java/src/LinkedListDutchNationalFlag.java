//Sort a linked list of 0s, 1s and 2s by changing links
//Ref: https://www.geeksforgeeks.org/sort-linked-list-0s-1s-2s-changing-links/
//Hint: https://www.codelike.in/c/linked-list/sort-a-linked-list-of-0s-1s-and-2s
//https://medium.com/afteracademy/data-structures-and-algorithms-problem-solving-approach-e7cb8ae43b20

public class LinkedListDutchNationalFlag {
	private class Node{
		   int data;
		   Node next;
		   Node(int data){
		    this.data = data;
		   }
		}
	
	Node node;

	public void add(int value) {
		Node current = node;
		if (current == null) {
			node = new Node(value);
			return;
		}
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(value);
	}

	private void sort() {
		//Create three node to hold 0s, 1s and 2s. This is needed because each node has head pointer to it which will connect to each other using head pointer.
		// if we do not create new node there is no way to go to beginning on link list and connect them .
		Node zero = new Node(0);
		Node one = new Node(1);
		Node two = new Node(2);
		Node current = node;
		//Create three references which will point to head. We need all nodes but head
		Node a = zero; 
		Node b = one;
		Node c = two;
		// Assume we have elements in the list
		while(current != null ) {
			
			if(current.data == 0) {
				//a already has node with data 0 and pointer is null. Now a.next is pointing to curr node and become 0->0 
				a.next = current;
				//assing 0->0 original node and a.next which is curr to a. in next iteration a.next will have 0-> 0 and we are assigning curr to a.next becomes 0->0->0 then assing back to 
				//a which has now updated value. The whole process is increase and assign back to update and increase 0s
				a = a.next;
			}else if(current.data == 1){
				b.next = current;
				b = b.next;
			}else {
				c.next = current;
				c = c.next;
			}
			current = current.next;
		}

		// Append all node with head pointer
		a.next = one.next; //  head pointer to all the 0s
		b.next = two.next;
		// last node null to break cycle. Since its coming from curr. this might not be the end node or null. Break the cycle. 
		c.next = null;
		node = zero.next;
	}
	
//	private void sortAlternative() {
//		//This doesn't work because we can not to to head to connect all the node so above solution works to connect all the node in the end.
//		//Create three node to hold 0s, 1s and 2s
//		Node zero = new Node(0);
//		Node one = new Node(1);
//		Node two = new Node(2);
//		Node current = node;
//		//Create three references which will point to head. We need all nodes but head
//		Node a = null; 
//		Node b = null;
//		Node c = null;
//		// Assume we have elements in the list
//		while(current != null ) {
//			
//			if(current.data == 0) {
//				//a already has node with data 0 and pointer is null. Now a.next is pointing to current node and become 0->0 
//				if(a == null) {
//					a = current;
//				}
//				else {
//					a.next = current;
//					//assing 0->0 original node and a.next which is curr to a. in next iteration a.next will have 0-> 0 and we are assigning curr to a.next becomes 0->0->0 then assing back to 
//					//a which has now updated value. The whole process is increase and assign back to update and increase 0s
//					a = a.next;				
//				}
//
//			}else if(current.data == 1){
//				if(b == null) {
//					b = current;
////					System.out.print(b.data);
////					System.out.print(b.next.data);
////					System.out.print(b.next.next.data);
////					System.out.print(b.next.next.next.data);
//				}else {
//				    b.next = current;
//				    b = b.next;
//				}
//			}else {
//				if(c == null) {
//					c = current;
//				}else {
//				    c.next = current;
//				    c = c.next;
////					System.out.print(current.data);
//
//				}
//			}
//			
//			current = current.next;
//		}
//		// Append all node 
////		a.next = b.next;
////		b.next = c.next;
////		// last node null to break cycle. Since its coming from curr. this might not be the end node or null. Break the cycle. 
////		c.next = null;
////		node = a;
//	}
	

	public static void main(String[] args) {
		LinkedListDutchNationalFlag ll = new LinkedListDutchNationalFlag();

		int[] a = new int[] { 1, 2, 0, 2, 1, 0 };

		for (int z : a) {
			ll.add(z);
		}
		ll.sort();
//		while (ll.node != null) {
//			System.out.println(ll.node.data);
//			ll.node = ll.node.next;
//		}
	}
}
