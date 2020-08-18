public class DynamicRodCutting {
//Ref:https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
    static int cutRod(int[] price, int len){
        if (len <= 0)
            return 0;
        int maxVal = Integer.MIN_VALUE;
        return maxVal;
    }
    
    public static void main(String args[]){

        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println(cutRod(arr, size));
    }
}
