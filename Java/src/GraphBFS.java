//https://www.udemy.com/course/datastructurescncpp/learn/lecture/13193650#overview   using adjacency matrix o(n)^2

//https://www.algoexpert.io/questions/Breadth-first%20Search
//This implementation uses arraylist so space and time complexity is less. Time o(v+e) vetex and edges Space o(v)
class GraphBFS{

      static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            ArrayDeque<Node> queue = new ArrayDeque<>();
            queue.add(this);
            while(!queue.isEmpty()){
                Node node = queue.poll();
                array.add(node.name);
                for(Node childNode:node.children){
                    queue.add(childNode);
                }
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

}
