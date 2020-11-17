import java.util.*;
//Good explanation:  https://www.youtube.com/watch?v=ddTC4Zovtbc
//https://www.youtube.com/watch?v=cIBFEhD77b4
public class GraphTopologicalSort {
    static class Graph {
        List<List<Integer>> value = new ArrayList<>();

        Graph(int nodes){
            for (int i = 0; i < nodes; i++) {
                value.add(i, new ArrayList<Integer>());
            }
        }

        private void addEdge(int a, int b) {
            value.get(a).add(b);
            //Because undirected graph
            value.get(b).add(a);
        }
    }
    //Pick a node from graph and visit all ites cheldern of node does not have any children add to the stack.
    // While visiting children mark node visited. If explore all childern pick another unvisited.
    private Deque<Integer> sort(Graph graph){
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        //Total vetices. Currently fixed to int but we can upgrade to all data types
        for(int i = 0; i< graph.value.size(); i++){
            if(!visited.contains(i)){
                sortHelper(graph, i, stack, visited);
            }
        }
        return  stack;
    }

    private void sortHelper(Graph graph, int node, Deque<Integer> stack, Set<Integer> visited){
        visited.add(node);
        List<Integer> n = graph.value.get(node);
        for (int i : n) {
            if(!visited.contains(i)) {
                sortHelper(graph, i, stack, visited);
            }
        }
        stack.add(node);
    }


    public static void main(String args[]){
        int vertex = 6;
        Graph graph = new Graph(vertex);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(5, 4);

        GraphTopologicalSort order = new GraphTopologicalSort();

        Deque<Integer> result = order.sort(graph);
        while(!result.isEmpty()){
            System.out.println(result.poll());
        }
    }
}

