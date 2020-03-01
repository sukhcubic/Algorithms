import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class GraphDFS{
//https://www.youtube.com/watch?v=TIbUeeksXcI DFS BFS
//https://www.youtube.com/watch?v=zaBhtODEL0w DFS BFS
//https://www.udemy.com/course/datastructurescncpp/learn/lecture/13193676#overview
 //https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/tutorial/
  static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

     public List<String> depthFirstSearch(List<String> array) {
            Stack<Node> stack = new Stack<>();
            stack.push(this);

            while(!stack.isEmpty()){
                Node node = stack.pop();
                array.add(node.name);
                for(Node child:node.children) {
//                 	array.add(child.name);
                	stack.add(child);
                }
            }
            return array;
        }

//https://www.algoexpert.io/questions/Depth-first%20Search    
     public List<String> depthFirstSearch(List<String> array) {
            array.add(node.name);
                for(int i =0; i<children.length; i++) {
                  children.get(i).depthFirstSearch(array);
                 }
            return array;
        }
    public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
