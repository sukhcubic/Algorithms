//Delete a middle node from linked list
//https://www.youtube.com/watch?v=Cay6RsoIG78&list=PLamzFoFxwoNiAFTHWT-v7jtLAGbMn0Mar&index=4

class DeleteNode{
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
	 current.next = new Lnode(value);
 }
 
 public void removeMiddle() {
  // In Single linked list we cannot go back. The trick is copy data of next node into 
  //current node and delete next node and joint link to next node

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
		
		ll.removeMiddle();
		 System.out.print("  removing node 78 \n"
			 		+ "");
		Lnode current1 = ll.node;
		while(current1 != null) {
		 System.out.print(current1.data + "\n");
		 current1 = current1.next;
		}

	}
}


}
