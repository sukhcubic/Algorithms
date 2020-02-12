class BstMaxPathSum{
  //https://medium.com/algorithm-and-datastructure/binary-tree-maximum-path-sum-3e5a0353a55a
  //https://www.youtube.com/watch?v=p8P4Iv1rrtg
   public int sum(BstNode root){
     
     if(root == null){
        return 0;
     }
   
     int leftSum = sum(root.left);
     int rightSum = sum(root.right);
     
     int branchSum = Math.max(Math.max(leftSum, rightSum) + root.value, root.value);
     
     int branchTop = Math.max(branchSum, leftSum+rightSum+branchSum );
     
    
   }

  

}
