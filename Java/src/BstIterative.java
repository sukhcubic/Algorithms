import java.util.Stack;

class BstIterative{
    //Reference:
    //https://www.techiedelight.com/inorder-tree-traversal-iterative-recursive/
    //https://algorithms.tutorialhorizon.com/inorder-traversal-non-recursive-approach/
    //https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
    public void iterate(Node root){
        Stack<Node> stack = new Stack();
        Node curr = root;
        // Why this works?
        //         6
        //     4      8
        //   3    5  7  9
        while(!stack.isEmpty() || curr != null){
           // 1. first its going to push 6>4>3 on stack because curr.left != null
           // 2. now curr==null and it will go to else and curr = stack.pop which is 3 and it will print 3. 
           //3. curr = 3 and curr.left  = null now it will go to else and pop 4. curr = 4 now and will print 4 
           //4  curr = curr.right will make curr 5 and will go to if close since curr != null and push 5 on stack and curr.let is null
           //5  will go to else pop 5 and print value 
           // stack goes like this 6>4>3  6>4  6  6>5 6 8>7 8 9 
           // stack all left because the are in decreasing order from root.Stack will add then in incrermental order while right
           // elements should pop right away because they are al;ready in increasing order
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
    
    
    public void iterateV2(Node root){
        
    	Node current = root;
    	Stack<Node> stack = new Stack<Node>();

    	while(true) {
    		// Stack all left elemnts and the pop in order to set them in ascending order.
    		while(current != null) {
      		  stack.push(current);
      		  current = current.left;
    		}
    		if(stack.isEmpty()) {
    			return;
    		}

    		current = stack.pop();
    		System.out.print(current.key + "\n");
    		current = current.right;	
    		
    	}
        
    }
}
