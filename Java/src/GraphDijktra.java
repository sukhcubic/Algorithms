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
        boolean[] visited = new boolean[vertices];
        //distance used to store the distance of vertex from a source
        int [] distance = new int[vertices];

        //Initialize all the distance to infinityOL
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
                visited[extractedVertex] = true;
                LinkedList<Edge>  nodes = graph.adjacencylist[pair.getValue()];
                for (int i = 0; i < nodes.size(); i++) {
                    Edge edge = nodes.get(i);
                    int dest = edge.destination;
                    if(visited[dest] == false){
                        int newKey = distance[extractedVertex] + edge.weight;
                        int currentkey = distance[dest];

                        if(currentkey>newKey){
                            Pair<Integer, Integer> p = new Pair<>(newKey , dest);
                            pq.offer(p);
                            distance[dest] = newKey;
                        }
                    }
                }
            }
        }

        for (int i:distance) {
            System.out.println("result = "+ i);
        }

        System.out.println(" Total cost = ");
    }

    class Node {
        int vertex;
        int key;
    }

    private void shortestPath2(Graph graph) {
        int vertices = graph.vertices;
        boolean[] visited = new boolean[vertices];
       // int[] distance = new int[vertices];
        Node[] node = new Node[vertices];

        for (int i = 0; i<vertices; i++){
            node[i] = new Node();
        }

        for (int i = 0; i < node.length; i++){
            node[i].key = Integer.MAX_VALUE;
            node[i].vertex = i;
        }

        node[0].key = 0;
        TreeSet<Node> treeSet = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.key - o2.key;
            }
        });

        treeSet.add(node[0]);

        while (!treeSet.isEmpty()){
           Node dataNode = treeSet.pollFirst();
           int extracted = dataNode.vertex;
          if(visited[extracted] == false) {
              visited[extracted] = true;
               LinkedList<Edge> edges = graph.adjacencylist[extracted];
              for (int i = 0; i < edges.size(); i++) {
                  Edge edge = edges.get(i);
                  int dest = edge.destination;
                  if (visited[dest] == false) {
                       int newkey = node[extracted].key + edge.weight;
                       int curr = node[dest].key;
                       if (curr > newkey) {
                           Node node1 = new Node();
                           node1.vertex = dest;
                           node1.key = newkey;
                           treeSet.add(node1);
                           node[dest].key = newkey;
                       }
                   }
               }
           }

        }
        for (Node i:node) {
            System.out.println("result = "+ i.key);
        }
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
        path.shortestPath2(graph);
    }
}
