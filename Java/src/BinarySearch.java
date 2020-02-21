class BinarySearch{
  
  public boolean search(int num, int[] nums){
     return helper(nums, 0, nums.length(), num);
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
  
   public boolean search1(int num, int[] nums){
      
     int low = 0;
     int high = nums.length()-1;
     
     while(low <= high){
       int mid = (low+high)/2;
       
         if(nums[mid]== num){
              return true;
          }else if(nums[mid]> num){
              low = mid+1;
          }else{
              high = mid-1;
          }
      }
      return false;
   }
  
}
