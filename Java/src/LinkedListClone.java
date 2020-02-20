class LinkedListClone{
 //https://www.youtube.com/watch?v=tCROpuE3EpQ
 //https://www.youtube.com/watch?v=EHpS2TBfWQg
 //https://www.geeksforgeeks.org/clone-linked-list-next-random-pointer-o1-space/
  
    static class Node {
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
            head.next.random =  head.random.next;
//            if(head.next != null){
//                head = head.next.next;
//            }else{
//                head = head.next;
//            }
            head = (head.next != null) ? head.next.next: head.next;
        }

        head = root;
        // reset all the pointers so we have two separate lists
        // one way of doing
//        Node temp = new Node(0);
//        Node cloned = temp;
//        while(head != null){
//            temp.next = head.next;
//            temp = temp.next;
//            head = (head.next != null) ? head.next.next: head.next;
//        }
//        return  cloned.next;

        
        //.Other way of doing
        Node temp = head.next;
        Node clone = temp;
        while(head != null &&  temp != null ){
              // if temp.next is not null we are pointing temp node if null we are pointing null
              head.next = (head.next != null)? head.next.next:head.next;
              temp.next = (temp.next != null)? temp.next.next:temp.next;
//              if(temp.next != null){
//                  temp.next = temp.next.next;
//              }else{
//                  temp.next = temp.next; // which is null
//              }
              head = head.next;
              temp = temp.next;
        }
        return clone;
    }

    public static void main(String[] args) {

        CloneLinkedList a = new CloneLinkedList();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next.next.next;
        head.next.next.next.next.random = head.next;
        Node clone = a.clone(head);

        while(clone != null){
            System.out.println( "  clone data "+ clone.key);
            clone = clone.next;
        }
    }
  
}
