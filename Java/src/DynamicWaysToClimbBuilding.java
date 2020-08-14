public class DynamicWaysToClimbBuilding {

    int ways(int totalSteps){
         if(totalSteps<= 1){
             return 1;
         }
         return ways(totalSteps-1)+ ways(totalSteps-1);
    }
    public static void main(String args[]){
        DynamicWaysToClimbBuilding steps = new DynamicWaysToClimbBuilding();
        System.out.println(steps.ways(31));
    }
}
