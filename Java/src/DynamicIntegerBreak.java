
import java.util.HashMap;
import java.util.Map;

public class DynamicIntegerBreak {
    //https://leetcode.com/problems/integer-break/
    //Hint: Unbounded knapack

//    Given a positive integer n, break it into the sum of at least two positive
//    integers and maximize the product of those integers. Return the maximum product you can get.
//    Example 1:
//    Input: 2
//    Output: 1
//    Explanation: 2 = 1 + 1, 1 × 1 = 1.

//    Example 2:
//    Input: 10
//    Output: 36
//    Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

    static Map<Integer, Integer> cache = new HashMap<>();
    
    
//ToDo:
    static int maxProduct(int len){
        // if length less than 0
        if (len <= 0) {
            return 0;
        }
        if(cache.containsKey(len)){
            return cache.get(len);
        }
        // set default max value to -ve infinity
        int maxVal = Integer.MIN_VALUE;

        //now calculate price for each section
        for(int i = 1; i<=len; i++){
            //now find max profit of cut and remaining cut recursively
            System.out.println(maxVal);

            maxVal =  Math.max(maxVal, i*maxProduct(len-i));
        }

        cache.put(len, maxVal);
        return maxVal;
    }

    public static void main(String args[]){
        int num = 10;
        System.out.println(maxProduct(num));
    }

}

