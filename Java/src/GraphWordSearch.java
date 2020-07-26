//https://leetcode.com/problems/word-search-ii/
//https://leetcode.com/problems/word-search/
class GraphWordSearch{
     public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(searchHelper(board, 0, 0 , word)){
                    break;
                } 
            }
        }
        return false;
    }
    
    private boolean searchHelper(char[][] board, int row, int col, String word){
      
        return false;
    }

    public static void main(String args[]){
        char board[][] = {{'a', 's', 'c'},
                          {'a', 'o', 'c' },
                          {'a', 'n', 'u'}};
        
        GraphWordSearch graphWordSearch = new GraphWordSearch();
        graphWordSearch.exist(board, "sonu");
    }
  

}
