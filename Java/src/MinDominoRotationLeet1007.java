class MinDominoRotationLeet1007{

  public int rotate(int[] a, int[] b){
  
    // This solution acceoted but failed in submission:
    // [1,2,1,1,1,2,2,2]
    // [2,1,2,2,2,2,2,2]
//      if(A[0]!= B[1] && A[1]!=B[0]){
//             return -1;
//         }
        
//         if(A[0] == B[1]){
//             int a = A[0];
//             int swaps = 0;
//             for(int i= 1; i<A.length; i++ ){
//                 if(A[i]== a){
//                   continue;  
//                 }
//                if(B[i] == a) {
//                    int temp = A[i];
//                    A[i] = B[i];
//                    B[i] = temp;
//                    swaps++;
//                }else{
//                    swaps = -1;
//                    break;
//                }
//             }
//             return swaps;
//         }else{
//             int a = B[0];
//             int swaps = 0;
//             for(int i= 1; i<B.length; i++ ){
//                 if(B[i]== a){
//                   continue;  
//                 }
//                if(A[i] == a) {
//                    int temp = A[i];
//                    A[i] = B[i];
//                    B[i] = temp;
//                    swaps++;
//                }else{
//                    swaps = -1;
//                    break;
//                }
//             }
//             return swaps; 
//         }
//   }

}
