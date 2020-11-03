import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecursionBackTrackingCombinations{
//https://leetcode.com/problems/combinations/

    List<List<Integer>> output = new LinkedList();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;

        //Start element
        helper(1, new ArrayList<Integer>());

        return output;

    }

    void helper(int i, List<Integer> ll){

        if(ll.size() == k){

            System.out.println(ll);
           output.add(new ArrayList<>(ll));
        }

        for(int a = i; a<n+1; a++){
            //choose
            ll.add(a);

            //explore

            //we are incrementing in order to avoid duplicates
            helper(a+1, ll);

            //unchoose
            ll.remove(ll.size()-1);
        }
    }

//Test
//static void helper( int n , int k, List<List<Integer>> ll, String s){
//    if(s.length()==k){
//        System.out.println(s);
//       // ll.add(l);
//        return;
//    }
//    List<Integer> lll = new ArrayList<>();
//    for(int i=1; i<n+1; i++){
//
//        s += String.valueOf(i);
//        helper(n,k, ll, s);
//        s = s.substring(0, s.length()-1);
//    }
//}


//
public static void main(String arg[]){
        RecursionBackTrackingCombinations r = new RecursionBackTrackingCombinations();
        r.combine(4, 2);
}
}
