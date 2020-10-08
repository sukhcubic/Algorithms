import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BinaryFindModeREVISIT {
// https://leetcode.com/problems/find-mode-in-binary-search-tree/
    //the most frequently occurred element
//    For example:
//    Given BST [1,null,2,2],
//
//            1
//            \
//            2
//            /
//            2
//            return [2].

//  https://www.youtube.com/watch?v=1FJDyBSfEbo

     int[] mode(TreeNode node){
        List<Integer> in = new ArrayList<>();
        helper(node, in);
        int[] ar = new int[in.size()];
        int xx = 0;
        for (int x:in){
            System.out.println(x);
            ar[xx++] = x;
        }
        return ar;
    }

    int prev = 0, count = 0, max = 0;
    void helper(TreeNode node, List<Integer> ll){
        if(node == null){
            return;
        }
        helper(node.left, ll);

        if(prev != node.val) {
            // Meet a new value
            prev = node.val;
            count = 0;
        }
        count++;

        if(max<count){
            max = count;
            ll.clear();
            ll.add(prev);
        }else if(max == count){
            ll.add(prev);
        }

        helper(node.right, ll);

    }


    public static void main(String args[]){
        TreeNode node = new TreeNode();
        node.val = 3;
        node.left = new TreeNode(2, null, new TreeNode(2, null, null));
        node.right = new TreeNode(4, null, new TreeNode(4, null, null));

        BinaryFindModeREVISIT cc = new  BinaryFindModeREVISIT();
        System.out.println(cc.mode(node));

    }
}
