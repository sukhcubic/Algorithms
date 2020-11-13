public class DynamicLongestIncreasingSubSeqREVISIT {
    //https://www.youtube.com/watch?v=odrfUCS9sQk&t=1038s Best Expplanation
    //https://www.youtube.com/watch?v=fV-TF4OvZpk&t=821s


    //o(n) space time o(n^2) or o(n+m)
    public static int lengthOfLIS(int[] nums) {
        int[] result = new int[nums.length];
        System.out.println("start ");

        int global =  0;
        for(int i =0; i<nums.length; i++){
            int max = 1;
            for(int j =0; j<i; j++){
                if(nums[j]<nums[i]){
                    //if(result[j]> max) {
                        max = Math.max(max, result[j]);

                      //  max = result[j];
                    //}
                }
            }
            result[i] = max+1;
            if(max>global){
                global = max;
            }
        }
        return global;
    }


    //o(n) space time o(n log n)




    public static void main(String arg[]){
        int[] seq = {10,9,2,5,3,7,101,18};
        //result 2,3,7,101 total 4
        System.out.println(lengthOfLIS(seq));
    }
}
