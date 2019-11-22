
public class LinkedList {
    Lnode node;
	
    //Lnode current = node;


 public void add(int value) {
	 //This has to be the local if make global pointer will always be pointing to last node. 
	 //In order to traverse list from beginning either create new node and change references or use existing
	 //which will reset reference each time.
	 Lnode current = node;

	 if(current == null) {
		 node = new Lnode(value);
		 return;
	 }
	 System.out.print("node"
		 		+ current.data + "\n");
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

		int[] a = new int[] {12, 34, 6, 7, 8, 45 , 78, 9809, 9};


		for(int z :a) {
		
			ll.add(z);
			 System.out.print("node"
				 		+ ll.node.data + "\n");
		}
	
		Lnode current = ll.node;
		

		while(current != null) {
			System.out.print("node current"
			 		+ ll.node.data + "\n");
		 System.out.print(current.data + "\n");
		 current = current.next;
		}
		
//		//ll.remove(12);
//		ll.removeMiddle();
//		 System.out.print("  removing node 78 \n"
//			 		+ "");
//		Lnode current1 = ll.node;
//		while(current1 != null) {
//		 System.out.print(current1.data + "\n");
//		 current1 = current1.next;
//		}

	}
}
