//https://leetcode.com/problems/binary-tree-level-order-traversal/
//Explanation
//https://www.youtube.com/watch?v=gcR28Hc2TNQ

//https://www.baeldung.com/java-depth-first-search

class BinartTreeOrderLevelTraversal{
	//BFS
	public List<List<Integer>> levelTraversal(Node root){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null){
            return list; 
        }
		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			int sz = queue.size();
			List<Integer> values = new ArrayList<Integer>();
			for(int i = 0; i< sz; i++) {  
				Node node = queue.remove();
				
				if(node != null) {
				  values.add(node.key);	
				}
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}		
			}	
			
			list.add(values);
		}
		
		return list;
	}
	
	//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
	//https://nifannn.github.io/2019/01/06/Algorithm-Notes-Leetcode-107-Binary-Tree-Level-Order-Traversal-II/
	public List<List<Integer>> levelTraversal2(Node root){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
                if(root == null){
                    return list; 
                   }
	
		
		return list;
	}
	
	public void print(List<List<Integer>> levelTraversal) {
		for(List<Integer> list: levelTraversal) {
		 for (Integer val:list) {
			System.out.print(val.intValue() +   "    ");
		  }
		 System.out.print( "\n");
		}
	}

}
