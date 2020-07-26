//https://leetcode.com/problems/word-search-ii/
//https://leetcode.com/problems/word-search/
class GraphWordSearch{
        //Backtracking
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                 if(searchHelper(board, i, j , word, 0)){
                     return true;
                 };
            }
        }
        return false;
    }

    private boolean searchHelper(char[][] board, int row, int col, String word, int index){

        //we found a match
        if(index == word.length()){
            return true;
        }

        if(isValid(board, row, col, word, index)) {
            //Choose/visited
            board[row][col] = '#';

            //Explore
            if (searchHelper(board, row, col + 1, word, index + 1)) {
                return true;
            }
            ;
            if (searchHelper(board, row, col - 1, word, index + 1)) {
                return true;
            }
            ;
            if (searchHelper(board, row + 1, col, word, index + 1)) {
                return true;
            }
            ;
            if (searchHelper(board, row - 1, col, word, index + 1)) {
                return true;
            }
            ;

            //Un-choose/unvisited
            board[row][col] = word.charAt(index);
        }

        return false;
    }

    boolean isValid(char[][] board,  int row, int col, String word, int index){
        if (row < 0 || row == board.length || col < 0 || col == board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }
        return true;
    }
        //Other way of doing it
//      private boolean searchHelper(char[][] board, int row, int col, String word, int index){

//         //we found a match
//         if(index == word.length()){
//             return true;
//         }

//         //Out of bound or mismatch so stop
//         if (row < 0 || row == board.length || col < 0 || col == board[0].length
//                 || board[row][col] != word.charAt(index)) {
//             return false;
//         }

//         //Choose/visited
//         board[row][col] = '#';

//         //Explore
//         if(searchHelper(board, row, col + 1, word, index + 1)){
//             return true;
//         };
//         if(searchHelper(board, row, col - 1, word, index + 1)){
//             return true;
//         };
//         if(searchHelper(board, row + 1, col, word, index + 1)){
//             return true;
//         };
//         if(searchHelper(board, row - 1, col, word, index + 1)){
//             return true;
//         };

//         //Un-choose/unvisited
//         board[row][col] = word.charAt(index);

//         return false;
//     }    
        
    public static void main(String args[]){
        char board[][] = {{'a', 's', 'c'},
                          {'a', 'o', 'c' },
                          {'a', 'n', 'u'}};

        GraphWordSearch graphWordSearch = new GraphWordSearch();
        System.out.println(graphWordSearch.exist(board, "aax"));
    }
}
