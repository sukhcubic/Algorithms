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

}
