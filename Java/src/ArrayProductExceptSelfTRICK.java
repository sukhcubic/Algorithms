public class ArrayProductExceptSelf {
   // https://leetcode.com/problems/product-of-array-except-self/solution/
    //https://www.youtube.com/watch?v=khTiTSZ5QZY

    public static  int[] productExceptSelf(int[] nums) {

        int [] result = new int[nums.length];

        result[0] = 1;
        for(int i = 1; i< nums.length; i++ ){
            result[i] = nums[i-1] *result[i-1];
        }

        //output = [1,1,2,6]

        //Took one because we will be using in reverse order and last element already have cumulative product calculated.
        int x = 1;

        for(int i = nums.length-1 ; i >=0; i-- ){
            result[i] = result[i] * x;
            // This is cumulative product from right to left except current element. This will be used in next iteration
            x = x * nums[i];
        }

        return result;
    }

    public static void main(String[] args){
        int[] x = {1,2,3,4};
        for (int a: productExceptSelf(x)) {
            System.out.println(a);
        }
    }
}
