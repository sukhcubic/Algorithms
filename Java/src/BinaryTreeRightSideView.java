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
          
      public List<Integer> rightSideView(Node root){
        List<Integer> items = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
         // After creating queue add root and run while queue not empty
        queue.add(root);
           while(!queue.isEmpty()){
             //Store queue size;
             int size = queue.size();
             //run and remove all existing elemets in queue. Note we are also adding elements>those will not remove because 
             // it will only remove what ever stored intially ( int size = queue.size()). Rmaining will remove in next iteration
             // of while loop
             for(int x =0; x<size; x++){
              Node node = queue.remove();
              if(x == size-1){
                 items.add(node.key);
              } 
              // We are adding left and right of right subtree and left sub tree. 
              //        4           
              //      3   5             => 4 as root => remove 4 => 3-5 in queue next iteration 3 will be removed and 2 will added 4. 5 will remove and 6 will add. Iteration is going horizontally.
              //    2       6
                if(node.left != null){
                queue.add(noed.left);
              }     
              if(node.right != null){
                queue.add(node.right);
              }            
             
             }        
           
           }
        
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
