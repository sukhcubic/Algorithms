import java.util.*;

public class GraphWordListSearch {

    private Set<String> exist(char[][] board, String[] list) {
        Set<String> existedList = new HashSet<>();
        Set<String> wordSet  = new HashSet<>();
        for (String word:list) {
            wordSet.add(word);
        }
        for (int row = 0; row < board.length; row++){
            for(int col = 0; col<board[0].length; col++) {
                helper(board, row, col, wordSet, existedList, "");
            }
        }
        return existedList;
    }
    public void helper(char[][] board, int row, int col, Set<String> wordSet,  Set<String> foundWords,  String word ){
        if(wordSet.contains(word)){
            foundWords.add(word);
        }
        if(isValid(row,col,board) && board[row][col] != '#'){
            word += board[row][col];
            board[row][col] = '#';
            helper(board, row, col+1, wordSet, foundWords, word);
            helper(board, row, col-1, wordSet, foundWords, word);
            helper(board, row+1, col, wordSet, foundWords, word);
            helper(board, row-1, col, wordSet, foundWords, word);
            board[row][col] = word.charAt(word.length()-1);
        }
    }

    boolean isValid(int row, int col, char[][] board){
        if(row<0|| row == board.length|| col<0 ||col == board[0].length) {
                return false;
        }
        return true;
    }
    public static void main(String args[]){
        char board[][] = {{'a', 's', 'c'},
                          {'a', 'o', 'c' },
                          {'a', 'n', 'u'}};

        String[] words = {"hi", "aou", "aoc", "aaa", "sonu", "nos"};
        GraphWordListSearch graphWordSearch = new GraphWordListSearch();
        System.out.println("Word list exited in board: ");
        for (String word:graphWordSearch.exist(board, words)) {
            System.out.println(word);
        }
    }
}
