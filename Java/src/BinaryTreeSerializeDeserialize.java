class BinaryTreeSerializeDeserialize{

  public String Serialize(Node root){
  
    if(root == null){
     return null;
    }
    
    Serialize(root.left);
    Serialize(root.right);
    
  }

  public Node Deserialize(String tree){
  
  
  }

}
