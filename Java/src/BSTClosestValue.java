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

    private int lastCloset;

    public int findClosest( Node tree, int target) {

       // lastCloset = tree.key;

        if(tree == null){
            return -1;
        }
        
        if(tree.key == target){
            return tree.key;
        }else if(tree.key > target){
            return findClosest(tree.left, target);
        }else if(tree.key < target){
            return findClosest(tree.right, target);
        }else{

        }

        return -1;
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
