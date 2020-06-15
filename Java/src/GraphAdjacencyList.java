import java.util.ArrayList;
import java.util.List;

public class GraphAdjacencyList {
    List<List<Integer>> value = new ArrayList<>();

    GraphAdjacencyList(int nodes){
        for (int i = 0; i < nodes; i++) {
            value.add(i, new ArrayList<Integer>());
        }
    }

    private void addEdge(int a, int b) {
        value.get(a).add(b);
        //Because undirected graph
        value.get(a).add(b);
    }


    public static void main(String args[]){
        GraphAdjacencyList graphList = new GraphAdjacencyList(5);
        graphList.addEdge(0,1);
        graphList.addEdge(0,2);
        graphList.addEdge(0,3);
        graphList.addEdge(3,4);
        graphList.addEdge(4,1);
    }
}
