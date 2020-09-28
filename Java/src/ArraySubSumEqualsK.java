import java.util.HashMap;
import java.util.Map;

public class ArraySubSumEqualsK {
// Problem: https://leetcode.com/problems/subarray-sum-equals-k/
    // https://www.youtube.com/watch?v=HbbYPQc-Oo4

    //O(n^2) time space O(1)
    private static int sum(int[] items, int K) {
        int total = 0;
        //Brute force
        for (int i = 0; i < items.length; i++){
            //First loop is only incrementing index, actual sunarray count is being counted by second loop.
            int sum = 0;
            for (int j = i; j <items.length; j++){
                sum+= items[j];
                if(sum == K){
                   total = total+1;
                }
            }
        }
        return total;
    }

    //O(n)space, O(n) time
    private static int sumHashMap(int[] items, int K) {
        //Idea from leetcode
//        The idea behind this approach is as follows: If the cumulative sum(represented by sum[i] for sum upto i^{th}ith index)
//        upto two indices is the same, the sum of the elements lying in between those indices is zero.
//        Extending the same thought further, if the cumulative sum upto two indices, say i and j is at a difference of
//        k i.e. if sum[i] - sum[j] = ksum[i]−sum[j]=k, the sum of elements lying between indices i and j is k.



        // The idea behind this approach is if we are seeing same element multiple times it means there is another subset exits down the road. i.e
        //{1, 1, 1, -1}; k = 2  sum = 0, count = 0 => map {0:1}, 1+1 sum = 2, count = 0 now sum -k = 0 map will check and count becomes 1, next map{0:2. 1:1, 2:1} sum = 3, 3-2 =1 seen count = 2 last
        //map{0:2. 1:1, 2:1, 3:1} sum = 2 (3-1) also (sum =K) 3-2 =1 seen count = 3
        //Finally if we see same sum more than once it means there is another subset which has same sum as K makes subset sum appearing twice or more.int items[] = {3,4,7,2,-3,1,4,2}; ie subset sum 13 (3,4,7,2,-3) so for Where k = 7 then it becomes 20
        //when 20(3,4,7,2,-3,1,4,2)  -7 (1,4,2) gives 13 again. 1,4,2 is another subset which bring backs sum to 13 again.
        int total = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < items.length; i++){
            sum += items[i];
            int x = sum -K;
            if(map.containsKey(x)){
                total += map.get(sum - K);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        for (Map.Entry entry: map.entrySet()){
            System.out.println(" Key "+ entry.getKey() + "  value " + entry.getValue());
        }
        return total;
    }

    public static void main(String args[]){
       // int items[] = {5,-3,5};
       // int items[] = {1,1,1};
        //int items[] = {3,4,7,2,-3,1,4,2};
        int items[] = {1,1,1, -1};
        int K = 2;
        System.out.println("Result: "+sumHashMap(items, K));
    }
}
