//https://www.youtube.com/watch?v=oP2-8ysT3QQ
//https://www.youtube.com/watch?v=oP2-8ysT3QQ&t=88s
//https://www.cs.princeton.edu/courses/archive/spr02/cs226/lectures/mst-4up.pdf
//https://algorithms.tutorialhorizon.com/prims-minimum-spanning-tree-mst-using-adjacency-list-and-priority-queue-without-decrease-key-in-oelogv/
//https://www.coursera.org/learn/algorithms-part2/lecture/HoHKu/prims-algorithm
class GraphPrismMST{
	
    public List<Edge<Integer>>findMST(Graph graph){
        List<Edge<Integer>> result = new ArrayList<>();
        BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<Vertex<Integer>>();

        Map<Vertex<Integer>,Edge<Integer>> vertexToEdge = new HashMap<>();

        for(Object v : graph.getAllVertex()){
            minHeap.add(Integer.MAX_VALUE, (Vertex) v);
        }

        Vertex<Integer> startVertex = (Vertex<Integer>) graph.getAllVertex().iterator().next();

        //for the start vertex decrease the value in heap + map to 0
        minHeap.decrease(startVertex, 0);

        //iterate till heap + map has elements in it
        while(!minHeap.empty()){
            //extract min value vertex from heap + map
            Vertex<Integer> current = minHeap.extractMin();

            //get the corresponding edge for this vertex if present and add it to final result.
            //This edge wont be present for first vertex.
            Edge<Integer> spanningTreeEdge = vertexToEdge.get(current);
            if(spanningTreeEdge != null) {
                result.add(spanningTreeEdge);
            }

            //iterate through all the adjacent vertices
            for(Edge<Integer> edge : current.getEdges()){
                Vertex<Integer> adjacent = getVertexForEdge(current, edge);
                //check if adjacent vertex exist in heap + map and weight attached with this vertex is greater than this edge weight
                if(minHeap.containsData(adjacent) && minHeap.getWeight(adjacent) > edge.getWeight()){
                    //decrease the value of adjacent vertex to this edge weight.
                    minHeap.decrease(adjacent, edge.getWeight());
                    //add vertex->edge mapping in the graph.
                    vertexToEdge.put(adjacent, edge);
                }
            }
        }
        return result;
    }

    private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e){
        return e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1();
    }

    public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(false);

        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 1, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 6, 2);
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 6, 4);

        GraphPrimsMST prims = new GraphPrimsMST();
        Collection<Edge<Integer>> edges = prims.findMST(graph);
        for(Edge<Integer> edge : edges){
            System.out.println(edge);
        }

    }

}
