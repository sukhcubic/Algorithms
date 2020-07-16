import java.util.*;

public class GraphTopologicalSort {
    static class Graph {
        int vertices;
        LinkedList<Integer> adjacencylist;

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
        }
    }

    private Deque<Integer> sort(Graph graph){
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        //Total vetices. Currently fixed to int but we can upgrade to all data types
        for(int i = 0; i< graph.vertices; i++){
            if(!visited.contains(i)){
                sortHelper(graph, i, stack, visited);
            }
        }
        return  stack;
    }

    private void sortHelper(Graph graph, int node, Deque<Integer> stack, Set<Integer> visited){
        visited.add(node);
        LinkedList<Integer> n = graph.adjacencylist;
        for (int i : n) {
            sortHelper(graph, i, stack, visited);
        }
        stack.add(node);
    }


    public static void main(String args[]){
        int vertex = 6;
        Graph graph = new Graph(vertex);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 4);

        GraphTopologicalSort order = new GraphTopologicalSort();
        
        Deque<Integer> result = order.sort(graph);
        while(!result.isEmpty()){
            System.out.println(result.poll());
        }
    }
}

