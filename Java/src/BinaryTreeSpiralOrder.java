import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTreeSpiralOrder {
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

    static void spiralOrderTraversal(TreeNode root){

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
               
                if(level%2==0) {
                    TreeNode node = queue.remove();
                    //print or add to list
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }

                }else{
                    TreeNode node = queue.removeLast();
                    //print or add to list
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }

                }
            }
            level++;
        }
    }


    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);

        spiralOrderTraversal(root);

    }

}

