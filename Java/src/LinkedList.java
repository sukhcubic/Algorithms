

public class LinkedList {
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
 
 public void remove(int value) {
	 Lnode current = node;
	 Lnode previous = node;

	 if(node.data == value) {
		 node = node.next;
		 return;
	 }
	 //https://www.youtube.com/watch?v=0ZEX_l0DFK0
	 while(current.next != null) {
		 if(current.next.data == value) {
			 previous = current; 
			 break;
		 }
        current = current.next;
	 }
	 
	 if(current.next.next != null) {
		 previous.next = current.next.next;
	 }else {
		 previous.next = null;
	 }
 }

		public Node getMiddle() {
		// Move second pointer twice as much get get middle in N/2 time complexity
		Node last = node;
		Node first = node;
		while (last != null) {
			if (last.next != null && last.next.next != null) {
				last = last.next.next;
				first = first.next;
			} else {
				last = null;
			}
		}
		return first;
	}
	
	 public void removeMiddle() {
	 Lnode current = node;
	 Lnode previous = null;
	 Lnode first = node;
	 while(current != null) {
		 if(current.next != null && current.next.next!= null) {
		   current = current.next.next;
		   previous = first;
		   first = first.next;
		 }else {
		   current = null;
		 }
	 }
	 
	 previous.next = first.next;
 }
 
 
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();

		int[] a = new int[] {12, 34, 6, 7, 8, 45 , 78, 9809};


		for(int z :a) {
			ll.add(z);
		}
	
		Lnode current = ll.node;
		 System.out.print("  removing node "
		 		+ "");

		while(current != null) {
		 System.out.print(current.data + "\n");
		 current = current.next;
		}
		
		ll.remove(12);
		 System.out.print("  removing node 78 \n"
			 		+ "");
		Lnode current1 = ll.node;
		while(current1 != null) {
		 System.out.print(current1.data + "\n");
		 current1 = current1.next;
		}

	}
}
