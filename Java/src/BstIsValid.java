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
	
	
	//ANOTHER. WAY:          //Inorder traversal of BST always have sorted elements

	List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
     
        if(root == null){
           return true; 
        }
        long prev = Long.MIN_VALUE;
        helper(root);
        for(int i:list){
            if(i<= prev){
               return false; 
            }
            prev = i;
        }
        
        return true;
    }
    
    void helper(TreeNode node){
        if(node == null){
            return;
        }
        //Inorder traversal of BST always have sorted elements
        helper(node.left);
        list.add(node.val);
        helper(node.right);
    }
	
	
	
	  public boolean isValidBST(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr =  root;
        TreeNode last = null;

        while (!stack.isEmpty() || curr != null ){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;

            }else{
                curr = stack.pop();
                if(last != null && last.val >= curr.val){
                    return false;
                }
                last = curr;
                curr = curr.right;
            }
        }
        return true;
	  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
