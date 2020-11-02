public class RecusionBacktrackingSudokuREVISIT {
//
// Sol: https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/SudokuSolver/SudokuSolver.java
    static void solveSudoku(String[][] board){

        solve(board, 0, 0);

    }

    static boolean solve(String[][] board, int row, int col){

        if (col == board[row].length) {
            col = 0;
            row++;
        }

        if (row == board.length) {
            return true;
        }
        //skip to next col if col arlready contains val
        if(!board[row][col].equals(".")){
            return solve(board, row, col+1);
        }

        for(int i=1; i < 10; i++){
            if(isValid(board, row, col, i)){
                //choose
                board[row][col] = String.valueOf(i);
                //explore
                if(solve(board, row, col)){
                    return true;
                }
                //unchoose
                board[row][col] = ".";
            }
        }
        return false;
    }

    static boolean isValid(String[][] board, int row, int col, int val){
        for (int i=0; i<9; i++) {
             if(board[row][i].equals(String.valueOf(val))) return false;
             if(board[i][col].equals(String.valueOf(val))) return false;
             if(board[3*(row/3) + i/3][3*(col/3) + i%3].equals(String.valueOf(val))) return false;
         }
        return true;
    }

    public static void main(String arg[]){
        String[][]  board = {
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}
         };

          solveSudoku(board);

          for (int i=0; i<board.length; i++){
              for (int j=0; j<board[i].length; j++){
                  System.out.println( board[i][j]+" ");
              }
          }

        }
}
