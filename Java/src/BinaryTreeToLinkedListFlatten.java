class BinaryTreeToLinkedListFlatten{
  //https://www.programcreek.com/2013/01/leetcode-flatten-binary-tree-to-linked-list/
  //http://www.crazyforcode.com/flatten-binary-tree-linked-list-in-place/
  //DFS
    public LinkedList<Node> createLevelLinkedList2(Node node){
        LinkedList<Node> list = new LinkedList<>();
        if(node != null){
            Stack<Node> stack = new Stack<>();
            stack.push(node);
            list.add(node);
            Node current = node;
            while (true){
                while(current.left != null){
                    stack.push(current);
                    list.add(current);
                    current = current.left;

                }
                current = stack.pop();
                current = current.right;
            }
        }
        return list;
    }



}
