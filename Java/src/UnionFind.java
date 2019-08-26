
import java.util.HashMap;
import java.util.Map;

public class UnionFind {

	private Map<Long, Node> map = new HashMap<>();

	class Node {
		long data;
		Node parent;
		int rank;
	}

	public void makeSet(long data) {
		Node node = new Node();
		node.data = data;
		node.parent = node;
		node.rank = 0;
		map.put(data, node);
	}

	public boolean union(long data1, long data2) {
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);

		Node root1 = findRoot(node1);
		Node root2 = findRoot(node2);

		if (root1.data == root2.data) {
			return false;
		} else {
			if (root1.rank >= root2.rank) {
				root2.parent = root1;
				root1.rank = root2.rank == root1.rank ? root1.rank + 1 : root1.rank;
			} else {
				root1.parent = root2;
			}

		}

		return true;
	}

	public long findRoot(long data) {
		return findRoot(map.get(data)).data;
	}

	/**
	 * Find and path compression.
	 */
	private Node findRoot(Node node) {
		Node parent = node.parent;

		if (parent == node) {
			return parent;
		}

		node.parent = findRoot(parent);

		return node.parent;
	}

	public static void main(String args[]) {
		UnionFind uf = new UnionFind();
		uf.makeSet(1);
		uf.makeSet(2);
		uf.makeSet(3);
		uf.makeSet(4);
		uf.makeSet(5);
		uf.makeSet(6);
		uf.makeSet(7);

		uf.union(1, 2);
		uf.union(2, 3);
		uf.union(4, 5);
		uf.union(6, 7);
		uf.union(5, 6);
		uf.union(3, 7);

		System.out.println(uf.findRoot(1));
		System.out.println(uf.findRoot(2));
		System.out.println(uf.findRoot(3));
		System.out.println(uf.findRoot(4));
		System.out.println(uf.findRoot(5));
		System.out.println(uf.findRoot(6));
		System.out.println(uf.findRoot(7));
	}
}