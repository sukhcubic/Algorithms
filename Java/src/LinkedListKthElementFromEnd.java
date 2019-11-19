// Find nth Node from the end of a Linked List


public class LinkedListKthElementFromEnd {
	// Ref: https://www.ideserve.co.in/learn/find-nth-node-from-the-end-of-linked-list
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
 

 private int find(int positionFromEnd) {
//	 In this method, we use only one traversal of the given linked list to find out 'n'th node from the end. Here we use two references to nodes - 'node1' and 'node2'.
//	 1. We make 'node1' and 'node2' point to first node of the list.
//	 2. We advance 'node1' by 'n' nodes(to find out 'n'th node from last). Basically 'node1' would be pointing to (n+1)th node from the beginning.
//	 3. If 'node1' is not pointing to (n+1)th node and has already reached the end of the list then we know that number of nodes in the given list is less than 'n' and hence 'n'th node from the end cannot be found in this case. We simply return -1 to indicate that.
//	 4. Now knowing that 'node1' is pointing to (n+1)th node and 'node2' is pointing to the first node in the list, we advance both references('node1' and 'node2') simultaneously one node at a time until 'node1' reaches the end of the list. When 'node1' reaches the end of the list, 'node2' would be pointing to the node which is 'n'th from the end. This is because when we started advancing references 'node1' and 'node2', difference between them was of 'n' nodes which is maintained while advancing these references.
//	 5. Because 'node2' is pointing to 'n'th node from the end, we simply return value of node which 'node2' points to.

	 int value = 0;
	 Lnode one = node;
	 Lnode two = node;
	 int initialPosition = 1;
	 while(two != null) {
//		 System.out.print(initialPosition + "   initialPosition  ");
		 two = two.next;
		 initialPosition++;
		 if(initialPosition > positionFromEnd) {
//			System.out.print("   increment        ");

		 if(two == null) {
			value = one.data; 
		 }else {
			one = one.next;
		 }
		 }
	 } 
	 return value;
 }
 
public static void main(String[] args) {
	 LinkedListKthElementFromEnd ll = new LinkedListKthElementFromEnd();

		int[] a = new int[] {12, 34, 6, 7, 8, 45 , 78, 9809, 9};


		for(int z :a) {
			ll.add(z);
		}

		Lnode current = ll.node;
		 System.out.print("  Adding node \n" );

		while(current != null) {
		 System.out.print(current.data + "\n");
		 current = current.next;
		}
		
		System.out.print( " Found element "+ll.find(3));
	}
}
