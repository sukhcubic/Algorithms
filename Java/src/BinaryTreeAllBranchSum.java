import java.util.ArrayList;
import java.util.List;
//https://www.algoexpert.io/questions/Branch%20Sums
public class BinaryTreeAllBranchSum {
    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer>  list =  new ArrayList<Integer>();
        int sum = 0;
        sumHelper(root, list, sum );

        return list;
    }

    static void sumHelper(BinaryTree root, List<Integer> list, int sum ){

        if(root == null){
            return;
        }

        sum  = sum+ root.value;

        if(root.left == null && root.right ==null){
            list.add(sum);
            return;

        }

        sumHelper( root.left, list, sum );
        sumHelper( root.right, list,  sum );

    }
    
    
}
