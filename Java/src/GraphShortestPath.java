
//Explanation: https://www.youtube.com/watch?v=0XgVhsMOcQM&list=PLI1t_8YX-ApvMthLj56t1Rf-Buio5Y8KL&index=4

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphShortestPath {

    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i < vertices; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(int a, int b) {
            adjacencylist[a].add(b);
            adjacencylist[b].add(a); //for undirected graph
        }
    }
    //Using BFS
    List<Integer> shortestReach(Graph graph, int start, int target){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        result.add(start);
        while (!queue.isEmpty()){
            int val  = queue.remove();
            LinkedList<Integer> list = graph.adjacencylist[val];
            for (int node:list) {
                if(node){
                    queue.add(node);
                }
            }

        }

        return result;
    }

    public static void main(String args[]){
        int vertex = 4;
        Graph graph = new Graph(vertex);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(2, 4);

        GraphShortestPath path = new GraphShortestPath();
        for (Integer list:path.shortestReach(graph, 0, 6)) {
            System.out.println(list);
        }
    }
}
