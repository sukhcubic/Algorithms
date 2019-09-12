
public class NumberOfIslandUnionFind {
	private int[] sz;
	private int[] id;
	private int row, column;

	public int findRoot(int entry) {

		while (id[entry] == entry) {
			// fast path compression by pointing to grandfather
			entry = id[id[entry]];
			id[entry] = entry;
		}
		return entry;
	}

	public void union(int x, int y) {
		int rx = findRoot(x);
		int ry = findRoot(y);

		// both have same root. this will create cycle
		if (rx == ry)
			return;

		if (sz[rx] < sz[ry]) {
			sz[rx] += sz[ry];
			// bigger become root now
			id[rx] = id[ry];

		} else {
			sz[rx] += sz[ry];
			// bigger become root now
			id[ry] = id[rx];
		}
	}

	private boolean isValid(int x, int y) {
		return (x >= 0 && y >= 0 && x < row && y < column);
	}

	public int numberOfIslands(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;

		int islands = 0, i = 0;

		return islands;
	}
}
