public class LinkedListSwapNodes {
    Lnode node;

	private void swap() {
		Lnode head = node;
		Lnode current = node;
		Lnode swapHead = null;
		while(current != null) {	
			if(current.next == null ) {
				return;
			}
			System.out.print(" \n Current  node " + current.data);

			if(swapHead == null) {
				swapHead = head.next;
				head.next = head.next.next;
				System.out.print(" \n head  node " + head.data);

				System.out.print(" \n swapHead  node " + swapHead.data);

				head = swapHead;
				System.out.print(" \n swapHead  node " + head.data);
				

			}f
			current = current.next;
		}
		node = swapHead;
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
		LinkedListSwapNodes ll = new LinkedListSwapNodes();

			int[] a = new int[] {1,2,3,4,5,6,7,8, 9};
			for(int z :a) {
				ll.add(z);
			}
			Lnode current = ll.node;
			ll.swap();
			 System.out.print("\n" );

			while(current != null) {
				 System.out.print(current.data + ", ");
				 current = current.next;
				}
			
	}
}
