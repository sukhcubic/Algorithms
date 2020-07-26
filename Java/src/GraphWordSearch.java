//https://leetcode.com/problems/word-search-ii/
//https://leetcode.com/problems/word-search/
class GraphWordSearch{
     public boolean exist(char[][] board, String word) {

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
