public class ReverseLinkedList {

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
 
 public void reverse() {
	 System.out.print(node.data + "   head node  ");

	 if(node == null) {
		return; 
	 }
	 // Maintain three pointers
	 Lnode current = node;
	 Lnode previous = null;
	 Lnode next = null;
	 
	 while(current != null) {
		 // Created another reference to next node otherwise we will stay at same node forever.
		 next = current.next;
		 // set current .next pointer to previous which is null initially
		 current.next = previous;
		 // for next iteration previous has value. which is current at the moment but becomes previous when look again.
		 previous = current;
		 // increment pointer to next node 
	     current = next;
	   }
	 //head becomes previous node. don't set to current. Current is null;
	 node = previous;
	 
	 System.out.print(node.data + "\n ");

	 System.out.print(node.next.data + "\n ");

	 System.out.print(node.next.next.data + "\n ");
	 
	 System.out.print(node.next.next.next.data + "\n ");

	 System.out.print(node.next.next.next.next.data + "\n ");

	 System.out.print(node.next.next.next.next.next.data + "\n ");

	 System.out.print(node.next.next.next.next.next.next.data + "\n ");

	 System.out.print(node.next.next.next.next.next.next.next.data + "\n ");
      }
	
 //https://javarevisited.blogspot.com/2017/03/how-to-reverse-linked-list-in-java-using-iteration-and-recursion.html

    //https://www.youtube.com/watch?v=O0By4Zq0OFc

    //https://www.youtube.com/watch?v=MRe3UsRadKw

    //Real Explanation: https://youtu.be/S92RuTtt9EE?t=458

    public class ListNode { int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode reverseList(ListNode head) {
        if(head == null){
           return head;
        }

        if(head.next == null){
            return head;
        }
        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;

       return listNode;
    }

	public static void main(String[] args) {
		ReverseLinkedList ll = new ReverseLinkedList();
		int[] a = new int[] {12, 34, 6, 7, 8, 45 , 78, 9809};
		for(int z :a) {
			ll.add(z);
		}
	
		Lnode current = ll.node;

		while(current != null) {
		 System.out.print(current.data + "\n");
		 current = current.next;
		}
	}
}
