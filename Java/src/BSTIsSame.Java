
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

	  
  public static boolean isSameBST(List<Integer> a, List<Integer> b){
  
	  return helper(a,b,0);

  }
	  
  public static boolean helper(List<Integer> a, List<Integer> b, int index){
  	  if(a.length ==0 && b.length == 0){
	    return true;
	  }else if(a.length != b.length){
	    return false;
	  }else{
	  
	  }  
  }
	  
}
