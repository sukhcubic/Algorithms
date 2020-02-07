
class BSTIsSame{


  public static boolean isSameBst(BST node1, BST node2){
    
   		if((node1==null)&&(node2==null)){
        return true;
      }else if((noe1!=null && node2==null)||(node1==null && node2!=null)){
			  return false;
		  }else if(node1.data==node2.data){
        return isSameBst(node1.left, node2.left) && isSameBst(node1.right, node2.right);
      }else{
       return false;
      }

}
