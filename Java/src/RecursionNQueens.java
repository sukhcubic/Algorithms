class RecursionNQueens{
// Explanation https://www.youtube.com/watch?v=xFv_Hl4B83A

//Explanation	https://www.bilibili.com/video/av21619854?p=12   starting at 14:00

  int N = 4;

  public static void main(String[] args) {
  RecursionNQueens nq = new RecursionNQueens();
    nq.find();
  }
  
  private boolean isValid(int board[][], int row, int col) {
	  
	  int i, j; 
	  
      /* Check this row on left side */
      for (i = 0; i < col; i++) 
          if (board[row][i] == 1) 
              return false; 

      /* Check upper diagonal on left side */
      for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
          if (board[i][j] == 1) 
              return false; 

      /* Check lower diagonal on left side */
      for (i = row, j = col; j >= 0 && i < N; i++, j--) 
          if (board[i][j] == 1) 
              return false; 

      return true;
  }




  
  void printSolution(int board[][]) 
  { 
      for (int i = 0; i < N; i++) { 
          for (int j = 0; j < N; j++) 
              System.out.print(" " + board[i][j]  + " "); 
          
          System.out.println(); 
      } 
  } 
  
  private void find() {
	  
	  int board[][] = { { 0, 0, 0, 0 }, 
              { 0, 0, 0, 0 }, 
              { 0, 0, 0, 0 }, 
              { 0, 0, 0, 0 } 
    };

	findHelper(board, 0);
	
  }

  private boolean findHelper(int boars[][], int column) {
	  if(column == N) {
		 return true; 
	  }else {

	  }
	  return false;
  }

}
