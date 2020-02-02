
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
     inorder(tree.right, list);
    return list;
  }
  
  public List<int> preOrder(BST tree, List<int> list){
  
    return null;
  }
  
  public List<int> postOrder(BST tree, List<int> list){
  
    return null;
  }
  
  public static void main(String arg[]){
    BstTraversal bst = new BstTraversal();
    
  
  }
  
}
