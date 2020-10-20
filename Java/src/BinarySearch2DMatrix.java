public class BinarySearch2DMatrixTIP {
    //https://leetcode.com/problems/search-a-2d-matrix-ii/
    //https://www.youtube.com/watch?v=Ohke9-qwAKU
     static boolean find(int[][] data, int target){
         if(data  == null|| data.length==0 || data[0].length==0){
             return false;
         }
         int row = 0;
         int col = data[0].length-1;

         while (row < data.length && col >=0){
             if(data[row][col]== target){
                 return true;
                 //Last Iteration
                 //Found it
                 //                 {2,   5},
                 //                 {3,   6},
                 //                 {10, 13},
                 //                 {18, 21}



                 //we started from last colomn. If column is greater that target, since matrix is sorted, all the values down below
                 // will be larger.So eliminate last column
                 //15>5
             }else if(data[row][col]>target){
                 //First Iteration
                 //                 {1,   4,  7, 11},
                 //                 {2,   5,  8, 12},
                 //                 {3,   6,  9, 16},
                 //                 {10, 13, 14, 17},
                 //                 {18, 21, 23, 26}

                 //Second Iteration
                 //                 {1,   4,  7},
                 //                 {2,   5,  8},
                 //                 {3,   6,  9},
                 //                 {10, 13, 14},
                 //                 {18, 21, 23}

                 //Third Iteration
                 //                 {1,   4},
                 //                 {2,   5},
                 //                 {3,   6},
                 //                 {10, 13},
                 //                 {18, 21}
                 col--;
             }else{
                 //Fourth Iteration
                 //                 {2,   5},
                 //                 {3,   6},
                 //                 {10, 13},
                 //                 {18, 21}


                 //Else eliminate row. In this section it is in else condition. Let say we are looking for 12. First iteration will check
                 // last col first row i.e 15 which is 15>12 then col--. Now Next iteration it will check 11(since we already eliminated
                 // last col) 11<12 it will increase row(or first will be eliminated)

                 //Second example, we are looking for 5. Three cols will be eliminated then will find 4<5 row will be ++
                 //Now we have               {2,   5}, Left this will find us value
                 //                          {3,   6},
                 //                          {10, 13},
                 //                          {18, 21}

                 row++;
             }
         }
         return false;
     }

    public static void main(String arg[]){
         //int matrix[][] = {{}, {}};

         //int matrix[][] = {};


         int[][] matrix = {
                          {1,   4,  7, 11, 15},
                          {2,   5,  8, 12, 19},
                          {3,   6,  9, 16, 22},
                          {10, 13, 14, 17, 24},
                          {18, 21, 23, 26, 30}
                         };

         int target = 7;

        System.out.println(find(matrix, target));
    }
}

