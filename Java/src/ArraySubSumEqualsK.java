public class ArraySubSumEqualsK {
// Problem: https://leetcode.com/problems/subarray-sum-equals-k/
    private static int sum(int[] items, int K) {
        int total = 0;
        //Brute force
        for (int i = 0; i < items.length; i++){
            int sum = 0;
            for (int j = i; j <items.length; j++){
                sum+= items[j];
                if(sum == K){
                   total = total+1;
                }
            }
        }
        return total;
    }

    //O(n)space, O(n) time
    private static int sumHashMap(int[] items, int K) {
        int total = 0, sum = 0;

        return total;
    }

    public static void main(String args[]){
       // int items[] = {5,-3,5};
       // int items[] = {1,1,1};
        int items[] = {3,2,3};
        int K = 3;
        System.out.println("Result: "+sum(items, K));
    }
}
