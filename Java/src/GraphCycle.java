import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://www.youtube.com/watch?v=n_t0a_8H8VY&feature=emb_rel_pause
public class GraphCycle {

    Map<Integer, Boolean> visit = new HashMap<>();
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge>[] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i < vertices; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);

            edge = new Edge(destination, source, weight);
            adjacencylist[destination].addFirst(edge); //for undirected graph
        }
    }

    //DFS
    private boolean findCycle(Graph graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visit.put(0, true);
        while (!queue.isEmpty()){
            int vertex = queue.poll();
            LinkedList<Edge> list = graph.adjacencylist[vertex];
            for (Edge edge:list) {
                if (visited(edge.source)) {
                    return true;
                } else {
                    queue.add(edge.source);
                }
            }
        }
        return false;
    }

    private boolean visited(Integer edge){
        return visit.containsKey(edge);
    }

    //
    private void detectCycle(Graph graph) {

    }

    public static void main(String args[]){
        int vertex = 6;
        Graph graph = new Graph(vertex);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        GraphCycle path = new GraphCycle();
        System.out.println(path.findCycle(graph));
    }
}
