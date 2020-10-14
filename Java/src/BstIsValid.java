//https://www.youtube.com/watch?v=U9izQCtpVHc
//https://www.youtube.com/watch?v=Z_-h_mpDmeg
//https://www.youtube.com/watch?v=MILxfAbIhrE
class BstIsValid {
  public static boolean validateBst(BST tree) {

		if(tree == null){
			return true;
		}
    return isValid(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
	
	public static boolean isValid(BST tree, int min, int max){
		//Base case empty tree is valid BST
		if(tree == null){
			return true;
		}
		
		if(tree.value <= min || tree.value > max){
			return false;
		}
		// tree.value is root value. For left subtree it is -infinity and root value, for right subtree, it is root value and +infinity.
		return isValid(tree.left, min, tree.value ) && isValid(tree.right, tree.value, max);
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
