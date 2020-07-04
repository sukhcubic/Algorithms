//https://www.youtube.com/watch?v=oP2-8ysT3QQ
//https://www.youtube.com/watch?v=oP2-8ysT3QQ&t=88s
//https://www.cs.princeton.edu/courses/archive/spr02/cs226/lectures/mst-4up.pdf
//https://algorithms.tutorialhorizon.com/prims-minimum-spanning-tree-mst-using-adjacency-list-and-priority-queue-without-decrease-key-in-oelogv/
//https://www.coursera.org/learn/algorithms-part2/lecture/HoHKu/prims-algorithm
//https://www.geeksforgeeks.org/prims-mst-for-adjacency-list-representation-greedy-algo-6/
//ReF: https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/PrimMST.java

import javafx.util.Pair;

import java.util.*;

//
//import java.util.*;
//
public class GraphPrimsMST {

    static class ResultSet {
        int parent;
        int weight;
    }

    public ResultSet[] primMST(GraphWeighted graph){

        int vertices = graph.vertices;
        boolean[] mst = new boolean[vertices];
        ResultSet[] results = new ResultSet[vertices];
        int [] key = new int[vertices];  //keys used to store the key to know whether priority queue update is required

        //Initialize all the keys to infinity and
        //initialize resultSet for all the vertices
        for (int i = 0; i <vertices ; i++) {
            key[i] = Integer.MAX_VALUE;
            results[i] = new ResultSet();
        }

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });

        key[0] = 0;
        Pair<Integer, Integer> p0 = new Pair<>(key[0], 0);
        pq.offer(p0);

        results[0]  = new ResultSet();
        results[0].parent = -1;

        while(!pq.isEmpty()){
            //extract the min
            Pair<Integer, Integer> extractedPair = pq.poll();

            //extracted vertex
            int extractedVertex = extractedPair.getValue();
            mst[extractedVertex] = true;

            LinkedList<GraphWeighted.Edge> list =  graph.adjacencylist[extractedVertex];

            for (int i = 0; i <list.size() ; i++) {
                GraphWeighted.Edge edge = list.get(i);

                if (mst[edge.destination] == false) {

                    if (key[edge.destination] > edge.weight) {
                        Pair<Integer, Integer> p = new Pair<>(edge.weight, edge.destination);
                        pq.offer(p);
                        results[edge.destination].parent = extractedVertex;
                        results[edge.destination].weight = edge.weight;
                        key[edge.destination] = edge.weight;
                    }
                }
            }

        }

        for (int keys: key
             ) {
            System.out.println("a + "+ keys);

        }
     return results;
    }


    // class to represent a node in PriorityQueue
    // Stores a vertex and its corresponding
    // key value
    class Node {
        int vertex;
        int key;
    }


    public void primMst(GraphWeighted graph){

        int vertices = graph.vertices;

        // Check if vertex is visited or not
        boolean[] mst = new boolean[vertices];

        //Store parent of a vertex
        int[] parent = new int[vertices];
        Node[] node = new Node[vertices];

        for (int i = 0; i<vertices; i++){
          node[i] = new Node();
        }

        //Intially set each node value to infinity
        for (int i = 0; i<vertices; i++){

            node[i].key = Integer.MAX_VALUE;
            node[i].vertex = i;
        }

        // Include the source vertex in mstset
        mst[0] = true;

        // Set key value to 0
        // so that it is extracted first
        // out of PriorityQueue
        node[0].key = 0;

        // Comparator class created for PriorityQueue
        // returns 1 if node0.key > node1.key
        // returns 0 if node0.key < node1.key and
        // returns -1 otherwise
        // Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n) in java. Add is same o(logN)time as priority Queue
        TreeSet<Node> treeSet = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.key-o2.key;
            }
        });

        treeSet.add(node[0]);

        while(!treeSet.isEmpty()){

            Node dataNode = treeSet.pollFirst();

            mst[dataNode.vertex] = true;
            LinkedList<GraphWeighted.Edge> edgeList = graph.adjacencylist[ dataNode.vertex];
             for (GraphWeighted.Edge edge: edgeList) {
                if(mst[edge.destination] == false && node[edge.destination].key > edge.weight) {
                    treeSet.remove(node[edge.destination]);
                    //update weight
                    node[edge.destination].key = edge.weight;
                    treeSet.add(node[edge.destination]);
                    //set parent
                    parent[edge.destination] = dataNode.vertex;
                }
            }
        }

        int l = parent.length;
        for (int i:parent) {
            System.out.println("result = "+ i);
        }
    }

    public static void main(String args[]){
        int vertex = 6;
        GraphWeighted graph = new GraphWeighted(vertex);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        GraphPrimsMST prims = new GraphPrimsMST();
        ResultSet[] edges = prims.primMST(graph);
        int i = 0;
        for(ResultSet edge : edges){

            if(i==0){
                i++;
                continue;
            }
            System.out.println(edge.parent);
        }

        System.out.println("/n");

        prims.primMst(graph);
   }
}
