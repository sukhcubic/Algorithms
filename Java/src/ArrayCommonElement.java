import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/

public class ArrayCommonElements {
    
    //Basic solution with HashMap
    List<Integer> find(int[]a, int[]b){
        List<Integer> elements = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i<a.length; i++){
            map.put(a[i], 1);
        }

        for (int i = 0; i<b.length; i++){
            if(map.containsKey(b[i])) {
                map.put(b[i], 2);
            }
        }
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {

            if(entry.getValue()>1){
                elements.add(entry.getKey());
            }
        }
        return elements;
    }
    
    //Optimal Solution
        public void findNums(int[]a, int[]b){
        int i = 0;
        int j = 0;
        int a1 = a.length;
        int b1 = b.length;

        while(i<a1 && j<b1){
           if(a[i]== b[j]){
               System.out.println(a[i]);
           }
           if(a[i]>b[j]){
               j++;
           }else {
               i++;
           }
        }
    }
    public static void main(String args[]){
        ArrayCommonElements commonElements = new ArrayCommonElements();

        int[] a = {1,2,3,5,6,7,9, 11, 12};
        int[] b = {1,4,8,9,10,11,12, 13, 14};
        for (int val :commonElements.find(a,b)) {
           // System.out.print(val + "\n");
        }

        commonElements.findNums(a,b);
    }
}
