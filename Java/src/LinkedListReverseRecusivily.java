public class LinkedListReverseRecersivily {

	//Explanation: https://www.youtube.com/watch?v=S92RuTtt9EE
	//https://www.youtube.com/watch?v=Ip4y7Inx7QY    
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
	
	public static Lnode reverse(Lnode nd) {
		//Explanation: https://www.youtube.com/watch?v=S92RuTtt9EE
		//https://www.youtube.com/watch?v=Ip4y7Inx7QY
		if(nd == null) {
			// It means list is null
			return null;
		}else if(nd.next == null) {
			// next is null or very last element is null. Since we are reversing the list, recursive call will hit 
			// last element i.e 5.next is null we we return current node. This will be our base case as well.
			return nd;
		}else {
		    Lnode head = reverse(nd.next);	
		    // After hitting 5 our head is 5 and we are at 4 since result is returned to 4. Because we are passing nd.next
		    // This is tricky part, 4.next is 5 and 5.next or 4.next.next = nd in other ways 4 is pointing to 5 and 5 is pointing to 4.
		    //we have reversed the last node
		    nd.next.next = nd;	
		    // Since 4 is pointing to 5 and 5 is pointing to 5 after reversal we will make 4.next null
		    nd.next = null;
		    return head;
		}
	}
	
// 	public static Lnode reverse(Lnode nd) {
// 		//Explanation: https://www.youtube.com/watch?v=S92RuTtt9EE
// 		if(nd == null || nd.next == null) {
// 			return nd;
// 		}
		
// 		Lnode head = reverse(nd.next);	
		
// 		nd.next.next = nd;
		
// 		nd.next = null;
		
// 		return head;
// 	}
	 
	public static void main(String[] args) {
		LinkedListReverseRecersivily ll = new LinkedListReverseRecersivily();
		int[] a = new int[] {1,2,3,4,5};
		for(int z :a) {
			ll.add(z);
//			 System.out.print("node"
//				 		+ ll.node.data + "\n");
		}
		
		

		Lnode current = reverse(ll.node);
		while(current != null) {
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
