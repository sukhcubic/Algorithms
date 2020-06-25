
import java.util.*;

public class GraphAdjacencyListMap<T> {

    private List<Edge<T>> allEdges;
    private Map<Long,Vertex<T>> allVertex;
    boolean isDirected = false;

    public GraphAdjacencyListMap(boolean isDirected){
        allEdges = new ArrayList<Edge<T>>();
        allVertex = new HashMap<Long,Vertex<T>>();
        this.isDirected = isDirected;
    }

    class Vertex<T> {
        long id;
        private T data;
        private List<Edge<T>> edges = new ArrayList<>();
        private List<Vertex<T>> adjacentVertex = new ArrayList<>();

        Vertex(long id){
            this.id = id;
        }

        public long getId(){
            return id;
        }

        public void setData(T data){
            this.data = data;
        }

        public T getData(){
            return data;
        }

        public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
            edges.add(e);
            adjacentVertex.add(v);
        }

        public String toString(){
            return String.valueOf(id);
        }

        public List<Vertex<T>> getAdjacentVertexes(){
            return adjacentVertex;
        }

        public List<Edge<T>> getEdges(){
            return edges;
        }

        public int getDegree(){
            return edges.size();
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (id ^ (id >>> 32));
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (id != other.id)
                return false;
            return true;
        }
    }


    class Edge<T> {
        private boolean isDirected = false;
        private Vertex<T> vertex1;
        private Vertex<T> vertex2;
        private int weight;

        Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }

        Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
            this.isDirected = isDirected;
        }

        Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.isDirected = isDirected;
        }

        Vertex<T> getVertex1() {
            return vertex1;
        }

        Vertex<T> getVertex2() {
            return vertex2;
        }

        int getWeight() {
            return weight;
        }

        public boolean isDirected() {
            return isDirected;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
            result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Edge other = (Edge) obj;
            if (vertex1 == null) {
                if (other.vertex1 != null)
                    return false;
            } else if (!vertex1.equals(other.vertex1))
                return false;
            if (vertex2 == null) {
                if (other.vertex2 != null)
                    return false;
            } else if (!vertex2.equals(other.vertex2))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1
                    + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
        }

    }

//    Map<Long, Vertex> vertexList;
//    List<Edge> edgeList;
//
//    public GraphAdjacencyListMap() {
//        vertexList = new HashMap<>();
//        edgeList = new ArrayList<>();
//    }
//
////    public void init(int n) {
////        for(int i=0; i<n; i++) {
////            Vertex v = new Vertex(i+1);
////            vertexList.add(v);
////        }
////    }
//
//    public void addEdge(int i, int j) {
//
//    }
//    static class Vertex {
//        private int element;
//        private HashMap<Vertex, Edge> neighborList;
//        public Vertex(int element) {
//            this.element = element;
//            neighborList = new HashMap<>();
//        }
//        public Collection<Edge> outgoingEdges() {
//            return neighborList.values();
//        }
//        public void addNeighbor(Vertex v, Edge e) {
//            neighborList.put(v, e);
//        }
//        public int getElement() {
//            return this.element;
//        }
//        public String toString() {
//            return Integer.toString(element);
//        }
//    }
//
//    static class Edge {
//        ArrayList<Vertex> endpoints;
//        public Edge(Vertex i, Vertex j) {
//            endpoints = new ArrayList<>();
//            endpoints.add(i);
//            endpoints.add(j);
//        }
//        public ArrayList<Vertex> getEndpoints() {
//            return endpoints;
//        }
//        public boolean hasEndpoint(Vertex v) {
//            if(v.getElement() == endpoints.get(0).getElement() ) {
//                return true;
//            } else if(v.getElement() == endpoints.get(1).getElement() ) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        public Vertex getOpposite(Vertex v) {
//            if(v.getElement() == endpoints.get(0).getElement() ) {
//                return endpoints.get(1);
//            } else if(v.getElement() == endpoints.get(1).getElement() ) {
//                return endpoints.get(0);
//            } else {
//                System.out.println("Endpoint 0: "+endpoints.get(0));
//                System.out.println("Endpoint 1: "+endpoints.get(1));
//                System.out.println("Checking for vertex: "+v.getElement());
//                throw new IllegalArgumentException("Vertex not an endpoint of this edge.");
//            }
//        }
//    }

}
