import java.util.*;
// Exp: https://www.geeksforgeeks.org/find-paths-given-source-destination/
//https://www.youtube.com/watch?v=gTmtBjv8bo4&list=PLiKk3Hq32QPKkWl-rKwEsF-bayivaMJvj&index=30
public class GraphAllPaths {
// BackTracking
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



    public static void main(String args[]){
        int vertex = 7;
        Graph graph = new Graph(vertex);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(1, 5);
        graph.addEdge(4, 5);

        graph.addEdge(5, 6);
        graph.addEdge(0, 6);

        GraphAllPaths path = new GraphAllPaths();
        for (String list:path.allPaths(graph, 0, 6)) {
            System.out.println(list);
        }
    }

    private List<String> allPaths(Graph graph, int src, int dest) {
        List<String> paths = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        pathHelper(graph, paths, src, dest, visited, "" );
        return paths;
    }

    private void pathHelper(Graph graph, List<String> paths, int start, int end, Set<Integer> visited, String s){
        visited.add(start);

        s += String.valueOf(start);
        if(start == end){
            paths.add(s);
            visited.remove(start);
            return;
        }

        LinkedList<Integer> list = graph.adjacencylist[start];
        for (int node:list) {
            if(!visited.contains(node)) {
                pathHelper(graph, paths, node, end, visited, s );
            }
        }
        visited.remove(start);

    }
}
