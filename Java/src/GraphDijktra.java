import javafx.util.Pair;

import java.util.*;

public class GraphDijkstra {

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

    private void shortestPath(Graph graph) {
        int vertices = graph.vertices;
        boolean[] SPT = new boolean[vertices];
        //distance used to store the distance of vertex from a source
        int [] distance = new int[vertices];

        //Initialize all the distance to infinity
        for (int i = 0; i <vertices ; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        //Initialize priority queue
        //override the comparator to do the sorting based keys
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                //sort using distance values
                int key1 = p1.getKey();
                int key2 = p2.getKey();
                return key1-key2;
            }
        });
        //create the pair for for the first index, 0 distance 0 index
        distance[0] = 0;
        Pair<Integer, Integer> p0 = new Pair<>(distance[0],0);
        //add it to pq
        pq.offer(p0);
        while(!pq.isEmpty()){
            Pair<Integer, Integer>  pair = pq.poll();

            int extractedVertex = pair.getValue();

            if(visited[extractedVertex] == false){
                LinkedList<Edge>  nodes = graph.adjacencylist[pair.getValue()];
                for (Edge edge :nodes) {

                }
            }
        }


//        for (int i:path) {
//            System.out.println("result = "+ i);
//        }
//
//        System.out.println(" Total cost = "+ cost);
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

        GraphDijkstra path = new GraphDijkstra();
        path.shortestPath(graph);
    }
}
