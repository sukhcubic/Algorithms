class ArrayFindSmallDifference{

    public static int[] find(int[] a, int[] b){
        int[] result = new int[2];
        Arrays.sort(a);
        Arrays.sort(b);
     return result;
    }

    public static void main(String arg []){

        int[] a = {-1,5,10,20,28,3};
        int[] b = {26,134,135,15,17};

        for (int val: find(a, b)){
            System.out.println("  result = "+val);
        }
    }

}
