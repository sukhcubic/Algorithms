
public class UnionFindArray {
	int[] uf;
	int[] sz;

	public void init(int N) {
		uf = new int[N];
		sz = new int[N];

		for (int i = 0; i < N; i++) {
			uf[i] = i;
			sz[i] = 1;
		}

	}

	public void union(int a, int b) {
		int root1 = findRoot(a);
		int root2 = findRoot(b);

		if (root1 == root2) {
			return;
		}

		if (sz[root1] < sz[root2]) {
			uf[root1] = root2;
			sz[root2] += sz[root1];
		} else {
			uf[root2] = root1;
			sz[root1] += sz[root2];
		}

	}

	// Find and compression by pointing to its grandparent. Half the path
	// length.
	private int findRoot(int a) {

		while (a != uf[a]) {
			uf[a] = uf[uf[a]];
			a = uf[a];
		}
		return a;

	}

	public static void main(String args[]) {
		UnionFindArray uf = new UnionFindArray();
		uf.init(8);

		uf.union(1, 2);
		uf.union(2, 3);
		uf.union(4, 5);
		uf.union(6, 7);
		uf.union(5, 6);
		uf.union(3, 7);
		//
		System.out.println(uf.findRoot(1));
		System.out.println(uf.findRoot(2));
		System.out.println(uf.findRoot(3));
		System.out.println(uf.findRoot(4));
		System.out.println(uf.findRoot(5));
		System.out.println(uf.findRoot(6));
		System.out.println(uf.findRoot(7));
	}
}
