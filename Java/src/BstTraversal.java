
class BstTraveral{
   class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
  
  public List<int> inOrder(BST tree, List<int> list){
  
     if(tree.left != null){
        inOrder(tree.left, list);urn list
     }
     list.add(tree.value);
     if(tree.right != null){
        inorder(tree.right, list);
     }
    return list;
  }
  
  public List<int> preOrder(BST tree, List<int> list){
     list.add(tree.value);
     if(tree.left != null){
        preOrder(tree.left, list);urn list
     }
     if(tree.right != null){
        preOrder(tree.right, list);
     }
    return list;
  }
  
  public List<int> postOrder(BST tree, List<int> list){
  
     if(tree.left != null){
        postOrder(tree.left, list);urn list
     }
     if(tree.right != null){
        postOrder(tree.right, list);
     }
     list.add(tree.value);

    return list;
  }
  
  public static void main(String arg[]){
    BstTraversal bst = new BstTraversal();
    
  
  }
  
}
