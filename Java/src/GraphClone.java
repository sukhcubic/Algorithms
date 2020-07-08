import java.util.*;

public class GraphClone {

    //BFS
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneBFS(Node node){
        if (node == null) {
            return node;
        }
        HashMap<Node, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        //clone new node and added cloned elements later to list
        visited.put(node, new Node(node.val, new ArrayList<>()));

        while(!q.isEmpty()){
            Node node1 = q.poll();
            List<Node> list = node1.neighbors;
            for(Node node2:node1.neighbors) {
                if (!visited.containsKey(node2)) {
                    visited.put(node2, new Node(node2.val, new ArrayList<>()));
                }
                visited.get(node1).neighbors.add(node2);
            }
        }
        return visited.get(node);
    }

    
    //DFS
    HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node){

        if(node == null){
            return node;
        }

        Node node2 = new Node(node.val , new ArrayList<>());
        visited.put(node, node2);
        for (Node node1:node.neighbors) {
            if(!visited.containsKey(node1)){
                visited.get(node).neighbors.add(cloneGraph(node1));
            }else{
                visited.get(node).neighbors.add(visited.get(node1));
            }
        }
        return visited.get(node);
    }

    
}
