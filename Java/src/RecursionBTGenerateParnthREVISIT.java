import java.util.ArrayList;
import java.util.List;

public class RecursionBTGenerateParnthREVISIT {
//    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//    Example 1:
//    Input: n = 3
//    Output: ["((()))","(()())","(())()","()(())","()()()"]
//
//    Example 2:
//    Input: n = 1
//    Output: ["()"]


    // Explanation : https://www.youtube.com/watch?v=sz1qaKt0KGQ
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, n, n, "", n);
        return list;
    }

    void helper(List<String> list, int open, int close, String result, int max){

        if(result.length() == 2*max){
            list.add(result);
            return;
        }
        //choose
        if(open > 0) {
            helper(list, open - 1, close, result + "(", max);
        }
        if(close > open ){
            helper(list, open, close-1, result+")", max);
        }

    }

    public static void main(String arg[]){
        RecursionBTGenerateParnthREVISIT generate = new RecursionBTGenerateParnthREVISIT();

        for (String s:
                generate.generateParenthesis(3)) {
            System.out.println(s);
        }
    }
}
