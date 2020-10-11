public class BinaryTreeLowerAncestor {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    //Really good explanation: https://youtu.be/py3R23aAPCA?t=412

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }

        if(root.val == p.val || root.val==q.val ){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
      // At this point we have results to analyze. left or right will either return null or result

        //one side of three can be null. It means other holds the result and is LCA
        if(left == null){
            return right;
        }

        if(right == null){
            return left;
        }

        // if none of above return result that means root is LCA
        return root;

    }


}
