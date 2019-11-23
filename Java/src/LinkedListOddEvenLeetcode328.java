public class LinkedListOddEvenLeetcode328 {
//https://leetcode.com/problems/odd-even-linked-list/
    Lnode node;

	public void add(int value) {
		 //This has to be the local if make global pointer will always be pointing to last node. 
		 //In order to traverse list from beginning either create new node and change references or use existing
		 //which will reset reference each time.
		 Lnode current = node;
		 if(current == null) {
			 node = new Lnode(value);
			 return;
		 }
		 while(current.next != null) {
	        current = current.next;
		 }
		 current.next = new Lnode(value);
	 }
	
	private void sort() {
		 Lnode odd1 = new Lnode(0);
		 Lnode even1 = new Lnode(0);
		 Lnode odd = odd1;
		 Lnode even = even1;
		 Lnode current = node;
		 boolean set = true;
		 while(current != null) {	
			 if(set) {
	           even.next = current;
	           even = even.next;
	           set = false;
			 }else {
		       odd.next = current;
		       odd = odd.next; 
		       set = true;
			 }
			 current = current.next;
		 }
	     even.next = odd1.next;
	     odd.next = null;
		 node = even1.next;
	}
	
	public static void main(String[] args) {
		LinkedListOddEvenLeetcode328 ll = new LinkedListOddEvenLeetcode328();

			int[] a = new int[] {12, 34, 6, 7, 8, 45 , 78, 9809, 9};


			for(int z :a) {
				ll.add(z);
			}

			Lnode current = ll.node;
			 System.out.print("Adding node \n" );

	
			
			ll.sort();
			
			while(current != null) {
				 System.out.print(current.data + ", ");
				 current = current.next;
				}
			
	}
}
