public class BinaryTreeAllLeftLeaveSum {
//Left leave sum
//Given a binary tree, return the sum of all left leaves of the tree. Ex: Given the following tree…

//    5
//   / \
//  2   12
//     /  \
//    3    8
// return 5 (i.e. 2 + 3)
//       2
//      / \
//    4    2
//   / \ 
//  3   9 
// return 3 (i.e. 2 + 3)

    static int sum(TreeNode root){
        if(root == null){
            return 0;
        }

        return helper(root);
    }

    static int helper(TreeNode node){
        if(node == null){
           return 0;
        }
        if(node.left != null && node.left.left == null && node.left.right == null ){
            return node.left.val;
        }
        int leftsubtree = helper(node.left);
        int right = helper(node.right);

        return leftsubtree+right;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(7);



        System.out.println(sum(root));


    }
}


