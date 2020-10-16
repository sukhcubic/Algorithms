import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryNaryTreeLevelOrder {
//https://leetcode.com/problems/n-ary-tree-level-order-traversal/

            //fetch all element of same order then move on.

    List<Integer> list = new ArrayList<>();
    static Queue<TreeNode> queue = new ArrayDeque<>();

   // public static void tree(TreeNode node){
   ///     if(node != null) {
   //         queue.add(node);
   //     }
   //     while(!queue.isEmpty()){
   //         TreeNode nd = queue.remove();
   //         System.out.println(nd.val);
   //         if (nd.left!= null){
  //              queue.add(nd.left);
   //         }
   //         if(nd.right != null){
   //             queue.add(nd.right);
   //         }
   //     }
  //  }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            //fetch all element of same order
            int sz = queue.size();
            for(int i = 0; i < sz; i++){
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);

            }

            result.add(level);

        }

        return result;
    }

    public static void main(String args[])
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        tree(root);
    }
}
