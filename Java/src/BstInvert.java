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


}
