public class BinaryTreeTargetSum {

    // Driver code
    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);

        System.out.println(targetSum(root,  5));

    }


    static int sum = -1;


    private static int targetSum(TreeNode root, int target) {
        helper(root, target, 0);
        return sum;
    }

    private  static void helper(TreeNode node, int target, int runningSum){

//TIP:
// check sum first the peform node null check otherwise result will not be correct.
        if(target == runningSum){
          sum = 1;
          return;
        }
        if(node == null){
            return;
        }


        runningSum = runningSum+node.val;
        helper(node.left, target, runningSum);
        //runningSum = runningSum-node.val;
        helper(node.right, target, runningSum);


    }
}
