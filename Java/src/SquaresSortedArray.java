import java.util.Arrays;

public class SquaresSortedArray {
    //https://leetcode.com/problems/squares-of-a-sorted-array/submissions/
    //ingenious solution  https://www.youtube.com/watch?v=4eWKHLSRHPY

    //Brute
    public static int[] squared(int[] data){
        //convert -ve to +ve
        for (int i = 0; i < data.length; i++) {
            if(data[i] < 1){
              data[i] = data[i]*-1;
            }else {
                break;
            }
        }
        Arrays.sort(data);
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i]*data[i];
        }

        return data;
    }


    // Better two pointers
    public static int[] squaredBetter(int[] data){

        int[] result = new int[data.length];
        int left = 0;
        int right = data.length -1;
        for (int i = right; i >=0; i--) {
            int a =  data[left]*data[left];
            int b =  data[right]*data[right];
            if(a>b){
                result[i] = a;
                left++;
            }else {
                result[i] = b;
                right--;
            }
        }
        return result;
    }


    public static void main(String[] args){
        int[] x = {-4,-1,0,3,10};
        for (int a: squaredBetter(x)) {
            System.out.println(a);
        }
    }
}
