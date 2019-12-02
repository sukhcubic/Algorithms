
public class LinkedListMergeSort {

    Lnode node;
    private Lnode merge(Lnode one, Lnode two) {
    	Lnode node = new Lnode(0);
        Lnode curr = node;
        
        while(one != null && two != null) {
        	
        	if(one.data < two.data ) {
        		curr.next = one;
        		one = one.next;
        	}else {
        		curr.next = two;
        		two = two.next;
        	}
        	curr = curr.next;
        }
        
        curr.next = one == null ?  two : one;
        
        return node.next;
    	
    }
    
	public void add(int value) {
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
	
	private Lnode getMiddle(Lnode node) {
		Lnode start = node;
		Lnode fast = node;
		
		while(fast != null && fast.next != null) {
			start = start.next;
			fast = fast.next.next;
		}
		
		return start;
	}
	
	public Lnode mergesort(Lnode node) {
		 if(node == null || node.next == null) {
			 return node;
		 }
		Lnode mid = getMiddle(node);
		Lnode secondnxt = mid.next;
		mid.next = null;
		Lnode first = mergesort(node);
		Lnode second = mergesort(secondnxt);
		
		 
		return merge(first, second);
	}
	
	public static void main(String[] args) {
		LinkedListMergeSort ll = new LinkedListMergeSort();

			int[] a = new int[] {1,2,3, 3, 1,2,1};
			for(int z :a) {
				ll.add(z);
			}
			
			Lnode current = ll.mergesort(ll.node);
			
			while(current != null) {
				 System.out.print(current.data + ", ");
				 current = current.next;
			}
	}
}
