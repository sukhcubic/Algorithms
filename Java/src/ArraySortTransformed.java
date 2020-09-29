public class ArraySortTransformed {
    //https://leetcode.com/problems/sort-transformed-array/

// Hint: Parameter A in: A * x^2 + B * x + C dictates the shape of the parabola.
// Positive A means the parabola remains concave (high-low-high), but negative A inverts the parabola to be convex (low-high-low).

    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        int left  = 0;
        int right = nums.length-1;
        for(int i = right; i>=0; i--){
            int x = (a*nums[left]*nums[left])+ (b*nums[left]) +c;
            int y =  (a*nums[right]*nums[right])+ (b*nums[right]) +c;
            if( a >= 0){
                if (x > y) {
                    result[i] = x;
                    left++;
                } else {
                    result[i] = y;
                    right--;
                }
            }else{
                if (x > y) {
                    result[i] = y;
                    right--;
                } else {
                    result[i] = x;
                    left++;
                }
            }
        }

        if(a < 0){
            left = 0;
            right = nums.length-1;

            while(left<right){
                int x  = result[left];
                result[left] = result[right];
                result[right] =x;
                left++;
                right--;
           }
        }
        return result;
    }

    public static void main(String[] args){
        int[] x = {-4,-2,2,4};
        //output [-23, -5, 7, 1]
        for (int a: sortTransformedArray(x, -1,3,5)) {
            System.out.println(a);
        }
    }
}
