public class ArrayMaxProfit {
    void maxProfit(int[] a){
        int buy = Integer.MAX_VALUE;;
        int sell = 0;
        int profit = 0;
        for(int i = 0; i<a.length; i++){

            // set min value
            if(a[i]<buy){
                buy = a[i];
            //set max value or if difference/profit is bigger than previous profit set max value
            }else if(a[i]-buy > profit){
                sell = a[i];
                profit = a[i]-buy;
            }
        }
        System.out.println( "Buy at : " + buy);
        System.out.println( "Sell at : " + sell);
    }

    public static void main(String args[]){
        //Array index represent time
        //Price at:9am 10am  11am  12pm  1pm  2pm  3pm
        int[] a=  { 10,  9,   8,   11,   9,   17,  12 };
        ArrayMaxProfit profit = new ArrayMaxProfit();
        profit.maxProfit(a);
    }
}
