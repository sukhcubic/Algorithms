public class DynamicSubsetDifferenceCount {
   // https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
   // count no. of subsets whose diff is 3
    private static int countDiffSubsets(int[] items, int diff) {
        return 0;
    }
    //There is a  mathematics trick to this problem. This is similar to subset sum but with math equation.
    //Given is array and diff
    //Find     s1(subset1) - s2(subset2) = diff // this is what we need
    //We have  s1(subset1) + s2(subset2) = sT(array sum)
    // gives   2*s1 = diff+sT
    //         s1 = (diff+st)/2 => (3+7)/2 = 5
    // we have to find subset sum total = 5 and count will solve our original problem.
    

    public static void main(String args[]) {
        int items[] = {1, 1, 2, 3};
        int diff = 3;

        System.out.println(countDiffSubsets(items, diff));
    }
}
