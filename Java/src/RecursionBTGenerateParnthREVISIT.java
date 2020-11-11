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

    int len;
    public List<String> generateParenthesis(int n) {

        this.len = n;
        List<String> list = new ArrayList<>();
        String a = "(";
        String b = ")";
        helper(list, a, b, "");
        return list;
    }

    void helper(List<String> list, String a, String b, String result){

        if(result.length() == 2*len){
            list.add(result);
            return;
        }
        //choose
        

        //explore

        //unchoose

    }

    public static void main(){
        RecursionBTGenerateParnthREVISIT generate = new RecursionBTGenerateParnthREVISIT();

        for (String s:
                generate.generateParenthesis(3)) {
            System.out.println(s);
        }
    }
}
