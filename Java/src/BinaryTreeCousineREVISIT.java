import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeCousine {
    static TreeNode leftParent = null;
    static TreeNode rightParent = null;
    static int levelA = 0;
    static int  levelB = 0;
    //DFS
    public static boolean isCousine(TreeNode root, int a, int b) {

        helper(null, root, a, b,  0);
        if(leftParent!= null && rightParent!= null && leftParent.val != rightParent.val && levelA == levelB){
            return true;
        }
        return false;
    }

    static void helper(TreeNode parent, TreeNode node, int a, int b, int level) {
        if(node == null){
            return;
        }
        if(node.val == a){
            leftParent = parent;
            levelA = level;
            return;
        }
        if(node.val == b){
            rightParent = parent;
            levelB = level;
            return;

        }
        parent = node;
        helper(parent, node.left, a, b, level+1 );
        helper(parent, node.right, a, b,level+1 );
    }

        
    static class Pair{
        TreeNode parent;
        TreeNode node;
        public Pair(TreeNode parent, TreeNode node) {
            this.parent = parent;
            this.node = node;
        }
    }
    
    
  static boolean levelOrder(TreeNode root, int a, int b){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(null, root));
        Pair one = null;
        Pair two = null;
        while (!queue.isEmpty()) {
            int nodesAtDepth = queue.size();
            for(int i=0; i<nodesAtDepth; i++){
                Pair pair = queue.remove();
                if(pair.node.val == a || pair.node.val == b) {
                    if(one==null){
                       one = pair;
                    }else{
                       two = pair;
                    }

                    if(one != null && two != null && one.parent != two.parent){
                        return true;
                    }
                    System.out.println(pair.node.val);
                }
                if(pair.node.left!= null){
                    queue.add(new Pair(pair.node, pair.node.left));
                }
                if(pair.node.right!= null){
                    queue.add(new Pair(pair.node, pair.node.right));
                }
            }
            System.out.println(" Next Level ");
        }
        return false;
    }
    
    
    // Driver code
    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.println(isCousine(root, 5, 2));
    }
}

