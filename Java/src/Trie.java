import java.util.HashMap;
import java.util.Map;
//Ref:https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/Trie.java
//Expplanation: https://www.youtube.com/watch?v=AXjmTQ8LEoI
//https://www.youtube.com/channel/UC1KViVs3h7Y1ZqyxRbS8rUg/videos. TRIE
//https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/TrieSET.java.html

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
    boolean searchRecurively(String word){
        return searchelper(rootNode, word, 0);
    }

    boolean searchelper(TrieNode node, String word, int index){

        if(word.length() == index){
            return node.endOfWord;
        }
        char ch = word.charAt(index);
        TrieNode nod = node.children.get(ch);

        if(nod == null){
            return false;
        }
        return searchelper(nod, word, index+1);
    }
    
    //Delete
        /**
     * Returns true if parent should delete the mapping
     */
    boolean deleteHelper(TrieNode node, String word, int index){

        if(word.length() == index){
            if (!node.endOfWord) {
                return false;
            }
            node.endOfWord = false;
            //Check if node has more char if not return true so we can delete node
            if(node.children.size()>0){
                return false;
            }
            return true;
        }
        char ch = word.charAt(index);
        TrieNode nod = node.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean deleteNode = deleteHelper(nod, word,   index+1);
        //if true is returned then delete the mapping of character and trienode reference from map.
        if (deleteNode) {
            // This removes node and char from map because node is mapped as key:value pair
            node.children.remove(ch);
            //Check if node has more char if not return true so we can delete node from stack
            if(node.children.size()>0){
                return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String arge[]){
        Trie trie = new Trie();
        trie.insertWord("hello");
        trie.insertWord("world");
        trie.insertWord("hi");
        System.out.println(trie.search("world"));
        System.out.println(trie.deleteWord("world"));
        System.out.println(trie.search("world"));
    }
}
