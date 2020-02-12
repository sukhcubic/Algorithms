class BstMaxPathSum{
  //https://medium.com/algorithm-and-datastructure/binary-tree-maximum-path-sum-3e5a0353a55a
  //https://www.youtube.com/watch?v=p8P4Iv1rrtg
  
//    int sum = Integer.MIN_VALUE;
//    public int sum(BstNode root){
     
//      if(root == null){
//         return 0;
//      }
   
//      int leftSum = sum(root.left);
//      int rightSum = sum(root.right);
     
//      int currentSum = Math.max(Math.max(leftSum, rightSum) + root.value, root.value);
     
//      sum = Math.max(sum, Math.max(currentSum, leftSum+rightSum+root.value );
     
//      return currentSum;
   
//    }
  
  
  // Leet code submitted
  
   int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        

        helper(root);
        
        
        return sum;
    }
    
    public int helper(TreeNode root){
        
        if(root ==null){
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int current =  Math.max(Math.max(left, right) + root.val, root.val);
        
        sum = Math.max(sum, Math.max(current,  left+right+root.val));
          
        return current;
    }
                    
}
