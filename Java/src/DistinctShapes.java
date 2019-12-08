import java.util.HashSet;
import java.util.Set;

public class DistinctShapes {
	public static int dfs(int[][] matrix, int row, int column, int x, int y, Set<String> s) {
		// Base case
		if (row < 0 || column < 0 || row >= matrix.length || column >= matrix[row].length || matrix[row][column] == 0) {
			return 0;
		}
		// Already visited
		matrix[row][column] = 0;
		s.add((row - x) + "-" + (column - y));
		dfs(matrix, row, column + 1, x, y, s);
		dfs(matrix, row, column - 1, x, y, s);
		dfs(matrix, row + 1, column, x, y, s);
		dfs(matrix, row - 1, column, x, y, s);

		return 1;
	}

	public static int numberOfIsland(int[][] matrix) {
		Set<String> distinct = new HashSet<>();
		for (int row = 0; row < matrix.length; row++) {

			for (int column = 0; column < matrix[row].length; column++) {

				if (matrix[row][column] == 1) {
					Set<String> set = new HashSet<>();
					dfs(matrix, row, column, row, column, set);
					distinct.add(set.toString());
				}
			}
		}
		return distinct.size();
	}

	public static void main(String args[]) {
		int[][] matrix = { { 0, 1, 0, 0, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 0, 0, 1 }, { 0, 1, 1, 1, 1 } };
		System.out.print(DistinctShapes.numberOfIsland(matrix));
	}

}
