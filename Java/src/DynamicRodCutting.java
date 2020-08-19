public class DynamicRodCutting {
//Ref:https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
//Exp: https://www.youtube.com/watch?v=RYPsOJmhwgE
//https://web.stanford.edu/class/archive/cs/cs161/cs161.1168/lecture12.pdf
//https://www.codesdope.com/course/algorithms-rod-cutting/
//http://www.cs.ust.hk/mjg_lib/Classes/COMP3711H_Fall16/lectures/IntroDP_Handout.pdf
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
