class BinaryTreeLeftTree{

      public List<BstNode> leftSubtree(BstNode root){
        List<BstNode> list  = new ArrayList<>();
        if(root == null){
            return null;
        }
        Queue<BstNode> q = new LinkedList<>();
        if(root.left != null){
         q.add(root.left);
        }

        while(!q.isEmpty()){
            int sz = q.size();
            for (int i = 0; i<sz; i++ ) {
                BstNode node = q.remove();
                list.add(node);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
        return list;
    }
}
