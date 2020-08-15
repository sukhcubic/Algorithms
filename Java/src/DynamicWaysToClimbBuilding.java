//Explanation: https://www.youtube.com/watch?v=sF7hzgUW5uY&t=5s
public class DynamicWaysToClimbBuilding {

    int ways(int totalSteps){
         if(totalSteps<= 1){
             return 1;
         }
        // How many ways i can reach at top. 1 step or 2 steps have totalSteps-1 or totalSteps-2 ways to climb to last step
         return ways(totalSteps-1)+ ways(totalSteps-2);
    }
    
    public static void main(String args[]){
        DynamicWaysToClimbBuilding steps = new DynamicWaysToClimbBuilding();
        System.out.println(steps.ways(31));
    }
}
