public class BinaryTreeMinimumAbsoluteDiff {
    //https://leetcode.com/problems/minimum-absolute-difference-in-bst/
    
    //Write all the values to an array, then sort it. The minimum distance must occur between two adjacent values in the sorted list.
    //o(nlogn)
    
    //or 
    
    //Wrire in order traversal
    //o(n)
    

    Integer sum, prev;
    public int getMinimumDifference(TreeNode root) {
        sum = Integer.MAX_VALUE;
        prev = null;
        helper(root);
        return sum;

    }
    void helper(TreeNode node){
        if(node == null){
            return;
        }

        helper(node.left);

        if(prev != null){
            sum =  Math.min(Math.abs(prev - node.val), sum);
        }
        prev = node.val;
        helper(node.right);
    }

    public static void main(String args[]){
        //[543,384,652,null,445,null,699]
        //47
        TreeNode node = new TreeNode();
        node.val = 543;
        node.left = new TreeNode(384, null, new TreeNode(445, null, null));
        node.right = new TreeNode(652, null, new TreeNode(699, null, null));

        //[236,104,701,null,227,null,911]
        //9
        TreeNode node1 = new TreeNode();
        node1.val = 236;
        node1.left = new TreeNode(104, null, new TreeNode(227, null, null));
        node1.right = new TreeNode(701, null, new TreeNode(911, null, null));

        BinaryTreeMinimumAbsoluteDiff test = new BinaryTreeMinimumAbsoluteDiff();

        System.out.println(test.getMinimumDifference(node1));

    }
}


/**
 * Definition for a binary tree node.
 */
class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }
