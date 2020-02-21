class BinaryTreeSerializeDeserialize{

    StringBuilder sb = new StringBuilder();
    public String serialize(Node root){
         if(root == null){
             return null;
         }
         serialize(root.left);
         serialize(root.right);
         sb.append(root.key + ",");
         return sb.toString();
    }

  public Node Deserialize(String tree){
  
  
  }

}
