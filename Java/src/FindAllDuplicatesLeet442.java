class FindAllDuplicatesLeet442{
//https://leetcode.com/problems/find-all-duplicates-in-an-array/
//https://algorithms.tutorialhorizon.com/find-duplicates-in-an-given-array-in-on-time-and-o1-extra-space/     
      public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dups = new ArrayList<>();
        //Elements are 1 ≤ a[i] ≤ n (n = size of array) there is no zero and max element is <= array.length;
        // Approach is to visit first element and get its value and subtract -1 becuase array is zero based but 
        // values are 1<= n <= N. Grabbed value become index and we will change it to -ve value . This means we already
        // visited. Next time if it sees if value is less than zero (-ve) that mease we have duplicate because we already 
        // visited there.
        for(int i = 0; i < nums.length; i++){
            int x = Math.abs(nums[i])-1;
            if(nums[x] <0){
                // Adding orignal restored value;
                dups.add(x+1);
            }else{
                 nums[x] = -nums[x];
            }
        }
      return dups;
    }
      
      //https://medium.com/solvingalgo/solving-algorithmic-problems-find-a-duplicate-in-an-array-3d9edad5ad41
      //https://www.geeksforgeeks.org/find-duplicates-constant-array-elements-0-n-1-o1-space/
   //Todo: Implement two pointer solution:
      
}
