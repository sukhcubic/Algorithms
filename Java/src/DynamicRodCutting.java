public class DynamicRodCutting {
//Ref: https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
//Exp: https://www.youtube.com/watch?v=RYPsOJmhwgE
//https://web.stanford.edu/class/archive/cs/cs161/cs161.1168/lecture12.pdf
//https://www.codesdope.com/course/algorithms-rod-cutting/
//http://www.cs.ust.hk/mjg_lib/Classes/COMP3711H_Fall16/lectures/IntroDP_Handout.pdf
//https://www.youtube.com/watch?v=i14P2K-lTrk&list=PLpO3gASfJEIJRnNG4q6QoHAYAATo466a_&index=10
//https://www.youtube.com/watch?v=XGeEPYFmJeA&list=PLpO3gASfJEIJRnNG4q6QoHAYAATo466a_&index=11
//https://www.youtube.com/watch?v=WL_oRZdh8M0
//https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14
   
    //price array and length of rod
    static int cutRod(int[] price, int len){
        // if length less than 0
        if (len <= 0) {
            return 0;
        }
        // set default max value to -ve infinity
        int maxVal = Integer.MIN_VALUE;

        //now calculate price for each section
        for(int i = 1; i<len; i++){
           //now find max profit of cut and remaining cut recursively
            maxVal =  Math.max(maxVal, price[i]+cutRod(price, len-i-1));
        }

        return maxVal;
    }

    public static void main(String args[]){

        int arr[] = new int[] {0, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println(cutRod(arr, size));
    }
}
