class LinkedListClone{
 //https://www.youtube.com/watch?v=tCROpuE3EpQ
 //https://www.youtube.com/watch?v=EHpS2TBfWQg
 //https://www.geeksforgeeks.org/clone-linked-list-next-random-pointer-o1-space/
  //Todo
  class Node {
        int key;
        Node random, next;

        public Node(int item) {
            key = item;
            random = next = null;
        }
    }

    public Node clone(Node head){
        Node root = head;
        Node  next = null;

        // Inserting new node in middle of existing list
        while(head != null){
            next = head.next;
            Node inserted = new Node(head.key);
            head.next = inserted;
            inserted.next = next;
            head = next;
        }

        //reset pointer back to head
        head =  root;

        //point all random to inserted.next
        while(head != null){
            
        }

        return  root;
    }
  
}
