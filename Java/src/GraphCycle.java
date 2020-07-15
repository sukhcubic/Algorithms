import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://www.youtube.com/watch?v=n_t0a_8H8VY&feature=emb_rel_pause

//https://algotree.org/algorithms/tree_graph_traversal/dfs_detecting_cycles_in_graphs/cycle_detection_in_undirected_graphs/
/**
 * Cycle in undirected graphs can be detected easily using a depth-first search traversal.
 * While doing a depth-first search traversal, we keep track of the visited node’s parent along with the list of visited nodes.
 * During the traversal, if an adjacent node is found visited that is not the parent of the source node,
 * then we have found a cycle in the current path.
 */

//https://www.techiedelight.com/check-undirected-graph-contains-cycle-not/  DFS and BFS both
public class GraphCycle {

    Map<Integer, Boolean> visit = new HashMap<>();

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

    // Node to store vertex and its parent info in BFS
    class Node
    {
        int v, parent;

        Node(int v, int parent) {
            this.v = v;
            this.parent = parent;
        }
    }

    //BFS
    private boolean findCycle(Graph graph) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, -1));
        visit.put(0, true);
        while (!queue.isEmpty()){
            Node vertex = queue.remove();
            LinkedList<Integer> list = graph.adjacencylist[vertex.v];
            for (int edge:list) {
                if (!visited(edge)) {
                    queue.add(new Node(edge, vertex.v));
                    visit.put(edge, true);
                } else if(edge != vertex.parent){
                    //parent is different we have detected a cycle
                    return true;
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
        int vertex = 4;
        Graph graph = new Graph(vertex);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        GraphCycle path = new GraphCycle();
        System.out.println(path.findCycle(graph));
    }
}
