public class ReverseLinkedList {

Lnode node;
    
 public void add(int value) {
	 Lnode current = node;
	 if(current == null) {
		 node = new Lnode(value);
		 return;
	 }
	 while(current.next != null) {
        current = current.next;
	 }
	 current.next = new Lnode(value);;
    
 }
 
 public void reverse() {
	 System.out.print(node.data + "   head node  ");

	 if(node == null) {
		return; 
	 }
	 // Maintain three pointers
	 Lnode current = node;
	 Lnode previous = null;
	 Lnode next = null;
	 
	 while(current != null) {
		 // Created another reference to next node otherwise we will stay at same node forever.
		 next = current.next;
		 // set current .next pointer to previous which is null initially
		 current.next = previous;
		 // for next iteration previous has value. which is current at the moment but becomes previous when look again.
		 previous = current;
		 // increment pointer to next node 
	     current = next;
	   }
	 //head becomes previous node. don't set to current. Current is null;
	 node = previous;
	 
	 System.out.print(node.data + "\n ");

	 System.out.print(node.next.data + "\n ");

	 System.out.print(node.next.next.data + "\n ");
	 
	 System.out.print(node.next.next.next.data + "\n ");

	 System.out.print(node.next.next.next.next.data + "\n ");

	 System.out.print(node.next.next.next.next.next.data + "\n ");

	 System.out.print(node.next.next.next.next.next.next.data + "\n ");

	 System.out.print(node.next.next.next.next.next.next.next.data + "\n ");

 }
	
	 public static void reverseRecursively(Lnode head) {
	 //Todo: Recursively
	 //https://www.programcreek.com/2014/05/leetcode-reverse-linked-list-java/
	 
	 if(head == null) {
		return; 
	 }
	 reverseRecursively(head.next);
	 Lnode nxt = head.next;
	 nxt.next = head;
	 head.next = null;
 }

	public static void main(String[] args) {
		ReverseLinkedList ll = new ReverseLinkedList();
		int[] a = new int[] {12, 34, 6, 7, 8, 45 , 78, 9809};
		for(int z :a) {
			ll.add(z);
		}
	
		Lnode current = ll.node;

		while(current != null) {
		 System.out.print(current.data + "\n");
		 current = current.next;
		}
	}
}
