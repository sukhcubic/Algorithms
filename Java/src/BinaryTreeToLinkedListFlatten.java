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


}
