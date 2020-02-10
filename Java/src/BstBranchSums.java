class BstBranchSums{
 
  public static List<Integers> findSum(BST node){
  
   List<Integer>  sum = new ArrayList<Integer>();
   helper(node, sum, 0);
   return sum;
   
  }
 
  public static void helper(BST node, List<Integers>  vals , int sum){
   
   if(node == null){
    return;
   }
   int newSum = sum + node.value;
   if(node.left == null || node.right == null){
     vals.add(sum);
     return;
   }

   helper(node.left, vals, newSum);
   helper(node.right, vals, newSum);
 }

}
