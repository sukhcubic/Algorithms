import java.util.*;
//Problem: https://leetcode.com/problems/word-search-ii/
//Exp: https://www.programcreek.com/2014/06/leetcode-word-search-ii-java/
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
    
    // Second method using Trie data structure
    
 List<String> wordSearch(char[][] board,  String[] list){
        List<String> words = new ArrayList<>();
        int row = board.length;
        int col = board[0].length;

        TrieNode node = new TrieNode();
        //Add all the word list to trie data structure
        addWord(list, node);


        for (int r = 0; r < board.length; r++){
            for(int c = 0; c<board[0].length; c++) {
                helper(board, r, c, words, "", node);
            }
        }
        return words;
    }

    private void helper(char[][] board, int r, int c, List<String> words, String word, TrieNode node) {

        int m=board.length;
        int n=board[0].length;

        if(r<0 || c<0||r>=m||c>=n){
            return;
        }
        word += board[r][c];
        if(search(word,node)){
            words.add(word);
        }

        if( board[r][c] != '#') {
            //Mark visited
            board[r][c] = '#';
            helper(board, r + 1, c, words, word, node);
            helper(board, r - 1, c, words, word, node);
            helper(board, r, c + 1, words, word, node);
            helper(board, r, c - 1, words, word, node);
            board[r][c] = word.charAt(word.length()-1);
        }

    }

    class TrieNode{
        Map<Character, TrieNode> children;
        boolean endOfWord;
        public TrieNode(){
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    void addWord(String[] words, TrieNode node){
        for (String word: words){
            char[] chars = word.toCharArray();
            TrieNode trieNode = node;
            for (int i =0; i< words.length; i++){
                char ch = chars[i];
                TrieNode node1 = trieNode.children.get(ch);
                if(node1 == null){
                    trieNode.children.put(ch, new TrieNode());
                }
                trieNode = node1;
                //or put end of word outside loop
//                if(i == words.length-1){
//                    trieNode.endOfWord = true;
//                }
            }
            trieNode.endOfWord = true;
        }
    }

    boolean search(String word, TrieNode rootNode){
        TrieNode node = rootNode;

        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode nod = node.children.get(ch);
            if(nod == null){
                return false;
            }
            if(nod.endOfWord){
                return true;
            }
            node = nod;
        }
        return false;
    }

    boolean searchPrefix(String prefix, TrieNode rootNode){
        TrieNode node = rootNode;
        for (int i = 0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            TrieNode nod = node.children.get(ch);
            if(nod == null){
                return false;
            }
            if(i == prefix.length()-1){
                return true;
            }
            node = nod;
        }

        return false;
    }

    public static void main(String args[]){
        char board[][] = {{'a', 's', 'c'},
                          {'a', 'o', 'c' },
                          {'a', 'n', 'u'}};

        String[] words = {"hi", "aou", "aoc", "aaa", "sonu", "nos"};
        GraphWordListSearch graphWordSearch = new GraphWordListSearch();
        System.out.println("Word list exited in board: ");
//        for (String word:graphWordSearch.exist(board, words)) {
//            System.out.println(word);
//        }
        for (String word:graphWordSearch.wordSearch(board, words)) {
            System.out.println(word);
        }
    }
}
