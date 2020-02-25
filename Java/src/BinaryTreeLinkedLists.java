import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLinkedLists {
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

    public List<LinkedList<Node>> createLevelLinkedList(Node root){
        List<LinkedList<Node>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        LinkedList<Node> ll = new LinkedList<>();
        ll.add(root);
        while(ll.size() > 0){
            LinkedList<Node> newList = ll;
            ll = new LinkedList<>();
            for(Node node:newList){
                if(node.left != null){
                    ll.add(node.left);
                }
                if(node.right != null){
                    ll.add(node.right);
                }
            }
            list.add(newList);
        }
        return list;
    }

    public static void main(String args[]) {
        BinaryTreeLinkedLists bst = new BinaryTreeLinkedLists();
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


        for (LinkedList<Node> ll: bst.createLevelLinkedList(bst.root)){
            for (Node n:ll) {
                System.out.println( "  n  " + n.key);
            }

            System.out.println( "  n  dddd" );

        }
    }
}
