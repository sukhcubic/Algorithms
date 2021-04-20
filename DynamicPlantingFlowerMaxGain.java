public class DynamicPlantingFlowerMaxGain {
//https://www.linkedin.com/learning/fundamentals-of-dynamic-programming/solving-the-flowerbox-problem-in-python?u=2092908
    public static void main(String args[]){
        int items[] = {2,7,9,6,1};
        //out 12
        System.out.println(gain(items));
    }

    private static int gain(int[] items) {
        int a = 2;
        int b = 7;
        int value = 0;
        for(int i = 2; i< items.length; i++){
           value = Math.max(items[i]+a, b );
           a = b;
           b=value;
        }
        return value;
    }
}
