//https://www.youtube.com/watch?v=U9izQCtpVHc
//https://www.youtube.com/watch?v=Z_-h_mpDmeg
//https://www.youtube.com/watch?v=MILxfAbIhrE
class BstIsValid {
 
  public boolean isValidBST(TreeNode root) {
     
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    
    boolean helper(TreeNode tree, long min, long max){
            //Base case null root is valid BST
       	      if(tree == null){
			return true;
		}
		//check if it is between parent + -ve infinty for left and between  parent and +infinity on right sub tree
		if(tree.val <= min || tree.val >= max){
			return false;
		}
		// tree.value is root value. For left subtree it is -infinity and root value, for right 
        //subtree, it is root value and +infinity.
		return helper(tree.left, min, tree.val ) && helper(tree.right, tree.val, max);
    }
	
//     public static boolean isValid(BST tree, int min, int max){
		
// 		if(tree.value < min || tree.value >= max){
// 			return false;
// 		}
// 		if(tree.left!= null && !isValid(tree.left, min, tree.value) ) {
// 			return false;
// 		}
// 	  if(tree.right  != null && !isValid(tree.right, tree.value, max)){
// 			return false;
// 		}
			 
// 		return true;
// 	}

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
