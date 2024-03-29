//https://leetcode.com/problems/sum-of-left-leaves/
//https://www.youtube.com/watch?v=_gnyuO2uquA
//https://www.youtube.com/watch?v=TzkfuLgpUxc
class BinaryTreeSumOfLeftLeaves{
// Todo: revisit again	
    public int sumOfLeftLeaves(TreeNode node) {
	if(node == null) {
			return 0;
		}
        
        if(node.left != null && node.left.left == null && node.left.right == null) {
		// explore right branch as well and add value from right tree left leaf
			return node.left.val + sumOfLeftLeaves(node.right);
		}
		return sumOfLeftLeaves(node.left)+sumOfLeftLeaves(node.right);
    }

// Using stack
	
	public int sumOfLeftLeaves(Node node) {
	  if(node == null) return 0;
			
	  Stack<Node> stack = new Stack<Node>();
	  stack.add(node);
	  
	  int sum = 0;
	  while(!stack.isEmpty()) {
		  Node nd = stack.pop();
		  
		  if(nd.left != null && nd.left.left == null && nd.left.right == null) {
			  sum += nd.left.key;
		  }
		  if(nd.left != null) {
			  stack.add(nd.left);
		  }
		  
		  if(nd.right != null) {
			  stack.add(nd.right);
		  }
	  }
	  return sum;
    }

// 	public int sumOfLeaves(Node root) {
		
// 		return sumHelper(root, 0);
// 	}
	
// 	private int sumHelper(Node node, int sum) {

// 		if(node == null) {
// 			return sum;
// 		}

// 		if(node.left == null) {
// 			return node.key;
// 		}
	
// 		return sumHelper(node.left, sum + node.key) + sumHelper(node.right, sum + node.key);

// 	}

	public int sumOfLeaves(Node root) {
		
		return sumHelper(root);
	}
	
	
	    private int sumHelper(Node node) {

		if(node == null) {
			return 0;
		}

		if(node.left == null && node.right== null) {
			return node.key;
		}
	
		return sumHelper(node.left) + sumHelper(node.right);

	}
  

}
