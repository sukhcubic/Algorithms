
public class NumberOfIslands {
	public static int dfs(int[][] matrix, int row, int column) {
		if (row < 0 || column < 0 || row >= matrix.length || column >= matrix[row].length || matrix[row][column] == 0) {
			return 0;
		}
		matrix[row][column] = 0;
		dfs(matrix, row + 1, column);
		dfs(matrix, row - 1, column);
		dfs(matrix, row, column + 1);
		dfs(matrix, row, column - 1);
		return 1;
	}

	public static int numberOfIsland(int[][] matrix) {
		int max = 0;
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if (matrix[row][column] == 1) {
					max += dfs(matrix, row, column);
				}
			}
		}
		return max;
	}

	public static void main(String args[]) {

		int[][] ar = { { 0, 1, 0, 0, 0 }, { 0, 1, 1, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
		System.out.print(NumberOfIslands.numberOfIsland(ar));
	}

}
