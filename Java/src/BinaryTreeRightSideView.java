//https://www.youtube.com/watch?v=jCqIr_tBLKs&t=401s
//https://leetcode.com/problems/binary-tree-right-side-view/discuss/56076/Reverse-Level-Order-Traversal-java
//https://leetcode.com/problems/binary-tree-right-side-view/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class BinaryTreeRightSideView{
// Use BFS

          class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    Node root;

    void insert(int val) {
        root = insertNode(root, val);
    };

    Node insertNode(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val > root.key) {
            root.right = insertNode(root.right, val);
        } else {
            root.left = insertNode(root.left, val);
        }
        return root;
    }
      public List<Integer> rightSideView(){
        List<Integer> items = new ArrayList<>();
        
        
        return items;
    }
      
      public static void main(String args[]) {
        BinaryTreeRightSideView bst = new BinaryTreeRightSideView();
        bst.insert(10);
        bst.insert(8);
        bst.insert(7);
        bst.insert(9);
        bst.insert(5);
        bst.insert(15);
        bst.insert(11);
        bst.insert(13);
        bst.insert(14);
        bst.insert(16);
        bst.insert(17);
        for ( int val: bst.rightSideView(bst.root)) {
            System.out.println("  rightside view " + val);
        }
    }
}
