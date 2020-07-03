//https://www.youtube.com/watch?v=oP2-8ysT3QQ
//https://www.youtube.com/watch?v=oP2-8ysT3QQ&t=88s
//https://www.cs.princeton.edu/courses/archive/spr02/cs226/lectures/mst-4up.pdf
//https://algorithms.tutorialhorizon.com/prims-minimum-spanning-tree-mst-using-adjacency-list-and-priority-queue-without-decrease-key-in-oelogv/
//https://www.coursera.org/learn/algorithms-part2/lecture/HoHKu/prims-algorithm

//https://algorithms.tutorialhorizon.com/prims-minimum-spanning-tree-mst-using-adjacency-list-and-priority-queue-without-decrease-key-in-oelogv/
//ReF: https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/PrimMST.java

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

                if(mst[edge.destination]== false){
                    int destination = edge.destination;
                    int newKey = edge.weight;

                    if(key[destination]>newKey) {
                        //add it to the priority queue
                        Pair<Integer, Integer> p = new Pair<>(newKey, destination);
                        pq.offer(p);
                        //update the resultSet for destination vertex
                        results[destination].parent = extractedVertex;
                        results[destination].weight = newKey;
                        //update the key[]
                        key[destination] = newKey;
                    }
                }
            }

        }

     return results;
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
        for(ResultSet edge : edges){
            System.out.println(edge.parent);
        }
   }

}
