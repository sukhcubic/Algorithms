
//Explanation: https://www.youtube.com/watch?v=0XgVhsMOcQM&list=PLI1t_8YX-ApvMthLj56t1Rf-Buio5Y8KL&index=4
//https://medium.com/better-programming/5-ways-to-find-the-shortest-path-in-a-graph-88cfefd0030f

//Explanation: https://www.youtube.com/watch?v=0XgVhsMOcQM&list=PLI1t_8YX-ApvMthLj56t1Rf-Buio5Y8KL&index=4
//Best Example: https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
import java.util.*;

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
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        result.add(start);
        visited.add(start);
        // Pred stores previous node location so we can list path. Initially set to -1.
        int[] pred = new int[graph.vertices];
        Arrays.fill(pred, -1);

        while (!queue.isEmpty()){
            int val  = queue.remove();
            LinkedList<Integer> list = graph.adjacencylist[val];
            for (int node:list) {
                if(!visited.contains(node)){
                    queue.add(node);
                    visited.add(node);
                    //store parent of current node
                    pred[node] = val;
                    if(node == target){
                        break;
                    }
                }
            }

        }
        //Loop through found destination to track all parents
        int dest = target;
        result.add(dest);
        while (pred[dest]  != -1){
            result.add(pred[dest]);
            dest = pred[dest];
        }

        return result;
    }

    public static void main(String args[]){
        int vertex = 7;
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

