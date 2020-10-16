import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryVerticalOrderTraversal {
    static Map<Integer, List<Integer>> map = new HashMap<>();
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

//TODO: Sorted order




// Not Sorted order
    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ll = new ArrayList<>();
        helper(root, 0);

        for (Map.Entry<Integer ,List<Integer> > ent :map.entrySet()){
            System.out.println("sss " + ent.getValue());
        }
        return null;
    }
    static void helper(TreeNode node, int position){
        if(node == null){
            return;
        }
        System.out.println(node.val);
         if(map.containsKey(position)){
             List<Integer>  lst = map.get(position);
             lst.add(node.val);
             map.put(position,lst);
         }else{
             List<Integer>  lst = new ArrayList<>();
             lst.add(node.val);
             map.put(position,lst);
         }
         helper(node.left, position-1);
         helper(node.right, position+1);
    }


    public static void main(String args[])
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        verticalTraversal(root);
    }
}
