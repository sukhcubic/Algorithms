
public class DoublyLinkedList {
	
class Node{
	int data;
	Node previous;
	Node next;
	Node(int data){
		this.data = data;
	}
}
 
 static Node node;
    
 public void add(int value) {
	 Node current = node;
	 if(current == null) {
		 node = new Node(value);
		 return;
	 }
	 
	 while(current.next != null) {
        current = current.next;
	 }
	 
//	 if(current.next == null && current.previous == null) {
//	   current.next = new Node(value);
//		 n.previous = current;
//
//	 }else {
		 Node n = new Node(value);
		 current.next = n;
		 n.previous = current;
	// }
    
 }
 
 public void remove(int value) {
	 Node current = node;
	 if(node.data == value) {
		 node = node.next;
		 node.previous = null;
		 return;
	 }
	 
	 while(current.next != null) {
		 if(current.data == value) {
			 Node previous = current.previous;
			 Node next = current.next;
			 previous.next = next;
			 next.previous = previous;
			 break;
		 }
        current = current.next;
	 }
 }
	
 
	public static void main(String[] args) {
		DoublyLinkedList ll = new DoublyLinkedList();
		int[] a = new int[] {12, 34, 6, 7, 8, 45 , 78, 9809};
		for(int z :a) {
			ll.add(z);
		}
		ll.remove(7);
        Node current = node;
		while(current != null) {
		 System.out.print(current.data + "\n ");
		 if(current.previous != null) {
			 System.out.print(current.previous.data + " previous \n");

		 }
		 current = current.next;
		}

	}
}
