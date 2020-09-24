public class ArrayMaxSubsetSumCircularArray {
    //https://leetcode.com/problems/maximum-sum-circular-subarray/
    //https://www.youtube.com/watch?v=Q1TYVUEr-wY
    //https://www.youtube.com/watch?v=os4B7MlHAbs
    //https://www.youtube.com/watch?v=CGFohM-BkWM

    private static int sum(int[] items) {


//TODO:
        int running = 0;
        int totalSum = 0;
        int size = items.length;

        for(int i =0; i<=size; i++){
          //  System.out.println(running);

            if(i<size-1) {
                if(items[i]<1){
                    running = 0;
                }
               // System.out.println(running);

                running = Math.max(running + items[i], items[i]);
            }else{
                if(items[0]<1){
                    running = 0;
                }
               // System.out.println(running);
                running = Math.max(running + items[0], items[0]);
            }
            totalSum = Math.max(running, totalSum);
        }
        return totalSum;

    }

    public static void main(String args[]){
        int items[] = {1,-2,3,-2};
        System.out.println(sum(items));
    }

}
