//https://www.youtube.com/watch?v=UcOxGmj45AA
//https://leetcode.com/problems/delete-node-in-a-bst/solution/
//https://makeinjava.com/delete-remove-node-binary-search-tree-bst-java-dfs-example/
public class BinarySearchTree {

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


 
    int floor(Node x, int value){
        if (x == null) {
            return -1;
        }

        if(x.key == value) {
            return x.key;
        }

        if(x.key > value){
            System.out.println( " aa  " + x.key);
            return floor(x.right, value);
        };

        System.out.println("  bbb "+ x.key);
        int flr = floor(x.left, value);
        System.out.println("  ccc  "+ flr);
        return (flr <= value) ? flr: x.key;
    }


    int ceiling(Node x, int value){
        if (x == null) {
            return -1;
        }

        if(x.key == value) {
            return x.key;
        }
        
        if(x.key < value) {
        	return ceiling(x.right, value);
        }
        
        int ceil = ceiling(x.left, value);
        
        return (ceil >= value) ? ceil: x.key;
    }
    
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

    void printAll(Node root) {
        if (root != null) {
            printAll(root.left);
            System.out.println(root.key);
            printAll(root.right);
        }
    }

    boolean find(Node root, int val) {
        if (root != null) {
            if (root.key == val) {
                return true;
            } else if (val > root.key) {
                find(root.right, val);
            } else {
                find(root.left, val);
            }
        }
        return false;
    }
    

//     Node delete(Node root, int val) {
//     	if(root == null) {
//     		return root;
//     	}
//     	int value = root.key;
    	
//     	if(val > value) {
//     		return delete(root.right, val);		
//     	}else if(val < value){
//     		return delete(root.left, val);
//     	}else {
//     		if(root.left == null && root.right == null) {
//     			return null;
//     		}
    		
//     		if(root.left == null) {
//     			return root.right;
//     		}else if(root.right == null) {
//     			return root.left;
//     		}else {
//     			Node min = findMin(root.right);
//     			root.key = min.key;
//     			root.right = delete(root.right, min.key);
//     		}
//     	}
// 	return root;
//       }
	
	
    Node delete(Node root, int value){
    
	    if(root == null){
	      return null;
	    }
	    
	    if(root.value < value ){
		root.right = delete(root.right, value);    
	    }else if(root.value > value){
	        root.left = delete(root.left, value);
	    }else{
	        if(root.left!= null){
			root = root.left;
		}else if(root.right != null){
		        root = root.right;     
		}else if(root.left != null && root.right != null){
			root.value = getMin(root.right);
			root.right = delete(root.right, root.value);
		}else{
		        root = null; 
		} 
	    }
    
	    return root;
    }
	
	
    Node findMin(Node node){
        if(node.left == null) return node;
        return findMin(node.left);
    }
    
    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(6);
        bst.insert(5);
        bst.insert(2);
        bst.insert(3);
        bst.insert(11);
        bst.insert(20);
        //bst.printAll(bst.root);
        //System.out.print(bst.find(bst.root, 5));
        //System.out.print(bst.floor(bst.root, 15));
        //System.out.print(bst.ceiling(bst.root, 15));
        System.out.print(bst.delete(bst.root, 15));
    }
}
