//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class LinkedListRemoveDuplicates {

	Lnode node;
    
	private Lnode removeDup(Lnode head) {
    	Lnode current = head;
    	while(current != null && current.next != null) {
    		//1 2 3 3 4 5
    		// Checking if current and next will stay same but current.next will point to next.next  and 
    		// shortened the list but removing current.next reference to current.next.next
    		if(current.data == current.next.data){
    			current.next = current.next.next;
    			//1 2 3 4 5
    			// we are one updating next reference. current will stay at 3. Once 3 reference is removed then it will
    			// fall back to else condition which will actually move current pointer.
    		}
    		else {
    			current = current.next;
    			// updating current so actual pointer can move forward.
    		}
    	}	
    	return head;
    }
  
  // Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
  	private Lnode removeDupii(Lnode head) {
    	Lnode current = head;
    	while(current != null && current.next != null) {
    		//1 2 3 3 4 5
    		// Checking if current and next will stay same but current.next will point to next.next  and 
    		// shortened the list but removing current.next reference to current.next.next
    		if(current.data == current.next.data){
    			current.next = current.next.next;
    			//1 2 3 4 5
    			// we are one updating next reference. current will stay at 3. Once 3 reference is removed then it will
    			// fall back to else condition which will actually move current pointer.
    		}
    		else {
    			current = current.next;
    			// updating current so actual pointer can move forward.
    		}
    	}	
    	return head;
    }

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
	
	public static void main(String[] args) {
		LinkedListRemoveDuplicates ll = new LinkedListRemoveDuplicates();

			int[] a = new int[] {1, 2, 3, 3, 4, 5};
			for(int z :a) {
				ll.add(z);
			}
			
			//Lnode current = ll.removeDup(ll.node);
			Lnode current = ll.removeDupii(ll.node);

			while(current != null) {
				 System.out.print(current.data + ", ");
				 current = current.next;
				}
	}
}
