class BinaryTree{

 class Node {
        int val;
        Node left, right;

        public Node(int item) {
            val = item;
        }
        
        
        private void insert(int value) {
          if(value > val) {
        	  if(right == null) {
        		 right = new Node(value); 
        	  }else {
        		 right.insert(value); 
        	  }
          }else {
        	  if(left == null) {
        		  left = new Node(value);
        	  }else {
        		  left.insert(value);
        	  }
          }
        	
        }
        
        
        private boolean contain(int value) {
        	
        }
        
        
  
    public static void main(String args[]) {
//        BinarySearchTree bst = new BinarySearchTree();
    	Node bst = new Node(10);
//        bst.insert(10);
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
        System.out.print(bst.findClosest(bst.root, 5));
        //bst.printAll(bst.root);
        //System.out.print(bst.find(bst.root, 5));
        //System.out.print(bst.floor(bst.root, 15));
        //System.out.print(bst.ceiling(bst.root, 15));
        //bst.delete(bst.root, 15);
    }


}
