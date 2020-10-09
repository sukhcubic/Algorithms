import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BinaryFindModeREVISIT {
// https://leetcode.com/problems/find-mode-in-binary-search-tree/
    //https://www.youtube.com/watch?v=tXcJCUpVHSo
    //the most frequently occurred element
    
    //This could be all elements if all elements repeting once.

//  https://www.youtube.com/watch?v=1FJDyBSfEbo

    
 //   What is mode if every element is repeating once the result will be length of array/all elements  or highest repeating element
    
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

        if(prev != node.val ){
            prev = node.val;
            count = 0;
        }
        count++;
        if(max < count){
            max = count;
            ll.clear();
            ll.add(node.val);
        }else if(max == count){
            ll.add(node.val);
        }

       // System.out.println(node.val);
        helper(node.right, ll);

    }


    public static void main(String args[]){
        TreeNode node = new TreeNode();
        node.val = 4;
        node.left = new TreeNode(1, null, new TreeNode(2, null, null));
        node.right = new TreeNode(5, null, new TreeNode(6, null, null));

        BinaryFindModeREVISIT cc = new  BinaryFindModeREVISIT();
        System.out.println(cc.mode(node));

    }
}
