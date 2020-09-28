import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayMaxSubsetSumCircularArray {
    //https://leetcode.com/problems/maximum-sum-circular-subarray/
    //https://www.youtube.com/watch?v=Q1TYVUEr-wY
    //https://www.youtube.com/watch?v=os4B7MlHAbs
    //https://www.youtube.com/watch?v=CGFohM-BkWM
    // Best Explanation: https://www.youtube.com/watch?v=s1CYAnJwf50
    // Code: https://pastebin.com/xPtQRqWD

    private static int sum(int[] items) {
        int max = 0;
        int totalSum = 0;
        int min = 0; int globalSum = Integer.MIN_VALUE ; int globalMin = Integer.MAX_VALUE;
        for(int i =0; i<items.length; i++){
            totalSum += items[i];
            max = Math.max(max + items[i], items[i]);
            globalSum = Math.max(globalSum, max);
            min = Math.min(min+ items[i], items[i]);
            globalMin = Math.min(min, globalMin);
        }
        return globalSum < 0 ? globalSum:Math.max(globalSum, totalSum-globalMin);
    }

    public static void main(String args[]){
        int items[] = {5,-3,5};
        System.out.println("Result: "+sum(items));
    }
}

