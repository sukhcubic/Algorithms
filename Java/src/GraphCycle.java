import java.util.LinkedList;
//https://www.youtube.com/watch?v=n_t0a_8H8VY&feature=emb_rel_pause
public class GraphCycle {

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
        LinkedList<GraphDijkstra.Edge>[] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i < vertices; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            GraphDijkstra.Edge edge = new GraphDijkstra.Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);

            edge = new GraphDijkstra.Edge(destination, source, weight);
            adjacencylist[destination].addFirst(edge); //for undirected graph
        }
    }

    //DFS
    private void findCycle(Graph graph) {

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
        path.findCycle(graph);
    }
}
