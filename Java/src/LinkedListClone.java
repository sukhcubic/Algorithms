class LinkedListClone{
 //https://www.youtube.com/watch?v=tCROpuE3EpQ
//https://www.youtube.com/watch?v=EHpS2TBfWQg
  //Todo
  public Node clone(Node root){
    Node parent = root;
    Node next = null
    while(current != null){
      next = current.next;
      Node clone = new Node(current.data);
      clone.next = current.next;
      current = next;
    }
    
  }
  
  
}
