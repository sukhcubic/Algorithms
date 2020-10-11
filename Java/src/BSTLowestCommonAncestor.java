public class BSTLowestCommonAncestor {
//This is different than Binary Tree
    //https://youtu.be/13m9ZCB8gjw?t=60
    //     // BST property
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


//     // BST property
//         while(root!= null){
//             int value = root.val;
//             if(value > p.val && value > q.val){
//                 root = root.left;
//             }else if(value <= p.val && value <= q.val){
//                 root = root.right; 
//             }else{
//                  return root;
//             }

//         }
//         return root;

        if(root != null && root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root != null && root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }

    }
}
