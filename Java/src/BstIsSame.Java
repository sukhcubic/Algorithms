
class BstIsSame{


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

	  
  public static boolean isSameBST(List<Integer> a, List<Integer> b){
  
	  return helper(a,b,0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);

  }
	
	// Time Complexity =O(n)^2 space is O(d) d is depth of tree because we are doing recursive calls.
	  
  public static boolean helper(List<Integer> a, List<Integer> b, int rootA, int rootB, int min, int max){
	  //when no root index means we do not have any value in array to compare
	  if(rootA == -1 | rootB == -1){
		  return rootA == rootB;
	  }
	  // roots are not same
	  if(a.get[rootA] != b.get[rootB]){
		  return false;
	  }
  	  if(a.length ==0 && b.length == 0){
	    return true;
	  }else if(a.length != b.length){
	    return false;
          // if root not equal then return false		  
	  }else if (a.get(0) != b.get(0)){
	    return false;
	  }
	  
	  int left1 = getSmaller(a, rootA, min);
	  int left2 = getSmaller(b, rootB, min);
	  int right1 = getBigger(a, rootA, max);
	  int right2 = getBigger(b, rootB, max);
	  // when on left subtree min val is -infinty and max value is value of root
	  int currentVal = a.get(rootA)
	  return helper(a, b, left1, left2, min, currentVal) && helper(a, b, right1, right2, currentVal, max);
  }
	
int getSamller(List<Integer> array, int start, int min){
	
	for(int i = start; i < array.size(); i++){
		if(array.get(i).intValue() < array.get(start).intValue() && array.get(i).intValue() >= min)
			return i;
	
	}

	return -1;
}

int getBigger(List<Integer> array, int start, int max){

	for(int i = start; i < array.size(); i++){
		if(array.get(i).intValue() >= array.get(start).intValue() && array.get(i).intValue() < max)
			return i;
	
	}
       return -1;
} 
	  
}
