import java.util.HashMap;
import java.util.Map;
//Ref:https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/Trie.java
//Expplanation: https://www.youtube.com/watch?v=AXjmTQ8LEoI
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
        if(index == word.length()){
            node.endOfWord = true;
            return;
        }
        char ch = word.charAt(index);
        TrieNode nod = node.children.get(ch);
        if(nod == null){
            nod = new TrieNode();
            nod.children.put(ch, nod);
        }
        insertHelper(nod, word, index+1);
    }
    
    //iterative    
    public boolean search(String word){
        TrieNode node = rootNode;

        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode nod = node.children.get(ch);
            if(nod.endOfWord){
                return true;
            }
            node = nod;
        }
        return false;
    }
    
    //recursive
}
