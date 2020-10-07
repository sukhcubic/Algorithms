public class MathPowerREVIST {
    //https://leetcode.com/problems/powx-n/submissions/
//     public double myPow(double x, int n) {

//         int N = n;
//         if (N < 0) {
//             x = 1 / x;
//             N = -N;
//         }
//         if(N == 0){
//             return 1;
//         }

//         if(N ==1){
//             return x;
//         }

//         return x * myPow( x,  N -1);
//     }

        private double fastPow(double x, long n) {
            if (n == 0) {
                return 1.0;
            }
            double half = fastPow(x, n / 2);
            if (n % 2 == 0) {
                return half * half;
            } else {
                return half * half * x;
            }
        }
        public double myPow(double x, int n) {
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }

            return fastPow(x, N);
        }

//    public double myPow(double x, int n) {
//
//        int N = n;
//        if (N < 0) {
//            x = 1 / x;
//            N = -N;
//        }
//        if(N == 0){
//            return 1;
//        }
//
//        if(N ==1){
//            return x;
//        }
//
//        double xx = 1;
//        for(int y = 1; y<=N; y++){
//            xx = xx*x;
//        }
//
//        return xx;
//    }
}
