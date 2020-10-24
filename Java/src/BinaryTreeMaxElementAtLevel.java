import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeMaxElementAtLevel {
//Find Max value at each level
    static List<Integer> levelOrder(TreeNode root){
        List<Integer> ints = new ArrayList<>();
        if(root==null){
            return ints;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int val = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode node = queue.remove();
                val = Math.max(val, node.val);

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right!= null){
                    queue.add(node.right);
                }
            }
            ints.add(val) ;
        }

        return ints;

    }
    // Driver code
    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);


        for (int val:levelOrder(root)
             ) {
            System.out.println(val);

        }
    }
}
