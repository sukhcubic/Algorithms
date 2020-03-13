class ArrayFindSmallDifference{

    public static int[] find(int[] a, int[] b){
        int[] result = new int[2];
        Arrays.sort(a);
        Arrays.sort(b);
        int curr = Integer.MAX_VALUE;
        int saved = Integer.MAX_VALUE;

        int pointA = 0;
        int pointB = 0;
        while(pointA<a.length && pointB<b.length){
            int x = a[pointA];
            int y = b[pointB];
            if(x < y){
                curr = x-y;
                pointA++;
            }else if(x> y){
                curr = x-y;
                pointB++;
            }else{
                return
            }

            if(saved < curr){
                saved
            }
        }
     return result;
    }

    public static void main(String arg []){

        int[] a = {-1,5,10,20,28,3};
        int[] b = {26,134,135,15,17};

        //-1 3 5 10 20 28
        //15 17 26 134 135
        for (int val: find(a, b)){
            System.out.println("  result = "+val);
        }
    }

}
