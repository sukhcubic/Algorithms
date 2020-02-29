import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class GraphDFS{
//https://www.youtube.com/watch?v=9RHO6jU--GU
//https://www.youtube.com/watch?v=TIbUeeksXcI DFS BFS
//https://www.youtube.com/watch?v=zaBhtODEL0w DFS BFS
//https://www.udemy.com/course/datastructurescncpp/learn/lecture/13193676#overview
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
                while(node.children.size()>0){
                    Node child = node.children.get(0);


                }
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
