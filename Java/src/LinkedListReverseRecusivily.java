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
		if(nd == null || nd.next == null) {
			return nd;
		}
		
		Lnode head = reverse(nd.next);	
		
		nd.next.next = nd;
		
		nd.next = null;
	
		return head;
	}
	 
	public static void main(String[] args) {
		LinkedListReverseRecersivily ll = new LinkedListReverseRecersivily();
		int[] a = new int[] {12, 34, 6, 7, 8, 45 , 78, 9809, 9};
		for(int z :a) {
			ll.add(z);
//			 System.out.print("node"
//				 		+ ll.node.data + "\n");
		}
		
		reverse(ll.node);

		Lnode current = ll.node;
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
