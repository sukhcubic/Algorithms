public class DynamicMinCoin {
    //https://leetcode.com/problems/coin-change
    static int countx = Integer.MAX_VALUE;

    private static int min(int[] items, int sum) {
        if(sum < 0){
            countx = -1;
        }
         min(items, sum, 0, 0);
         return countx;
    }
//  O(2^n)
    static void min(int[] items, int sum, int index, int count){
        if (sum == 0){
            countx = Math.min(countx, count);
        }
        if(index < items.length && sum>=0) {
            min(items, sum - items[index], index, count +1);// including same coin over
            min(items, sum, index + 1, count );// not including
        }
    }

    public static void main(String args[]){
        int items[] = { 1, 5, 10};
        int sum = -1;

        System.out.println(min(items, sum));
    }
}
