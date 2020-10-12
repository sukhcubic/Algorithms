import java.util.ArrayList;
import java.util.List;

public class BinaryUniqueTreesREVISIT {
//TODO:
  //  https://leetcode.com/problems/unique-binary-search-trees/
// https://www.youtube.com/watch?v=0s20L4-chDA
    static int i = 0;

    static int trees(int num){
         if(num < 2){
             return 1;
         }
         i++;
         return trees(i-1) *trees(num-i)
                 + trees(i-1) *trees(num-i);
      }
       public static void main(String arg[]){
         trees(4);
       }

}
