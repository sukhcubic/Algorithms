class BstInvert{

    public void invert(BstNode root){
        if(root == null){
            return;
        }

        if(root.left != null || root.right != null){
        
          BstNode temp = root.left;
          root.left = root.right;
          root.right = temp;
          
        }

        invert(root.left);
        invert(root.right);
    }

    // leetcode recursive
    public BstNode invertTree(BstNode root) {
      if (root == null) {
        return null;
       }
       BstNode right = invertTree(root.right);
       BstNode left = invertTree(root.left);
       root.left = right;
       root.right = left;
       return root;
     }
    
    public BstNode invertTree(BstNode root) {
        
        if(root == null){
            return null;
        }
        
        ArrayDeque<BstNode> queue = new ArrayDeque<BstNode>();
        
        queue.addLast(root);
        
        while(queue.size() > 0){
            BstNode current = queue.pollFirst();
            BstNode temp = current.right;
            current.right = current.left;
            current.left = temp;
            
            if(current.left != null){
                queue.addLast(current.left);
            }
            if(current.right != null){
                queue.addLast(current.right);
            }
            
        }
        
        return root;
    }

}
