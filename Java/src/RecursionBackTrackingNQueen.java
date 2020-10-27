import java.util.Arrays;
import java.util.List;
//https://www.youtube.com/watch?v=05y82cP3bJo
public class RecursionBackTrackingNQueen {
    class Position {
        int row, col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public List<List<String>> solveNQueenOneSolution(int n) {
        int[][] chess = new int[n][n];

        solveNQueenOneSolutionUtil(chess, 0, "");

        return null;
    }

    private static void solveNQueenOneSolutionUtil(int[][] chess, int row, String s) {
        if (chess.length == row) {
            System.out.println(s);
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if(isSafe(chess, row, col)){
                //choose
                chess[row][col] = 1;
                //Explore
                solveNQueenOneSolutionUtil(chess, row+1, s+row+"-"+col+ ", ");
                //Unchoose
                chess[row][col] = 0;
            }
        }

    }

    static boolean isSafe(int[][] chess, int row, int col) {

        // We are checking vertical up direction not the current row but upper row
        for (int i = row-1 , j= col ;  i >=0; i--) {
            //under attack, queen is there
            if(chess[i][j] == 1){
                return false;
            }
        }

        // We are checking upper left diagnol not the current row but upper row
        for (int i = row-1 , j= col-1 ;  i >=0 && j>=0; i--, j--) {
            //under attack, queen is there
            if(chess[i][j] == 1){
                return false;
            }
        }

        // We are checking upper right diagnol not the current row but upper row
        for (int i = row-1 , j = col+1 ;  i >=0 && j<chess.length; i--, j++) {
            //under attack, queen is there
            if(chess[i][j] == 1){
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        RecursionBackTrackingNQueen s = new RecursionBackTrackingNQueen();
        s.solveNQueenOneSolution(4);
//        Position[] positions = s.solveNQueenOneSolution(4);
//        Arrays.stream(positions).forEach(position -> System.out.println(position.row + " " + position.col));
    }
}
