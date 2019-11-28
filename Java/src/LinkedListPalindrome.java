public class LinkedListPalindrome {
    Lnode node;
    
    private boolean isPalindrome(Lnode node) {
    	Lnode fast = node;
    	Lnode slow = node;
    	
    	while(fast != null && fast.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    		// Slow is in the middle now
    	}
    	
    	// reverse second half and point back to slow or new node
		System.out.print(" mid "+ slow.data);

    	slow = reverse(slow);
    	
		System.out.print(" reversed "+ slow.data);

    	// fast is pointing to start
    	fast = node;
    	
    	while(slow != null) {
    		System.out.print(" slow "+ slow.data);
    		System.out.print(" fast "+fast.data);

    		if(slow.data != fast.data) {
    			return false;
    		}
    		
    		slow = slow.next;
    		fast = fast.next;
    	}
    	
    	
    	return true;
    }
    
    private Lnode reverse(Lnode current) {
    	Lnode previous = null;
    	Lnode node = current;
    	while(node != null) {
    		Lnode next = node.next;
    		node.next = previous;
    		previous = node;
    		node = next;
    	}	
    	return previous;
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
		LinkedListPalindrome ll = new LinkedListPalindrome();

			int[] a = new int[] {1,2,3, 3, 1,2,1};
			for(int z :a) {
				ll.add(z);
			}
			
			System.out.print("\n" + ll.isPalindrome(ll.node) );

	}
}
