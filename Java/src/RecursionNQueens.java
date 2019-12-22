class RecursionNQueens{
// Explanation https://www.youtube.com/watch?v=xFv_Hl4B83A

//Explanation	https://www.bilibili.com/video/av21619854?p=12   starting at 14:00

  int N = 4;

  public static void main(String[] args) {
  RecursionNQueens nq = new RecursionNQueens();
    nq.find();
  }
  
  private boolean isValid(int row, int col) {
	  
	  return false;
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
