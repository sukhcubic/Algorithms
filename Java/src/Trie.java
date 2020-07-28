import java.util.HashMap;
import java.util.Map;

public class Trie {

    class TrieNode{
        Map<Character, TrieNode> children;
        boolean endOfWord;
        public TrieNode(){
            children = new HashMap<>();
            endOfWord = false;
        }
    }


    private final TrieNode rootNode;

    public Trie(){
        rootNode = new TrieNode();
    }

    //Iterative
    public void insertWord(String word){
        TrieNode currentNode = rootNode;
        for(int i = 0; i< word.length(); i++){
           char ch = word.charAt(i);
           TrieNode node = currentNode.children.get(ch);
           if(node == null){
               node = new TrieNode();
               currentNode.children.put(ch , node );
           }
           currentNode = node;
        }
        currentNode.endOfWord = true;
    }

    //recursive
    public void inserRecursively(String s){
        insertHelper(rootNode,  s,  0);
    }
    
    void insertHelper(TrieNode node, String word, int index){
        
    }
}
