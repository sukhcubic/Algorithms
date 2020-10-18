import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryVerticalOrderTraversal {
    static Map<Integer, List<Integer>> map = new HashMap<>();
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

//TODO: Sorted order




// Not Sorted order
    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ll = new ArrayList<>();
        helper(root, 0);

        for (Map.Entry<Integer ,List<Integer> > ent :map.entrySet()){
            System.out.println("sss " + ent.getValue());
        }
        return null;
    }
    static void helper(TreeNode node, int position){
        if(node == null){
            return;
        }
        System.out.println(node.val);
         if(map.containsKey(position)){
             List<Integer>  lst = map.get(position);
             lst.add(node.val);
             map.put(position,lst);
         }else{
             List<Integer>  lst = new ArrayList<>();
             lst.add(node.val);
             map.put(position,lst);
         }
         helper(node.left, position-1);
         helper(node.right, position+1);
    }

    
    
    //
      //https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/892137/Java-DFS-Map-and-collection-solution
    public static class EntryNode implements Comparable<EntryNode>{
        int val;
        int height;

        public EntryNode(int val, int height) {
            this.val = val;
            this.height = height;
        }

        public int compareTo(EntryNode node) {
            // use case when same height need to be sorted based on value
            return height == node.height ? val - node.val : height - node.height;
        }
    }

    static Map<Integer, List<EntryNode>> map = new HashMap<>();

    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, 0);

        for (Map.Entry<Integer,List<EntryNode>> entry :map.entrySet()){
            Collections.sort(entry.getValue());
            System.out.println("sss " + entry.getValue());
            List<Integer> values = new ArrayList<>(entry.getValue().size());
            for(EntryNode entryNode : entry.getValue()) {
                values.add(entryNode.val);
            }
            result.add(values);
        }
        return result;
    }
    static void helper(TreeNode node, int x, int y){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        if(map.containsKey(x)){
            List<EntryNode>  lst = map.get(x);
            lst.add(new EntryNode(node.val, y));
            map.put(x,lst);
        }else{
            List<EntryNode>  lst = new ArrayList<>();
            lst.add(new EntryNode(node.val, y));
            map.put(x,lst);
        }
        helper(node.left, x-1, y-1);
        helper(node.right, x+1, y-1);
    }



    //Another way
    //stores the y-position of each node
    HashMap<Integer, Integer> ymap = new HashMap<>();
    //stores each x-position seen and the nodes that have this same x-position
    TreeMap<Integer, List<Integer>> xmap = new TreeMap<>();

    public List<List<Integer>> verticalTravel(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        dfs(root, 0, 0);
        for(Integer i : xmap.keySet()){
            List<Integer> list = xmap.get(i);
            Collections.sort(list, (a,b) -> ymap.get(a) == ymap.get(b) ? a-b : ymap.get(b) -
                    ymap.get(a));
            lists.add(list);
        }
        return lists;
    }
    public void dfs(TreeNode root, int x, int y){
        if(root==null) return;

        List<Integer> list = xmap.getOrDefault(x, new ArrayList<Integer>());
        list.add(root.val);
        xmap.put(x, list);
        ymap.put(root.val, y);

        dfs(root.left, x - 1, y - 1);
        dfs(root.right, x + 1, y - 1);
    }


    public static void main(String args[])
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        verticalTraversal(root);
    }
}
