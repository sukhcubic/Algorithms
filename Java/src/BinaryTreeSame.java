public class BinaryTreeSame {

    //Recursive
    static boolean same(TreeNode a, TreeNode b){
        if(a == null && b == null){
          return true;
        }
        if(a == null || b == null){
            return false;
        }
        if(a.val != b.val){
          return false;
        }
         return same(a.left, b.left) & same(a.right, b.right);
    }


    //Iterative
    static boolean sameIterative(TreeNode a, TreeNode b){


        return false;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(7);

        TreeNode rootb = new TreeNode(3);
        rootb.left = new TreeNode(2);
        rootb.right = new TreeNode(5);
        rootb.left.left = new TreeNode(1);
        rootb.left.right = new TreeNode(4);
        rootb.right.right = new TreeNode(7);
        rootb.right.left = new TreeNode(7);


        TreeNode rootc = new TreeNode(3);
        rootc.left = new TreeNode(2);
        rootc.right = new TreeNode(5);
        rootc.left.left = new TreeNode(1);
        rootc.left.right = new TreeNode(4);
        rootc.right.right = new TreeNode(7);
        rootc.right.left = new TreeNode(8);

        System.out.println(same(root, rootc));

    }
}
