//https://www.youtube.com/watch?v=oP2-8ysT3QQ
//https://www.youtube.com/watch?v=oP2-8ysT3QQ&t=88s
//https://www.cs.princeton.edu/courses/archive/spr02/cs226/lectures/mst-4up.pdf
//https://algorithms.tutorialhorizon.com/prims-minimum-spanning-tree-mst-using-adjacency-list-and-priority-queue-without-decrease-key-in-oelogv/
//https://www.coursera.org/learn/algorithms-part2/lecture/HoHKu/prims-algorithm
class GraphPrismMST{
	List<Edge<Integer>> resultSet = new ArrayList<>();
	PriorityQueue<Vertex<Integer>> queue = new PriorityQueue<Vertex<Integer>>();
	public List<Edge<Integer>>findMST(Graph graph){
	
		return resultSet;
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

        GraphPrismMST prims = new GraphPrismMST();
        Collection<Edge<Integer>> edges = prims.findMST(graph);
        for(Edge<Integer> edge : edges){
            System.out.println(edge);
        }
    }

}
