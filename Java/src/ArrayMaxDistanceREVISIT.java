import java.util.ArrayList;
import java.util.List;

public class ArrayMaxDistanceREVISIT {
    //https://leetcode.com/problems/maximum-distance-in-arrays/

    public static int maxDistance(List<List<Integer>> arrays) {

        int result = 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);

        for (int i = 1; i < arrays.size(); i++) {
            //we already store init val above now first take max value of difference between end and previous min and differce between start and 
            // prev max and max of both and max of previous result and current result just calculated
            result = Math.max(result,
                    Math.max( Math.abs(arrays.get(i).get(arrays.get(i).size()-1) - min), Math.abs(max -arrays.get(i).get(0))));

            min = Math.min(min, arrays.get(i).get(0));

            max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));
            min = Math.min(min, arrays.get(i).get(0));

            max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));

        }

        return result;
    }

    public static void main(String arg[]){
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);

        List<Integer> l2 = new ArrayList<>();
        l2.add(2);

        List<List<Integer>> ll = new ArrayList<>();
        ll.add(l1);
        ll.add(l2);

        System.out.println(maxDistance(ll));
    }
}
