class BinaryTreeSerializeDeserialize{
    //https://www.youtube.com/watch?v=suj1ro8TIVY
    //https://www.youtube.com/watch?v=lUnNK9jPg2Y
    
//     StringBuilder sb = new StringBuilder();
//     public String serialize(Node root){
//          if(root == null){
//              return null;
//          }
//          serialize(root.left);
//          serialize(root.right);
//          sb.append(root.key + ",");
//          return sb.toString();
//     }
	
	  class Node {
	        int key;
	        Node left, right;

	        public Node(int item) {
	            key = item;
	            left = right = null;
	        }
	    }
	    Node root;

	    void insert(int val) {
	        root = insertNode(root, val);
	    };

	    Node insertNode(Node root, int val) {
	        if (root == null) {
	            root = new Node(val);
	            return root;
	        }
	        if (val > root.key) {
	            root.right = insertNode(root.right, val);
	        } else {
	            root.left = insertNode(root.left, val);
	        }
	        return root;
	    }

	  public String serialize(Node root){
		  if(root == null) {
			  return "x";
		  }
		  
		  String a = serialize(root.left);
		  String b = serialize(root.right);
		  
		  return String.valueOf(root.key) + "," + a+ ","+ b;
	  }

	  public Node Deserialize(String tree){
		  Queue<String> queue = new LinkedList<>();
		  queue.addAll(Arrays.asList(tree.split(",")));
	   return null;
	  }
	  
	  private Node helper(Queue que) {
		  String val = que.poll();
		  
		  if(val.equals("x")) {
			  return null;
		  }
		  Node node = new Node(Integer.parseInt(val));
		  
		  node.left = helper(que);
		  node.right = helper(que);
		  
		  return node;
	  }
	  
      public static void main(String args[]) {
    	  BinaryTreeSerializeDeserialize bst = new BinaryTreeSerializeDeserialize();
          bst.insert(10);
          bst.insert(8);
          bst.insert(7);
          bst.insert(9);
          bst.insert(5);
          bst.insert(15);
          bst.insert(11);
          bst.insert(13);
          bst.insert(14);
          bst.insert(16);
          bst.insert(17);
//          for ( int val: bst.rightSideView(bst.root)) {
//              System.out.println("  rightside view " + val);
//          }
          
          System.out.print(bst.serialize(bst.root));
      }
}
