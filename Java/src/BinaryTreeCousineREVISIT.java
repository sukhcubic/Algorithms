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

    
    
    //BFS
    static boolean levelOrder(TreeNode root, int a, int b){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int size = 0;
        int leftLevel = 0;
        TreeNode leftParent = null;
        TreeNode parent = null;
        while (!queue.isEmpty()) {
            int nodesAtDepth = queue.size();
            for(int i=0; i<nodesAtDepth; i++){
                TreeNode node = queue.remove();
                System.out.println(node.val);
                if(node.left!= null){
                    queue.add(node.left);
                }
                if(node.right!= null){
                    queue.add(node.right);
                }
            }
            System.out.println(" Next Level /n");
//            if(size<1){
//              level++;
//              size= queue.size();
//            }
//
//            if(leftLevel > 0 && level > leftLevel){
//                return false;
//            }else if(leftLevel > 0 &&  leftLevel == level && leftParent != null && leftParent.val != parent.val ){
//                return true;
//            }
//            if(leftParent == null && (node.val==a || node.val==b)){
//                leftParent = node;
//                leftLevel = level;
//            }
//            parent = node;
//
//            if(node!= null){
//                queue.add(node.left);
//                queue.add(node.right);
//            }
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

