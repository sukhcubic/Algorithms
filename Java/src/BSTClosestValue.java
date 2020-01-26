// https://www.algoexpert.io/questions/Find%20Closest%20Value%20In%20BST
//Find closest value assum ehere will be only one closest value.
class BSTClosestValue{
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
//    private int findClosest(Node tree, int target) {
//        return helper(tree, target, -1);
//    }
//    
//    private int helper(Node tree, int target, int prev) {
//        if(tree == null){
//            return -1;
//        }
//        int diff = Math.abs(target-tree.key); 
//        
//        if(prev > -1 && prev>diff) {
//        	return prev;
//        }
//        
//        if(tree.key == target){
//            return tree.key;
//        }else if(tree.key > target){
//            return helper(tree.left, target, diff);
//        }else if(tree.key < target){
//            return helper(tree.right, target, diff);
//        }
//    	
//    	return -1;	
//    }

    private int findClosest(Node tree, int target) {

        return helper(tree, target, Double.MAX_VALUE);
     }
    
    private int helper(Node tree, int target, double prev) {
    
        if(tree == null){
            return (int) prev;
        }
        if(Math.abs(target - prev)>Math.abs(target - tree.key)){
        	prev = tree.key;
        }
        
        if(tree.key > target) {
            return helper(tree.left, target, prev);
        }else if(tree.key < target){
            return helper(tree.right, target, prev);
        }else {
        	return (int) prev;	
        }
    	
    }

    public static void main(String args[]) {
        BSTClosestValue bst = new BSTClosestValue();
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
        System.out.print(bst.findClosest(bst.root, 5));
    }
}
