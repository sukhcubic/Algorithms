public class LinkedListSwap {
    Lnode node;
    //https://www.youtube.com/watch?v=bM2kxaTUwGw
    //https://www.youtube.com/watch?v=-xwX521Ija4
	private Lnode swap(Lnode node) {
		Lnode temp = new Lnode(0);
		//0
		temp.next = node;
		Lnode current = temp;
		//0,1,2,3,4,5
		while(current.next != null && current.next.next != null) { 	
			System.out.print(current.data + "  " + current.next.data + "\n");
			Lnode one = current.next;
			//1,2,3,4,5
			Lnode two = current.next.next;
			//2,3,4,5
			one.next = two.next;
			//1,3,4,5
		    current.next = two;	 
		    // 0,2,3,4,5
		    current.next.next = one;
		    //0,2,1,2,3,4,5 is wrong because one.next = two.next // 1,3,4,5
		    // 0,2,1,3,4,5 is correct answer
		    current = current.next.next;	
		    //1,3,4,5
		}
		
		return temp.next;
		

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
		LinkedListSwap ll = new LinkedListSwap();

			int[] a = new int[] {1,2,3,4,5};
			for(int z :a) {
				ll.add(z);
			}
			Lnode node = ll.node;
			Lnode current = ll.swap(node);
			 System.out.print("\n" );

			while(current != null) {
				 System.out.print(current.data + ", ");
				 current = current.next;
				}
			
	}
}
