class BinaryTreeToLinkedListFlatten{
  //https://www.programcreek.com/2013/01/leetcode-flatten-binary-tree-to-linked-list/
  //http://www.crazyforcode.com/flatten-binary-tree-linked-list-in-place/
  //DFS
    public LinkedList<Node> createLevelLinkedList2(Node node){
        LinkedList<Node> list = new LinkedList<>();
        if(node != null){
            Stack<Node> stack = new Stack<>();
            stack.push(node);
            list.add(node);
            Node current = node;
            while (true){
                while(current.left != null){
                    stack.push(current);
                    list.add(current);
                    current = current.left;

                }
                current = stack.pop();
                current = current.right;
            }
        }
        return list;
    }

  
  //Another approach from LeetCode
  //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/solution/
  //recursive approach
   public void flatten(TreeNode root) {
        flattenTree(root);
    }
    
       private TreeNode flattenTree(TreeNode node) {
        
        if (node == null) {
            return null;
        }
 
        if (node.left == null && node.right == null) {
            return node;
        }
        
        TreeNode leftTail = this.flattenTree(node.left);
        
        TreeNode rightTail = this.flattenTree(node.right);
        
        if(node.left != null){
           leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
            
        }
         //Return the rightmost we are adjusting right.
        return   rightTail == null ? leftTail:rightTail;
    }

//Iterative Approach
 // https://afteracademy.com/blog/flatten-binary-tree-to-linked-list
  public void flatten(Node root){
  
    if(root == null){
      return null;
    } 
     //.            1                    1                     1                         1
    //           2.   5        =>     2            =>      x.     2        =>           x  2
    //.        3.  4.    6          3.  4                        3   4                    x  3
    //                                    5                            5                       4
    //                                      6                            6                       5
    //                                                                                             6
    
   
    
    Node curr = root;                                                                              
    while(curr != null){
      //If left is not null and right is null then swith node and set left null
      if(curr.left != null){
        // if right != null set temp node pointing left and get rightmost end and point current node's right to th end/
        // now eveything shifted to the left then move curret.feft to current .right. Shift everything to right and set current.
        // left to null. Loop will run untill everynode is in one line on right side.
        if(curr.right != null){
          Node nd = curr.left;
          while(nd.right != null){
             nd = nd.right;
          }
          nd.right = curr.right;
        }
        curr.right = curr.left;
        curr.left = null;
      }
      curr = curr.right;
    }
  }  
}
