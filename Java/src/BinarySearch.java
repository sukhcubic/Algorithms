class BinarySearch{
  
  public boolean search(int num, int[] nums){
     return 
   }

  private boolean helper(int[] nums, int begin, int end, int num){
   int mid = (begin + end)/2
   if(nums[mid]== num){
     return true;
   }else if(nums[mid]> num){
     return helper(nums, mid+1, end, num )
   }else if(){
     return helper(nums, begin, mid, num )
   }else{
     return false;
   }
  }
}
