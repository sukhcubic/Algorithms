import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Basic solution with HashMap
public class ArrayCommonElements {
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

    public static void main(String args[]){
        ArrayCommonElements commonElements = new ArrayCommonElements();

        int[] a = {1,2,3,5,6,7,9};
        int[] b = {1,4,8,9,10,11,12};
        for (int val :commonElements.find(a,b)) {
            System.out.print(val + "\n");
        }
    }
}
