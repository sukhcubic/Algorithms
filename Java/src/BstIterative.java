import java.util.Stack;

class BstIterative{
    //Reference:
    //https://www.techiedelight.com/inorder-tree-traversal-iterative-recursive/

    public void iterate(Node root){
        Stack<Node> stack = new Stack();
        Node curr = root;
        
        while(!stack.isEmpty() || curr != null){
           
            if(curr != null){
               stack.push(root);
               curr = curr.left;
            }else{
               curr = stack.pop();
                //Print inorder traversal
               System.out.print(curr.data);
               curr = curr.right; 
            }
        }
    }
}
